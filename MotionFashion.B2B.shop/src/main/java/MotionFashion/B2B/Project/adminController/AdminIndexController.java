package MotionFashion.B2B.Project.adminController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/adminPage")
public class AdminIndexController {

		@GetMapping("/index")
		public ModelAndView showHome() {
					
			ModelAndView mv = new ModelAndView();
			mv.setViewName("index_admin");
			return mv;
	}
}
