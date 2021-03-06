package MotionFashion.B2B.Project.controller;


import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import MotionFashion.B2B.Project.model.Campaign;
import MotionFashion.B2B.Project.model.User;
import MotionFashion.B2B.Project.repository.CampaignRepository;
import MotionFashion.B2B.Project.service.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private CampaignRepository campaignRepository;
    
    //..................................Showing login page...................................................................//

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginPage");
        return modelAndView;
    }

    //.....................................Showing registration page................................................................//

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registerPage");
        return modelAndView;
    }
    
  //.....................................................................................................//
    
    //........................................Working with registration page.............................................................//

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if(!user.getPassword().equals(user.getConfirmpassword()))
        {
        	bindingResult.rejectValue("password", "error.user","boath field doesent match");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registerPage");
        } 
        
        
        else {
        	
        	
			            userService.saveUser(user);
			            modelAndView.addObject("successMessage", "User has been registered successfully");
			            modelAndView.addObject("user", new User());
			            modelAndView.setViewName("registerPage");

        }
        return modelAndView;
    }
    
    //.....................................................................................................//
    
    
    

    //....................................Working with login page.................................................................//
    @RequestMapping(value="/admin/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        List<Campaign> campaigns = (List<Campaign>)campaignRepository.findAll();
        modelAndView.addObject("userName", "Welcome " + user.getFirstname() + " " + user.getLastname() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.addObject("campaigns",campaigns);
        modelAndView.setViewName("index_admin");//home_page
        return modelAndView;
    }

    
    
    
    
    //......................................Reset password...............................................................//
    
			  

}
