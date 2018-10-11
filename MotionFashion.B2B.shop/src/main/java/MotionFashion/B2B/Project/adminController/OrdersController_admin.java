package MotionFashion.B2B.Project.adminController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/orders_admin")
public class OrdersController_admin {
	
	@GetMapping("/place_order")
	public ModelAndView placeOrder() {
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/orders/place_order");
		return mv;
	}
	
	@GetMapping("/order_history")
	public ModelAndView showOrderHistory() {
				
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/orders/order_history");
		return mv;
	}

}
