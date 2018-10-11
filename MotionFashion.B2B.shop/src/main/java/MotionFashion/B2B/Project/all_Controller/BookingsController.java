package MotionFashion.B2B.Project.all_Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping("/bookings")
public class BookingsController {
	
	@GetMapping("/accepted_bookings")
	public ModelAndView showAcceptedBookings()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bookings/accepted_bookings");
		return mv;
	}
	
	
	
	@GetMapping("/booking_archive")
	public ModelAndView showBookingArchive()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bookings/booking_archive");
		return mv;
	}
	
	@GetMapping("/upcoming_campaign")
	public ModelAndView showUpcomingCampaigns()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bookings/campaign_bookings/upcoming_campaign");
		return mv;
	}
	
	
	@GetMapping("/starting_soon")
	public ModelAndView showStartingSoon()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bookings/campaign_bookings/starting_soon");
		return mv;
	}

	
	@GetMapping("/bookings_archive")
	public ModelAndView showBookingsArchive()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/bookings/campaign_bookings/booking_archive");
		return mv;
	}
	
	
}
