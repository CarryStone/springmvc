package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class ViewController {
	@RequestMapping("/viewtest")
	public ModelAndView freeMarker() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("username","уехЩ");	
		mv.setViewName("freemarker");
		return mv;
	}
}
