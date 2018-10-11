package MotionFashion.B2B.Project.adminController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/product_catalog")
public class ProductCatalogController {
	
	@GetMapping("/products")
	public ModelAndView showProducts() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/product_catalog/products");
		
		return mv;
	}
	
	@GetMapping("/details")
	public ModelAndView showProductsDetails() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/product_catalog/create_new/details");
		
		return mv;
	}

	
	@GetMapping("/settings")
	public ModelAndView showProductssettings() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/product_catalog/create_new/general_product_settings");
		
		return mv;
	}
	
}
