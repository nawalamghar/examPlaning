package com.ensah.core.web.controllers;

import org.springframework.core.io.Resource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ensah.core.bo.*;
import com.ensah.core.services.*;
import com.ensah.core.web.models.ExamenModel;

import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping("/admin")
public class ExamenController {
	@Autowired
	ISurvService survService;
	@Autowired
	IExamenService examenService;
	@Autowired
	ISessionService sessionService;
	
	@Autowired
	ISalleService salleService;
	
	@Autowired
	ISemestreService semestreService;
	
	@Autowired
	IElementService elementService;
	
	@Autowired
	ITypeExamService typeExamService;
	
	@Autowired 
    private IAdminService adminService;
	
	@Autowired 
    private IEnsService ensService;
	
	@Autowired
    private ServletContext context;
	
	private Map<Salle,String> salles=new LinkedHashMap<Salle,String>();
	private Map<Session,String> sessions=new LinkedHashMap<Session,String>();
	private Map<TypeExam,String> typeExams=new LinkedHashMap<TypeExam,String>();
	private Map<Semestre,String> semestres=new LinkedHashMap<Semestre,String>();
	private Map<Element,String> elements=new LinkedHashMap<Element,String>();
	private Map<String,String> anneUni=new LinkedHashMap<String,String>();
	public ExamenController() {
		
	}
	public void loadLists(Model m) {
		
		anneUni.put("2022-2023","2022-2023");
		anneUni.put("2023-2024","2023-2024");
		anneUni.put("2024-2025","2024-2025");
		
		
		elements.clear();
		for(Element e : elementService.getAllElements()) {
			elements.put(e, e.getTitre());
		}
		
		salles.clear();
		for(Salle s : salleService.getAllSalles()) {
			salles.put(s, s.getNom());
		}
		
		semestres.clear();
		for(Semestre s : semestreService.getAllSemestre()) {
			semestres.put(s, s.getIntitule());
		}
		
		sessions.clear();
		for(Session s : sessionService.getAllSessions()) {
			sessions.put(s, s.getIntitule());
		}
		
		typeExams.clear();
		for(TypeExam s : typeExamService.getAllTypeExam()) {
			typeExams.put(s, s.getIntitule());
		}
		
		m.addAttribute("salleList", salles.keySet());
		m.addAttribute("semestreList", semestres);
		m.addAttribute("sessionList", sessions);
		m.addAttribute("typeExamList", typeExams);
		m.addAttribute("elementList", elements);
		m.addAttribute("anneUnList", anneUni);
	}
	
	public void setDefaultSemestre(ExamenModel exam) {
		int CurrentMonth=LocalDate.now().getMonthValue();
		if(CurrentMonth>=11 && CurrentMonth<=2) {
			exam.setSemestre(semestreService.getSemestreById((long) 2));
		}else if(CurrentMonth>=3 && CurrentMonth<=7) {
			exam.setSemestre(semestreService.getSemestreById((long) 1));
		}
		
	}
	
	public void setDefaultSession(ExamenModel exam) {
		exam.setSession(sessionService.getSessionById((long) 1));
	}
	public void setDefaultTypeExam(ExamenModel exam) {
		int CurrentMonth=LocalDate.now().getMonthValue();
		if(CurrentMonth==11 || CurrentMonth==12 || CurrentMonth==3 ||CurrentMonth==4) {
			exam.setType(typeExamService.getTypeExamById((long) 1));
		}else if(CurrentMonth==1 || CurrentMonth==2 || CurrentMonth==5 ||CurrentMonth==6) {
			exam.setType(typeExamService.getTypeExamById((long) 2));
		}
	}
	
	
	@RequestMapping("showFormExamen")
	public String showForm(Model m) {
		ExamenModel modelExam=new ExamenModel();
		setDefaultSession(modelExam);
		setDefaultSemestre(modelExam);
		setDefaultTypeExam(modelExam);
		//setDefautDurePrevu(modelExam);
		
		loadLists(m);
		m.addAttribute("examenModel", modelExam);
		//m.addAttribute("salleModel", new Salle());
		
		return "admin/FormExamen";
		
	}
	
	
	
	
	
	

