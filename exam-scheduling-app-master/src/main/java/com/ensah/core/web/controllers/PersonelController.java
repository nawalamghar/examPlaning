package com.ensah.core.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ensah.core.bo.*;
import com.ensah.core.services.IDeptService;
import com.ensah.core.services.IElementService;
import com.ensah.core.services.IFiliereService;
import com.ensah.core.services.IGroupeService;
import com.ensah.core.services.IPersonelService;
import com.ensah.core.web.models.PersonelModel;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import java.util.*;
@Controller
@RequestMapping("/admin")
public class PersonelController {
	
	@Autowired
	private IPersonelService personelService;
	

	@Autowired
	private IDeptService deptService;
	

	@Autowired
	private IFiliereService filiereService;

	@Autowired
	private HttpSession httpSession;
	
	@Autowired 
	private IElementService elementService;
	
	@Autowired
	private IGroupeService groupeService;
	
	/** Utilisé pour la journalisation */
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	
	private Map<Dept,String> depts = new LinkedHashMap<Dept,String>();
	private Map<Filiere,String> filiers = new LinkedHashMap<Filiere,String>();
	private Map<Element,String> elements=new LinkedHashMap<Element,String>();
	private Map<Groupe,String> groupes=new LinkedHashMap<Groupe,String>();
	
	public PersonelController(){
		
	}
	
	public void uploadLists(Model model) {
		depts.clear(); // Efface la liste actuelle
        if (deptService.getAllDepts() != null) {
            for (Dept d : deptService.getAllDepts()) {
                depts.put(d,d.getTitreD());
            }
        }
        
        groupes.clear(); // Efface la liste actuelle
        if (groupeService.getAllGroupes()!= null) {
            for (Groupe g : groupeService.getAllGroupes()) {
                groupes.put(g,g.getNom());
            }
        }
        
        filiers.clear(); // Efface la liste actuelle
        if (filiereService.getAllFiliers() != null) {
            for (Filiere f : filiereService.getAllFiliers()) {
                filiers.put(f,f.getTitreF());
            }
        }
        
        elements.clear();
        if(elementService.getAllElements()!=null) {
        	for(Element e : elementService.getAllElements()) {
        		elements.put(e, e.getTitre());
        	}
        }
		
        model.addAttribute("deptList",depts);
        model.addAttribute("filList",filiers);
        model.addAttribute("elementList",elements);
        model.addAttribute("groupeList",groupes);
		
	}
	
	public void uploadPersonels(Model model) {
		List<Personel> persons = personelService.getAllPersonnes();
		System.out.println(persons);
		List<PersonelModel> modelPersons = new ArrayList<PersonelModel>();
		
		for (int i = 0; i < persons.size(); i++) {
			PersonelModel pm = new PersonelModel();
			if (persons.get(i) instanceof Enseignant) {
				BeanUtils.copyProperties((Enseignant) persons.get(i), pm);
				pm.setTypePerson(PersonelModel.TYPE_ENS);
				modelPersons.add(pm);
			} else if (persons.get(i) instanceof Administrateur) {
				BeanUtils.copyProperties((Administrateur) persons.get(i), pm);
				pm.setTypePerson(PersonelModel.TYPE_ADMIN);
				modelPersons.add(pm);
		}}
		model.addAttribute("personelList", modelPersons);
		
	}
	@GetMapping(value="showForm")
	public String showForm(@RequestParam int typePersonel,Model model) {
		
		uploadLists(model);
		
		PersonelModel pmodel = new PersonelModel(typePersonel);
		model.addAttribute("personelModel", pmodel);
		uploadPersonels(model);
		
		
		return "admin/form";
	}
	
	
	@RequestMapping("/addPersonel")
	public String addPersonel(@Valid @ModelAttribute("personelModel") PersonelModel personel,BindingResult br,Model m) {
		
		if(br.hasErrors()) {
			uploadPersonels(m);
			uploadLists(m);
			return "admin/form";
		}
		if(personel.getTypePerson()==personel.TYPE_ADMIN) {
			Administrateur adm=new Administrateur();
			BeanUtils.copyProperties(personel, adm);
			personelService.addPersonne(adm);
			
		}else if(personel.getTypePerson()==personel.TYPE_ENS) {
			Enseignant ens=new Enseignant();
			BeanUtils.copyProperties(personel, ens);
			personelService.addPersonne(ens);
		}
		
		
		return "redirect:/admin/showForm?typePersonel="+personel.getTypePerson();
	}
	
	 
	
	@RequestMapping(value="deletePersonel/{idPersonel}")
	public String deletePerson(@PathVariable int idPersonel) {
		  
        	personelService.deletePersonne(Long.valueOf(idPersonel));	
            return "redirect:/admin/showForm?typePersonel=1";
	}
	
	
	@RequestMapping(value="updatePersonelForm/{idPersonnel}",method = RequestMethod.GET)
	public String processUpdate(@PathVariable int idPersonnel,Model model) {
		
		uploadLists(model);
		PersonelModel pm=new PersonelModel();
		Personel p = personelService.getPersonneById(Long.valueOf(idPersonnel));
		
		if(p instanceof Enseignant) {
			BeanUtils.copyProperties((Enseignant)p, pm);
			pm.setTypePerson(PersonelModel.TYPE_ENS);
			
		}else if(p instanceof Administrateur) {
			pm.setTypePerson(PersonelModel.TYPE_ADMIN);
			BeanUtils.copyProperties((Administrateur)p, pm);
		}
		System.out.println(pm.getTypePerson());
		model.addAttribute("personelModel", pm);
		
		return "admin/updateForm";
	}
	
	@RequestMapping(value="updatePersonel")
	public String updatePersonel(@Valid @ModelAttribute("personelModel") PersonelModel p,BindingResult br,Model m ) {
		
		if(br.hasErrors()) {
			uploadLists(m);
			return "admin/updateForm";
		}
		else {
		if(p.getTypePerson()==1) {
			Administrateur a = new Administrateur();
			BeanUtils.copyProperties(p, a);
			personelService.updatePersonne(a);
		}
		else if(p.getTypePerson()==2) {
			Enseignant e = new Enseignant();
			BeanUtils.copyProperties(p, e);
			personelService.updatePersonne(e);
		}
		return "redirect:/admin/showForm?typePersonel=1";
	}
		
	
	}}
