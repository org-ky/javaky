package com.orgky.examples.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orgky.examples.model.Iva;
import com.orgky.examples.service.IvaService;

@Controller
public class IvaController {

	private IvaService ivaService;
	
	@Autowired(required=true)
	@Qualifier(value="ivaService")
	public void setvaService(IvaService ps){
		this.ivaService = ps;
	}
	
	@ResponseBody
	@RequestMapping(value = "/listIvas",
		method = RequestMethod.GET,
		produces={"application/json", "application/xml"})
	public List<Iva> listIvas(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Entering controller......");
		List<Iva> ivaList = this.ivaService.listIvas();
		
		System.out.println(ivaList.toString());

		System.out.println("Persistence called......");
		
		return ivaList;
	}
	
	/*@RequestMapping(value = "/ivas", method = RequestMethod.GET)
	public String listIvas(Model model) {
		model.addAttribute("iva", new Iva());
		model.addAttribute("listIvas", this.ivaService.listIvas());
		return "iva";
	}*/
	
	//For add and update iva both
	@RequestMapping(value= "/iva/add", method = RequestMethod.POST)
	public String addIva(@ModelAttribute("iva") Iva p){
		
		if(p.getIdIva() == 0){
			//new iva, add it
			this.ivaService.addIva(p);
		}else{
			//existing iva, call update
			this.ivaService.updateIva(p);
		}
		
		return "redirect:/ivas";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeIva(@PathVariable("id") int id){
		
        this.ivaService.removeIva(id);
        return "redirect:/ivas";
    }
 
    @RequestMapping("/edit/{id}")
    public String editIva(@PathVariable("id") int id, Model model){
        model.addAttribute("iva", this.ivaService.getIvaById(id));
        model.addAttribute("listIvas", this.ivaService.listIvas());
        return "iva";
    }
}
