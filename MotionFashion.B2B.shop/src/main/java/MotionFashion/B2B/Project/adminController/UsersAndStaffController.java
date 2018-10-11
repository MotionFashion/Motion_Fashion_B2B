package MotionFashion.B2B.Project.adminController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users_and_staff")
public class UsersAndStaffController {
	
	@GetMapping("/administrators")
	public ModelAndView showAdministrators() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/users_and_staff/administrators");
		
		return mv;
	}
	
	@GetMapping("/consultants")
	public ModelAndView showConsultants() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/users_and_staff/consultants");
		
		return mv;
	}
	
	@GetMapping("/customer_management")
	public ModelAndView showCustomerManagement() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/users_and_staff/customer_management");
		
		return mv;
	}
	
	@GetMapping("/common")
	public ModelAndView showCommon() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/users_and_staff/create_new/common");
		
		return mv;
	}
	
	@GetMapping("/address")
	public ModelAndView showAddress() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/users_and_staff/create_new/addresses");
		
		return mv;
	}
	
	@GetMapping("/user_administrator")
	public ModelAndView showUserAdministrator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/users_and_staff/create_new/user_administrator");
		
		return mv;
	}
	
	@GetMapping("/booking_rules")
	public ModelAndView showBookingRules() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/users_and_staff/create_new/booking_rules");
		
		return mv;
	}

}
