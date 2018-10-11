package MotionFashion.B2B.Project.adminController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/countries")
public class CountryController {
	
	@GetMapping("/country")
	public ModelAndView show()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/countries");
		return mv;
	}
}
