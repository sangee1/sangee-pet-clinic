package com.example.sangeepetclinic.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.sangeepetclinic.model.Owner;
import com.example.sangeepetclinic.service.OwnerService;

@Controller
public class OwnerController {
	
	private final OwnerService ownerService;
	private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
	
	
	public OwnerController(OwnerService ownerService) {
		super();
		this.ownerService = ownerService;
	}
	
	@InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

		
	@RequestMapping({"/owners/find"})
	public String findOwners(Model model) {
		model.addAttribute("owner", new Owner());
		return "owners/findOwners";
	}
	
	@GetMapping("/owners")
	public String processFindForm(Owner owner, BindingResult result, Model model) {
		if(owner.getLastName() == null) {
			owner.setLastName("");
		}
		List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
		if(results.isEmpty()) {
			return "owners/findOwners";
		}
		else if(results.size() ==1) {
			owner = results.get(0);
			return "redirect:/owners/" + owner.getId();
		}else {
			model.addAttribute("selections", results);
			return "owners/ownersList";
		}
		
	}
	
	@GetMapping("/owners/{ownerId}")
	public ModelAndView showOwner(@PathVariable Long ownerId) {
		ModelAndView mav = new ModelAndView("owners/ownerDetails");
		mav.addObject(ownerService.findById(ownerId));
		return mav;
		
	}
	
	@GetMapping("/owners/new")
	public String initCreationForm(Model model) {
		Owner owner = new Owner();
		model.addAttribute("owner", owner);
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		
	}
	
	@PostMapping("/owners/new")
	public String processCreationForm(@Validated Owner owner,BindingResult result) {
		if(result.hasErrors()) {
			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		}
		else {
			ownerService.save(owner);
			return "redirect:/owners/" + owner.getId();
		}
		
		
	}
	
	@GetMapping("/{ownerId}/edit")
	public String initUpdateOwnerForm(@PathVariable Long ownerId,Model model ) {
		model.addAttribute(ownerService.findById(ownerId));
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		
	}
	
	@PostMapping("/{ownerId}/edit")
	public String processUpdateOwnerForm(@Validated Owner owner,BindingResult result,@PathVariable Long ownerId) {
		if(result.hasErrors()) {
			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		}
		else {
			owner.setId(ownerId);
			Owner savedOwner = ownerService.save(owner);
			return "redirect:/owners/" + savedOwner.getId();
		}
		
	}
}
