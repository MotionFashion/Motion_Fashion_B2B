package MotionFashion.B2B.Project.adminController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping("/bookings_admin")
public class BookingsController_admin {
	
	@GetMapping("/accepted_bookings")
	public ModelAndView showAcceptedBookings()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/bookings/accepted_bookings");
		return mv;
	}
	
	
	
	@GetMapping("/booking_archive")
	public ModelAndView showBookingArchive()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/bookings/booking_archive");
		return mv;
	}
	
	@GetMapping("/upcoming_campaign")
	public ModelAndView showUpcomingCampaigns()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/bookings/campaign_bookings/upcoming_campaign");
		return mv;
	}
	
	
	@GetMapping("/starting_soon")
	public ModelAndView showStartingSoon()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/bookings/campaign_bookings/starting_soon");
		return mv;
	}

	
	@GetMapping("/bookings_archive")
	public ModelAndView showBookingsArchive()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/bookings/campaign_bookings/booking_archive");
		return mv;
	}
	
	
}