	public void uploadEprouveFile(ExamenModel em, Model model) {
		
	    MultipartFile file = em.getEprouveFile();
	    System.out.println(file);
	    if (!file.isEmpty()) {
	        try {
	            // Define the path where you want to save the file
	            String relativePath = "resources/epreuves";
	            String uploadDirectory = context.getRealPath(relativePath);

	            // Ensure the upload directory exists
	            File directory = new File(uploadDirectory);
	            if (!directory.exists()) {
	                directory.mkdirs();
	            }

	            // Generate a unique filename to avoid overwriting
	            String originalFilename = file.getOriginalFilename();
	            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	            String uniqueFilename = timestamp + "_" + originalFilename;
	            String filePath = Paths.get(uploadDirectory, uniqueFilename).toString();

	            // Save the file to the target location
	            File dest = new File(filePath);
	            file.transferTo(dest);

	            // Set the relative file path to the model
	            em.setEprouve(Paths.get(relativePath, uniqueFilename).toString().replace("\\", "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	            model.addAttribute("message", "File upload failed: " + e.getMessage());
	        }
	    }
	}

	
	public void uploadPvFile(ExamenModel em,Model model) {
		
		    MultipartFile file = em.getPvFile();
		    
		    if (!file.isEmpty()) {
		        try {
		            // Define the path where you want to save the file
		            String relativePath = "resources/pv";
		            String uploadDirectory = context.getRealPath(relativePath);

		            // Ensure the upload directory exists
		            File directory = new File(uploadDirectory);
		            if (!directory.exists()) {
		                directory.mkdirs();
		            }

		            // Generate a unique filename to avoid overwriting
		            String originalFilename = file.getOriginalFilename();
		            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		            String uniqueFilename = timestamp + "_" + originalFilename;
		            String filePath = Paths.get(uploadDirectory, uniqueFilename).toString();

		            // Save the file to the target location
		            File dest = new File(filePath);
		            file.transferTo(dest);

		            // Set the relative file path to the model
		            em.setPv((Paths.get(relativePath, uniqueFilename).toString().replace("\\", "/")));
		        } catch (IOException e) {
		            e.printStackTrace();
		            model.addAttribute("message", "File upload failed: " + e.getMessage());
		        }
		    }
		}
	
	@RequestMapping("/addExam")
	public String addeaxmen(@Valid @ModelAttribute("examenModel") ExamenModel examenModel,Model m,BindingResult br) {
		if(br.hasErrors()) {
				br.getAllErrors().forEach(error -> {
		            System.out.println("**Error: " + error.getDefaultMessage());
		        });
				return "admin/FormExamen";
			}
			System.out.println(examenModel.getSalles());
			System.out.println(examenModel.getNbrS());
			System.out.println(examenModel.getChoix());
			uploadEprouveFile(examenModel ,m);
			uploadPvFile(examenModel ,m);
		    Exam ex = new Exam();
		    BeanUtils.copyProperties(examenModel, ex);
		    System.out.println(ex);
		    examenService.addExamen(ex);
		    
		    List<Salle> salles=new ArrayList<>(examenModel.getSalles());
		    Map<Long,Integer> nbrEnsParSalle=examenModel.getNbrS();
		    System.out.println(nbrEnsParSalle);
		   //1(contreleur d'abscence)
		    List<Administrateur> selectedAdmins =choisirAlContrAbscencs(ex.getDate());
		    //System.out.println(selectedAdmins);
		    
		   //2(Surviellance)les ensiegnant qui ne sont pas affecter a un exam pour cette date
		    List<Enseignant> selectedEns=filterAvailableEnseignant(ex.getDate());
		    //System.out.println(selectedEns);
		    for(int i=0;i<salles.size();i++) {
		    	int nbrEnsPerSalle=nbrEnsParSalle.get(salles.get(i).getIdSalle());
		    	//System.out.println(salles.get(i)+"nbr ="+nbrEnsPerSalle);
		    	Surveillance s = new Surveillance();
		        if (i < selectedAdmins.size()) {
		            s.setAdmin(selectedAdmins.get(i));
		         
		        } else {
		            m.addAttribute("warningMessage", "Pas assez d'administrateurs disponibles pour toutes les salles.");
		        }
		        if(selectedEns.size()>=nbrEnsPerSalle) {
		        	List<Enseignant> ens=new ArrayList<>();
		        	for(int j=0 ;j<nbrEnsPerSalle ;j++) {
		        		ens.add(selectedEns.get(j));
		        		selectedEns.remove(selectedEns.get(j));
		        	}
		        	System.out.println(ens);
		        	s.setEnseignants(new HashSet<>(ens));
		        }
		    	
		    	s.setCoordExam(examenModel.getElement().getEns());
		    	s.setExam(ex);//les surveillance de cet exam
		    	s.setSalle(salles.get(i));
		    	survService.addSurveillance(s);
		    }
		    
		    //reaaficher formulaire apres la soumission
		    ExamenModel modelExam=new ExamenModel();
			setDefaultSession(modelExam);
			setDefaultSemestre(modelExam);
			setDefaultTypeExam(modelExam);
			
			loadLists(m);
			m.addAttribute("examenModel", modelExam);
			return "admin/FormExamen";
	}
	
	@RequestMapping("/epreuve")
	@ResponseBody
	public ResponseEntity<Resource> getEpreuve(@RequestParam String filename) {
	    return getFile(filename);
	}

	@RequestMapping("/pv")
	@ResponseBody
	public ResponseEntity<Resource> getPv(@RequestParam String filename) {
	    return getFile(filename);
	}

	private ResponseEntity<Resource> getFile(String filename) {
	    try {
	        String filePath = context.getRealPath(filename);
	        File file = new File(filePath);
	        if (file.exists()) {
	            Resource resource = new FileSystemResource(file);
	            return ResponseEntity.ok()
	                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
	                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + file.getName() + "\"")
	                    .body(resource);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}


	List<Administrateur> choisirAlContrAbscencs(Date d){
		 List<Administrateur> allAdmins = adminService.getAllAdmins();
		    List<Administrateur> availableAdmins = filterAvailableAdmins(allAdmins, d);
		    System.out.println(availableAdmins);

		    // Si pas d'administrateurs disponibles, retourner une erreur ou gérer le cas
		    if (availableAdmins.isEmpty()) {
		        // Gérer le cas où aucun administrateur n'est disponible
		       System.out.println("Aucun administrateur n'est disponible pour surveiller l'examen à cette date.");
		    }

		    // Choisir des administrateurs aléatoirement parmi les disponibles
		    Collections.shuffle(availableAdmins);
		    List<Administrateur> selectedAdmins = availableAdmins.subList(0, Math.min(salles.size(), availableAdmins.size()));
		    return selectedAdmins;
		
	}
	List<Administrateur> filterAvailableAdmins(List<Administrateur> allAdmins, Date examDate) {
        List<Administrateur> unavailableAdmins = survService.getAdminsAssignedToExamsOnDate(examDate);
        return allAdmins.stream()
                        .filter(admin -> !unavailableAdmins.contains(admin))
                        .collect(Collectors.toList());
        
    }
	
	List<Enseignant> filterAvailableEnseignant(Date examDate) {
		List<Enseignant> allEns=ensService.getAllEnsiegnants();
        List<Enseignant> unavailableEns = survService.getEnsAssignedToExamsOnDate(examDate);
        List<Enseignant> availableEns= allEns.stream()
                        .filter(ens -> !unavailableEns.contains(ens))
                        .collect(Collectors.toList());
         Collections.shuffle(availableEns);
         return availableEns;
         
    }
	
	@Autowired 
	private IPersonelService pService;
	@Autowired 
	
	@RequestMapping("test")
	public String test() {
		LocalDate examd=LocalDate.of(2024, 05, 07);
		System.out.println(examenService.getExamByDate(DateUtils.asDate(examd)));
		List<Long> listId = new ArrayList<>();
		examenService.getExamByDate(DateUtils.asDate(examd)).forEach( e -> listId.add(e.getIdExam()));
		System.out.println(listId);
		//System.out.println(survService.findIdAdminsByExamIds(listId));
		return "admin/test";
	}
	
	@RequestMapping("showListExams")
	 public String showListExams() {
		
		
	    return "admin/listExams";
	   
	}
	
	@GetMapping("/showListExamResponse")
	 public String showListExamss(@RequestParam("date") String date, Model model) {
		System.out.println("***************");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date datee;
        try {
            datee = formatter.parse(date);
            System.out.println("Parsed date: " + datee);
        } catch (ParseException e) {
            model.addAttribute("errorMessage", "Invalid date format");
            return "admin/listExamFrag";
        }
        
        // Supposons que vous ayez un service pour obtenir les examens par date
        List<Exam> exams = examenService.getExamByDate(datee);
        System.out.println(exams);
        model.addAttribute("ListExams", exams);
        return "admin/listExamFrag";
    }
	
	@GetMapping("/setDefaultDure")
	@ResponseBody
	public String setDefautDurePrevu(@RequestParam("element") Long elementId) {
	    Element element = elementService.getElementById(elementId);
	    Long typeId = element.getType().getIdType();

	    if (typeId == 1) {
	        return "02:00";
	    } else if (typeId == 2) {
	        return "01:30";
	    } else {
	        return "00:00";
	    }
	}
	
	@RequestMapping("/updateListSalle")
	@ResponseBody
	public List<Long> disponibleSalles(@RequestParam("date") Date date,@RequestParam("hDebutN") LocalTime hDebutN) {
		List<Salle> allSalles = salleService.getAllSalles();
		List<Exam> examsOfDate=examenService.getExamByDate(date);
		Map<Salle,String> salleDisp=new LinkedHashMap<>();
		List<Salle> SallesNonDisp=new ArrayList<>();
		
		List<Salle> salleOfDate = survService.getSallesByExam(examsOfDate);
		for(Salle s : salleOfDate) {
			Exam ex=survService.getExamBySalle(s);
			LocalTime hDebut=ex.getHeureDebut();
			LocalTime hFin=hDebut.plusHours(3);//on suppose que la dure max pour un exam est 3heures
			
			if(hDebutN.isAfter(hDebut) || hDebutN.isBefore(hFin)) {
				SallesNonDisp.add(s);
			}
		}
		allSalles.removeAll(salleOfDate);
		List<Long> sallesID=new ArrayList<>();
		for(Salle s:allSalles) {
			sallesID.add(s.getId());
		}
		System.out.println(allSalles);
		salleDisp.clear();
		for(Salle s : allSalles) {
			salleDisp.put(s, s.getNom());
		}
		System.out.println(salleDisp);
		//return sallesID;
		return sallesID;
	
	}
	
	
	@GetMapping("/detailsExam")
	public String detailsExam(@RequestParam("idExam") String idExam,Model model) {
		Long idexam=Long.valueOf(idExam);
		List<Exam> exams=new ArrayList<>();
		exams.add(examenService.getExamenById(idexam));
		
		Map<Salle,Enseignant> cordExam=new LinkedHashMap<>();
		Map<Salle,Administrateur> abscenceExam=new LinkedHashMap<>();
		Map<Salle,Set<Enseignant>> survEnsExam=new LinkedHashMap<>();
		List<Salle> salles = survService.getSallesByExam(exams) ;
		
		for(Salle s : salles) {
//			cordExam.put(s, survService.getCoordExamBySalle(s));
//			abscenceExam.put(s, survService.getControleurAbscenceBySalle(s));
			Surveillance survSalle=survService.getSurveillanceSalle(s,exams.get(0));
			cordExam.put(s,survSalle.getCoordExam());
			abscenceExam.put(s, survSalle.getAdmin());
			survEnsExam.put(s, survSalle.getEnseignants());			
		}
		model.addAttribute("salles", salles);
		model.addAttribute("exam", exams);
		model.addAttribute("cordSall", cordExam);
		model.addAttribute("absExam", abscenceExam);
		model.addAttribute("survExam", survEnsExam);
		return "admin/detailsExam";
		
	}
	
	
	
	
	
}
