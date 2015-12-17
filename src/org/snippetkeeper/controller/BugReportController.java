package org.snippetkeeper.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.snippetkeeper.domain.Bug;
import org.snippetkeeper.domain.User;
import org.snippetkeeper.service.BugService;
import org.snippetkeeper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/bug")
@Controller
public class BugReportController {
	private static final Logger logger = Logger.getLogger(BugReportController.class);

	
	@Autowired
    ServletContext context; 
	@Autowired
	private BugService bugService;
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addBugForm(@ModelAttribute("bug")Bug bug){
		return "bug_report";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addBug(@Valid @ModelAttribute("bug")Bug bug,BindingResult bindingResult,RedirectAttributes redirect,HttpServletRequest request){
		if(bindingResult.hasErrors())
		return "bug_report";
		
		Object userId = request.getSession().getAttribute("userId");
		Long uId = (Long) userId;
		User user = userService.getUser(uId);
		bug.setUser(user);
		MultipartFile bugImage = bug.getFile();
		String rootDirectory = context.getRealPath("/");
				
			if (bugImage!=null && !bugImage.isEmpty()) {
		       try {
		    	   String fileName = ""+uId+System.currentTimeMillis();
		    	   String imagePath =rootDirectory+"/resource/images/"+ fileName+".png";
		    	   bug.setImagePath(fileName);
		      	bugImage.transferTo(new File(imagePath));
		     
		       } catch (Exception e) {
		    
				throw new RuntimeException("Product Image saving failed", e);
				 
		   }
		   }
		
		bugService.saveBug(bug);
		redirect.addFlashAttribute(bug);
		return "redirect:/bug/details";
	}
	
	
	@RequestMapping(value="/details",method=RequestMethod.GET)
	public String detailAfterAdd(@ModelAttribute("bug")Bug bug){
		
		return "bug_detail";
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public String detail(Model model,@RequestParam("id")String id){
		Bug bug=null;
		if(id!=null&&!id.isEmpty())
		bug =	bugService.findById(Long.parseLong(id));
			model.addAttribute("bug", bug);
		return "bug_detail";
	}
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String bugList(Model model){
		List<Bug> bugs = bugService.findAll();
		model.addAttribute("bugs", bugs);
		return "bug_list";
	}
	
	
}
