package MotionFashion.B2B.Project.adminController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/campain_management")
public class CampaignManagementController {
	
	@GetMapping("/listAll")
	public ModelAndView showAllCamp()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/campaign_management/list_all_campaigns");
		return mv;
	}
	
	@GetMapping("/add_private_campaign")
	public ModelAndView addPrivateCamp()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/campaign_management/add_private_campaign");
		return mv;
	}
	
	@GetMapping("/campaign_info")
	public ModelAndView CampIno()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/campaign_management/add_public_campaign/campaign_information");
		return mv;
	}
	
	@GetMapping("/products")
	public ModelAndView showProd()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/campaign_management/add_public_campaign/products");
		return mv;
	}
	
	@GetMapping("/settings")
	public ModelAndView showSettings()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/campaign_management/add_public_campaign/settings");
		return mv;
	}
}
