package MotionFashion.B2B.Project.adminController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/booking_and_purchases")
public class BookingAndPurchaseController {
	
	@GetMapping("/inquiry_requests")
	public ModelAndView showInquiryRequest() {

		ModelAndView mv =new ModelAndView();
		mv.setViewName("/booking_and_purchases/inquiry_requests");
		
		return mv;
	}
	
	@GetMapping("/booking_conflicts")
	public ModelAndView showBookingConflicts() {

		ModelAndView mv =new ModelAndView();
		mv.setViewName("/booking_and_purchases/booking_conflicts");
		
		return mv;
	}
	
	@GetMapping("/shipping")
	public ModelAndView showShipping() {

		ModelAndView mv =new ModelAndView();
		mv.setViewName("/booking_and_purchases/shippings");
		
		return mv;
	}
	
	@GetMapping("/payed_invoice")
	public ModelAndView showInvoices() {

		ModelAndView mv =new ModelAndView();
		mv.setViewName("/booking_and_purchases/invoices_and_payments/payed_invoice");
		
		return mv;
	}
	
	@GetMapping("/unpayed_invoice")
	public ModelAndView showInvoice() {

		ModelAndView mv =new ModelAndView();
		mv.setViewName("/booking_and_purchases/invoices_and_payments/unpayed_invoice");
		
		return mv;
	}
}
