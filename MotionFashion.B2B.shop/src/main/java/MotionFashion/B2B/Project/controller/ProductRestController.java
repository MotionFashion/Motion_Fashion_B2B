package MotionFashion.B2B.Project.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import MotionFashion.B2B.Project.model.Product;
import MotionFashion.B2B.Project.repository.GenderRepository;
import MotionFashion.B2B.Project.repository.ProductRepository;





//@RestController
@Controller
@RequestMapping("/products")
public class ProductRestController {


	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private GenderRepository genderRepository;

	//-------------------------------------------------------------------------------------------------------//
	//-------------------------------------------------------------------------------------------------------//
	
	
						// show index page for testing//
	@GetMapping("/show") // show page  // testing	//success	
	public ModelAndView showpage() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");//index
		return mv;
	}


	//-------------------------------------------------------------------------------------------------------//
	//-------------------------------------------------------------------------------------------------------//
	
						// working with  index page data for testing//
	@RequestMapping(value="/home",method=RequestMethod.GET)  // show arcicle page  // will be remove 
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView();
		List<Product> products =(List<Product>)productRepository.findAll();
		mv.addObject("products",products);
		mv.setViewName("index");
		return mv;
	}
	//-------------------------------------------------------------------------------------------------------//
	//-------------------------------------------------------------------------------------------------------//
	
					// showing and working  actual productlist page //

	@RequestMapping(value="/productList",method=RequestMethod.GET)// show Actual arcicle list	//success	
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		List<Product> products =(List<Product>)productRepository.findAll();
		mv.addObject("products",products);
		mv.setViewName("products");
		return mv;
	}



	//-------------------------------------------------------------------------------------------------------//
	//-------------------------------------------------------------------------------------------------------//
	
					// showing and working  actual productlist for testing  //
	
	@GetMapping("/productlist") // show all product		// testing	// will be remove 
	public List<Product> getAllproduct(){

		//return productRepository.findAll();
		
		List<Product> product = productRepository.findAll();
		
		
		
		return product;
	}





		//-------------------------------------------------------------------------------------------------------//
		//-------------------------------------------------------------------------------------------------------//
	
	
							// work with  actual productlist  single product will be show  //

		@GetMapping("/productId/{id}")  // show articles by id -> single object		// testing	
		public ModelAndView find(@PathVariable Long id)
		{
			ModelAndView mv = new ModelAndView();
			Optional<Product> product = productRepository.findById(id);
			Product newObj = product.get();
			mv.addObject("products",newObj);

			mv.setViewName("products");
			return mv;
		}



		
		//-------------------------------------------------------------------------------------------------------//
		//-------------------------------------------------------------------------------------------------------//
		
								// create new product //
		@GetMapping("/create_1")		//success	
		public ModelAndView  create_1()
		{
			ModelAndView mv = new ModelAndView();
		
			
			Product newProduct = new Product();
			mv.addObject("product",newProduct);

			newProduct.setDescription("Enter description");
			newProduct.setArticleNumber("enter articleNumber");
			newProduct.setEan(0);
			newProduct.setSku(0);
			newProduct.setPurchasePrice(new BigDecimal("0.0"));
			newProduct.setQuantity(0);
			newProduct.setBrand("Enter brand");
			newProduct.setOriginCountryId(0);
			newProduct.setGender(null);
			newProduct.setSize("Enter product size");
			newProduct.setColor("Enter product color");
			newProduct.setWeight(0.0);
			newProduct.setRetailPrice(new BigDecimal("0.0"));
			newProduct.setCustomsTariffNumber(null);
			newProduct.setMaterialComposition(null);
			newProduct.setCareInstructions(null);
			newProduct.setAdditionalInformation(null);
			productRepository.save(newProduct);
			mv.setViewName("general_product_settings");
			//return mv;
			return new ModelAndView("redirect:/products/edit_1/" + newProduct.getId());

		}


		//-------------------------------------------------------------------------------------------------------//
		//-------------------------------------------------------------------------------------------------------//
				
									//---------update general product setting page ---------//
				
				@GetMapping("/edit_1/{id}")		//success	
				public ModelAndView  edit_1(@PathVariable("id") Long id )
				{
					ModelAndView mv = new ModelAndView();
				
					Optional<Product> object = productRepository.findById(id);
					
						Product newProduct = object.get();
					
						
					mv.addObject("product",newProduct);
					
					mv.setViewName("general_product_settings");
					return mv;
					
				}
				
				@RequestMapping(value="/update_1",method=RequestMethod.POST)	//success	
				public ModelAndView update_1(@RequestParam Long id,
									@RequestParam String description,
									@RequestParam String  articleNumber,
									@RequestParam long ean,
									@RequestParam long sku,
									@RequestParam BigDecimal  purchasePrice,
									@RequestParam long quantity
									) {  // need to use @RequestParam 
					
					ModelAndView mv = new ModelAndView();
					
					Optional<Product> object = productRepository.findById(id);
					
					Product newProduct = object.get();
					

				    newProduct.setDescription(description);
					newProduct.setArticleNumber(articleNumber);
					newProduct.setEan(ean);
					newProduct.setSku(sku);
					newProduct.setPurchasePrice(purchasePrice);
					newProduct.setQuantity(quantity);
					productRepository.save(newProduct);
				    
				//	mv.setViewName("products");
					return new ModelAndView("redirect:/products/edit_1/"+newProduct.getId());
					//return new ModelAndView("redirect:/products/edit_2/" + newProduct.getId());
				
					
				}
				
		
		
		//-------------------------------------------------------------------------------------------------------//
		//-------------------------------------------------------------------------------------------------------//
				
				
				
				//---------update details page ---------//
				
				
				@GetMapping("/edit_2/{id}")		//success	
				public ModelAndView  edit_2(@PathVariable("id") Long id )
				{
					ModelAndView mv = new ModelAndView();
				
					Optional<Product> object = productRepository.findById(id);
					
						Product newProduct = object.get();
					
						
					mv.addObject("product",newProduct);
					
					mv.setViewName("details");
					return mv;
					
				}
				
				
				/*		//---------update 2---------//
				@RequestMapping(value="/update_2",method=RequestMethod.POST)	//success		
				public ModelAndView update_2(@RequestParam Long id,
										@RequestParam String brand,
										@RequestParam long originCountryId,
										@RequestParam int genderId,
										@RequestParam String size,
										@RequestParam String color,
										@RequestParam double weight,
										@RequestParam BigDecimal  retailPrice,
										@RequestParam Long customsTariffNumber,
										@RequestParam String materialComposition,
										@RequestParam String careInstructions,
										@RequestParam String additionalInformation
						) {  // need to use @RequestParam 
					
					ModelAndView mv = new ModelAndView();
					Optional<Product> object = productRepository.findById(id);
					
						Product newProduct = object.get();
					
						newProduct.setBrand(brand);
						newProduct.setOriginCountryId(originCountryId);
						newProduct.setGender();;
						newProduct.setSize(size);
						newProduct.setColor(color);
						newProduct.setWeight(weight);
						newProduct.setRetailPrice(retailPrice);
						newProduct.setCustomsTariffNumber(customsTariffNumber);
						newProduct.setMaterialComposition(materialComposition);
						newProduct.setCareInstructions(careInstructions);
						newProduct.setAdditionalInformation(additionalInformation);
						productRepository.save(newProduct);
						//mv.addObject("message","Table updated");
						mv.setViewName("details");
						return new ModelAndView("redirect:/products/edit_2/" + newProduct.getId());
				}*/
				
				
//				 @RequestMapping(value="/delete_product/{id}", method = RequestMethod.GET)
//				    public String notesDelete(Model model, @PathVariable(required = true, name = "id") Long id) {
//				        notesService.deleteNotes(id);
//				        model.addAttribute("notesList", notesService.findAll());
//				        return "notesList";
//				    }




		
}
