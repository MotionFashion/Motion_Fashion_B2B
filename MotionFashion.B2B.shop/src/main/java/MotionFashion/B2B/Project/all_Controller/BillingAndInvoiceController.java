package MotionFashion.B2B.Project.all_Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/billing")
public class BillingAndInvoiceController {
	
	
	
	@GetMapping("/invoice")
	public ModelAndView showInvoices() {
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("/billing_and_invoices/invoices");
		
		return mv;
	}

	@GetMapping("/pending_payments")
	public ModelAndView showPendingPayments() {
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("/billing_and_invoices/pending_payments");
		
		return mv;
	}
	

}
