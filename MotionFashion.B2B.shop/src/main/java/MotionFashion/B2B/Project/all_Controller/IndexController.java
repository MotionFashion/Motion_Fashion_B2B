package MotionFashion.B2B.Project.all_Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/home")
public class IndexController {
	
	
	@GetMapping("/index")
	public ModelAndView showHome() {
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/main_index");
		return mv;
	}
}
