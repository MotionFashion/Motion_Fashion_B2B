package MotionFashion.B2B.Project.all_Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/profile")
public class MyProfileController {
	
	@GetMapping("/common")
	public ModelAndView showCommon() {
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/my_profile/common");
		return mv;
	}
	
	
	@GetMapping("/addresses")
	public ModelAndView showAddress() {
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/my_profile/addresses");
		return mv;
	}


}
