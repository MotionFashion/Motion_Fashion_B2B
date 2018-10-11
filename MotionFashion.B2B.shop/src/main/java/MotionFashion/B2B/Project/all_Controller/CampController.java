package MotionFashion.B2B.Project.all_Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/campaigns")
public class CampController {

	@GetMapping("/new_campaigns")
	public ModelAndView showNewCampaign() {
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/campaigns/newCampaigns");
		return mv;
	}
	
	@GetMapping("/campaign_search")
	public ModelAndView shearchCampaign() {
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/campaigns/campaign_search");
		return mv;
	}
	
	@GetMapping("/private_campaign")
	public ModelAndView showPrivateCampaign() {
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/campaigns/private_campaigns");
		return mv;
	}
	
	@GetMapping("/request_campaign")
	public ModelAndView requestCampaign() {
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/campaigns/request_campaign");
		return mv;
	}
}
