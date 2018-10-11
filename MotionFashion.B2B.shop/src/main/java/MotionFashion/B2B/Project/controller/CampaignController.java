package MotionFashion.B2B.Project.controller;




import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import MotionFashion.B2B.Project.model.Campaign;
import MotionFashion.B2B.Project.model.Product;
import MotionFashion.B2B.Project.repository.CampaignRepository;
import MotionFashion.B2B.Project.repository.Campaign_ImageRepository;
import MotionFashion.B2B.Project.repository.ProductRepository;
@RestController
@RequestMapping("/campaign")
public class CampaignController {


	
	
	
	
	@Autowired
	private CampaignRepository campaignRepository;
	

	
	@Autowired
	private Campaign_ImageRepository campaign_ImageRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/show")
	public ModelAndView show()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/campaignManagement/addPublicCampaign/products");
		return mv;
	}
	
	@GetMapping("/campaignList")
	public Iterable<Campaign> listCampaign()
	{
		return campaignRepository.findAll();
	}
	
	
	//.............................................................................................//
				//..............Show all the campaign in a grid..................//
	
	
	
	@GetMapping("/showAll_Grid") // success but still testing 
	public ModelAndView showAllGrid()
	{
		ModelAndView mv = new ModelAndView();
		
		
		List<Campaign> campaigns = (List<Campaign>)campaignRepository.findAll();
		
		mv.addObject("campaigns",campaigns);
		mv.setViewName("/campaigns/newCampaigns");
		
		return mv;
		
	}
	
	
	//.............................................................................................//
				//..............Show all the campaign in a list..................//

		@GetMapping("/showAll_List") // success but still testing  need to add some query mapping 
		public ModelAndView showAlllist()
		{
			ModelAndView mv = new ModelAndView();
			List<Campaign> campaigns = (List<Campaign>)campaignRepository.findAll();
			
			mv.addObject("campaigns",campaigns);
			mv.setViewName("/campaignManagement/list_all_campaigns");
			
			return mv;
		
		}
		
		@GetMapping("/showAll") // testing
		public ModelAndView showAlll()
		{
			ModelAndView mv = new ModelAndView();
			List<Campaign> campaigns = (List<Campaign>)campaignRepository.findAllActive();
			
			mv.addObject("campaigns",campaigns);
			mv.setViewName("/campaignManagement/list_all_campaigns");
			
			return mv;
		
		}
	
		@GetMapping("/campaign_create_info") // testing //  success
		public ModelAndView create_campaign_campaignInfo()
		{
			
			
			ModelAndView mv = new ModelAndView();
			
			Campaign campaign = new Campaign();
			mv.addObject("campaign",campaign);
			
			mv.setViewName("/campaignManagement/addPublicCampaign/campaign_information");
		
			return mv;
		}
		
		@RequestMapping(value="/update_1",method=RequestMethod.POST) // testing  // success
		public String save_campaignInfo( 
										@RequestParam String title,
										@RequestParam String subTitle,
										@RequestParam  ("teaserImage") MultipartFile teaserImage,
										@RequestParam String description,
										@RequestParam int active,
										@RequestParam String type)
	
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(); 
			ModelAndView mv = new ModelAndView();
			
			Campaign campaign = new Campaign();
		
			try {
				
				byte[] buffer = teaserImage.getBytes();
				String base64Image = Base64.getEncoder().encodeToString(buffer);
				campaign.setTeaserImage(base64Image);
			
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			mv.addObject("campaign",campaign);
			campaign.setTitle(title);
			campaign.setSubTitle(subTitle);
			campaign.setDescription(description);
			campaign.setActive(active);
			campaign.setType(type);
			
			campaign.setCampaign_Image(null);
			campaign.setUserId(0);
			campaign.setConsultantId(0000);
			campaign.setCustomerId(0);
			campaign.setCreatedAt(formatter.format(date));
			
			campaign.setImage_datatype(null);
			campaign.setThumbnailImage(null);
			
			
			
			mv.setViewName("/campaignManagement/addPublicCampaign/campaign_information");
			
			campaignRepository.save(campaign);
		return "data saved";
		//	return new ModelAndView("redirect:/campaign/campaign_create_pro/"+campaign.getCampaign_id()) ;
		}
		//.............................................................................................//
		//.............................................................................................//
		//.............................................................................................//


		
		
		@GetMapping("/edit_1/{campaign_id}")	// testing //  success	
		public ModelAndView  edit_1(@PathVariable("campaign_id") Integer campaign_id )
		{
			ModelAndView mv = new ModelAndView();
		
			Optional<Campaign> newCampaign = campaignRepository.findById(campaign_id);
			Campaign campaign = newCampaign.get();
				
			
				
			mv.addObject("campaign",campaign);
			
			mv.setViewName("/campaignManagement/addPublicCampaign/edit_campaign_info");
			return mv;
			//return new ModelAndView("redirect:/campaign/update_1/"+campaign.getCampaign_id()) ;
			
		}
		
		
		@PostMapping("/edit_info")	// testing //  success	
		public ModelAndView   edit_1(@RequestParam Integer campaign_id ,
								@RequestParam String title,
								@RequestParam String subTitle,
								@RequestParam  ("teaserImage") MultipartFile teaserImage,
								@RequestParam String description,
								@RequestParam int active) throws IOException
				
		{
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(); 
			ModelAndView mv = new ModelAndView();
		
			Optional<Campaign> newCampaign = campaignRepository.findById(campaign_id);
			Campaign campaign = newCampaign.get();
			
			
			mv.addObject("campaign",campaign);
			
			byte[] test_byte;
			
			if(teaserImage.getBytes()!=null)
			{
		
						try {
							
							byte[] buffer = teaserImage.getBytes();
							String base64Image = Base64.getEncoder().encodeToString(buffer);
							campaign.setTeaserImage(base64Image);
						
							
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			}
						
			
			mv.addObject("campaign",campaign);
			campaign.setTitle(title);
			campaign.setSubTitle(subTitle);
			campaign.setDescription(description);
			campaign.setActive(active);
				
			campaignRepository.save(campaign);
			
			mv.setViewName("/campaignManagement/addPublicCampaign/campaign_information");
			//return "data updated";
			return new ModelAndView("redirect:/campaign/showAll_List") ;
			
		}
		
		
		

	
		
		
		//.............................................................................................//
		        //---------add product to campaign  ---------//
	
		@GetMapping("/campaign_create_pro/{campaign_id}")		// testing 	//success
		public ModelAndView create_campaign_products(@PathVariable int campaign_id )
		{
			
			ModelAndView mv = new ModelAndView();
			List<Product> products =(List<Product>)productRepository.findAll();
			Optional<Campaign> newCampaign = campaignRepository.findById(campaign_id);
			Campaign campaign = newCampaign.get();
			mv.addObject("products", products);
			mv.addObject("campaign",campaign);
			mv.setViewName("/campaignManagement/addPublicCampaign/products");
			
			return mv;
			
			
		}
		
		
		
		//-------------------------------------------------------------------------------------------------------//
		//-------------------------------------------------------------------------------------------------------//
		
		
		@PostMapping("/add_product_to_campaign")  				// testing  //success 
		public  String add_product_to_campaign(@RequestParam("idChecked") List<String> idrates,@RequestParam int campaign_id)
		//ArrayList<Integer>
		{
			
			ModelAndView mv = new ModelAndView();
			Optional<Campaign> newCampaign = campaignRepository.findById(campaign_id);
			Campaign campaign = newCampaign.get();
			Product product = new Product();
			
			
			
				ArrayList<Integer> al=new ArrayList<Integer>(); 
				
				if(idrates != null){
					Set<Product> productList = new HashSet();
					productList = campaign.getProductlist();
			        for(String idrateStr : idrates){
			            int idrate = Integer.parseInt(idrateStr);
			           //al.add(idrate);
			            Optional<Product> newProduct =productRepository.findById((long) idrate);
			            	if(newProduct.get()==null)
			            	{
			            		return "there is no value";
			            	}
			            	
			            	else
			            	{
			            		   product=newProduct.get();
						            productList.add(product);
			            	}
			         
			            } 
			       
			       
			        campaign.setProductlist(productList);
			        campaignRepository.save(campaign);
			    }
		
			
			return "data saved";  // will be replace by template
			
			
		}
		
		//-------------------------------------------------------------------------------------------------------//
		//-------------------------------------------------------------------------------------------------------//
		
		
		@RequestMapping(value = "/delete_campaign/{campaign_id}",method=RequestMethod.GET)
		public ModelAndView deleteCampaign(@PathVariable("campaign_id") Integer campaign_id)
		{
			
			ModelAndView mv = new ModelAndView();
			campaignRepository.deleteById(campaign_id);
			
			
			
			return new ModelAndView("redirect:/campaign/showAll_List");
		}
		
		
		@DeleteMapping("/delete")
		public ModelAndView delete(@RequestParam Integer campaign_id )
		{
			
			ModelAndView mv = new ModelAndView();
			Optional<Campaign> newCampaign = campaignRepository.findById(campaign_id);
			Campaign campaign = newCampaign.get();
			mv.addObject(campaign);
			
			campaignRepository.delete(campaign);
			return new ModelAndView("redirect:/campaign/showAll_List");
			
		}
		//-------------------------------------------------------------------------------------------------------//
		//-------------------------------------------------------------------------------------------------------//
				
									//---------add product to campaign  ---------//
		
		
		@PostMapping("/add_product")  				// testing  //success // will be remove
		public ArrayList<Integer> add_campaign_products(@RequestParam("idChecked") List<String> idrates)
		{
			ArrayList<Integer> al=new ArrayList<Integer>(); 
			
			if(idrates != null){
		        for(String idrateStr : idrates){
		            int idrate = Integer.parseInt(idrateStr);
		           al.add(idrate);
		            } 
		    }
			
			return al;
			
			
		}
		
}
