package com.ensah.core.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ensah.core.bo.*;
import com.ensah.core.services.IElementService;
import com.ensah.core.services.INiveauService;
import com.ensah.core.services.IPersonelService;
import com.ensah.core.services.ITypeService;

import jakarta.validation.Valid;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class ElementController {
	
	@Autowired
	private IElementService elementService;
	
	@Autowired
	private INiveauService niveauService;
	
	@Autowired
	private ITypeService typeService;
	
	
	@Autowired
	private IPersonelService personelService;
	
	private Map<Niveau,String> nivs= new LinkedHashMap<Niveau,String>();
	private Map<Type,String> types= new LinkedHashMap<Type,String>();
	private Map<Enseignant,String> coords= new LinkedHashMap<Enseignant,String>();
	public void uploadLists(Model m) {
		
		
		
		nivs.clear(); // Efface la liste actuelle
        if (niveauService.getAllNiveaux()!= null) {
            for (Niveau n : niveauService.getAllNiveaux()) {
                nivs.put(n,n.getTitreN());
            }
        }
        
        types.clear();
        for(Type t :typeService.getAllType()) {
        	types.put(t, t.getTitreT());
        }
        
        coords.clear();
        for(Personel e :personelService.getAllPersonnes()) {
        	if(e instanceof Enseignant) {
        		coords.put((Enseignant) e, e.getNom()+" "+e.getPrenom());
        	}
        	
        }
		
		
		m.addAttribute("niveauList", nivs);
		m.addAttribute("typeList", types);
		m.addAttribute("coordList", coords);
	}
	
	ElementController(){
		
	}
	
	
	@RequestMapping("/addElementForm")
	public String showFormElement(Model m) {
		uploadLists(m);
		Element e = new Element();
		
		m.addAttribute("elementList",elementService.getAllElements());
		m.addAttribute("elementModel",e);
		return "admin/formElement";
	}
	
	@RequestMapping("/addElement")
	public String addElement(@Valid @ModelAttribute("elementModel") Element elem,BindingResult br,Model m) {
		
		if(br.hasErrors()) {
			m.addAttribute("elementList",elementService.getAllElements());
			uploadLists(m);
			return "admin/formElement";
		}else {
			
			elementService.addElement(elem);
			return "redirect:/admin/addElementForm";
		}
	
	}
	
	@GetMapping("/updateElementForm/{idElement}")
	public String showFormUpdateElem(@PathVariable int idElement,Model m) {
		
		m.addAttribute("elementModel",elementService.getElementById(Long.valueOf(idElement)));
		uploadLists(m);
		return "admin/updateElement";
	}
	
	@RequestMapping(value="updateElement")
	public String updateElement(@Valid @ModelAttribute("elementModel") Element e,Model m,BindingResult br) {
		
		if(br.hasErrors()) {
			m.addAttribute("elementList",elementService.getAllElements());
			uploadLists(m);
			return "admin/updateElement";
		}
		else {
			elementService.updateElement(e);
			return "redirect:/admin/addElementForm";
		}
		
		
	}
	
	@RequestMapping("/deleteElement/{idElement}")
	public String deleteElement(@PathVariable int idElement) {
		
		elementService.deleteElement(Long.valueOf(idElement));
		return "redirect:/admin/addElementForm";
	}
	
	
	

	
}
