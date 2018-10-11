package MotionFashion.B2B.Project.all_Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@GetMapping("/place_order")
	public ModelAndView placeOrder() {
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/orders/place_order");
		return mv;
	}
	
	@GetMapping("/order_history")
	public ModelAndView showOrderHistory() {
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/orders/order_history");
		return mv;
	}

}
