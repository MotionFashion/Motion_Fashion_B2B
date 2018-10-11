package MotionFashion.B2B.Project.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "campaigns")
public class Campaign {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="campaign_id")
	private int campaign_id;
	
	@Column(name="userId", nullable = true)
	private int userId;
	
	@Column(name="consultantId")
	private int consultantId;

	@Column(name="customerId", nullable = true) 
	private Integer  customerId;
	
	@Column
	private String   createdAt;
	
	@Column(name="title")
	private String title;
	
	@Column(name="subTitle", nullable = true) 
	private String subTitle;
	
	@Column(name="description", nullable = true) 
	private String description;
	
	@Column(name="teaserImage", nullable = true) 
	
	//@Lob
	private String  teaserImage;

	@Column(name="image_datatype", nullable = true)
	private String image_datatype;
	
	@Column(name="thumbnailImage", nullable = true) 
	private String thumbnailImage;


	@Column(name="type" , nullable = true)
	private String type ;
	
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "campaign_product", joinColumns = @JoinColumn(name = "campaign_id", referencedColumnName = "campaign_id"), inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
	public Set<Product> productlist;
	
	 public Set<Product> getProductlist() {
		return productlist;
	}




	public void setProductlist(Set<Product> productlist) {
		this.productlist = productlist;
	}

	@OneToMany(targetEntity= Campaign_Image.class,mappedBy="campaign",cascade = CascadeType.ALL)
	 public Set<Campaign_Image> campaign_Image;
	  
	 
	 


	@Column(name="active")
	private int active;

	/*################################################################################################################################################################*/

	
	
	
	
	
	
	
	public int getCampaign_id() {
		return campaign_id;
	}


	

	public Campaign() {
		super();
	}


	public Campaign( String title, String subTitle) {
		super();
		
		this.title = title;
		this.subTitle = subTitle;
		
	}

	public Campaign( String title, String subTitle, Set<Campaign_Image> campaign_Image) {
		super();
		
		this.title = title;
		this.subTitle = subTitle;
		this.campaign_Image = campaign_Image;
	}

	public Campaign(int userId, int consultantId, Integer customerId, String createdAt, String title, String subTitle, String description, String teaserImage, String image_datatype, String thumbnailImage, String type, Set<Product> productlist, Set<Campaign_Image> campaign_Image, int active) {
		this.userId = userId;
		this.consultantId = consultantId;
		this.customerId = customerId;
		this.createdAt = createdAt;
		this.title = title;
		this.subTitle = subTitle;
		this.description = description;
		this.teaserImage = teaserImage;
		this.image_datatype = image_datatype;
		this.thumbnailImage = thumbnailImage;
		this.type = type;
		this.productlist = productlist;
		this.campaign_Image = campaign_Image;
		this.active = active;
	}

	public void setCampaign_id(int campaign_id) {
		this.campaign_id = campaign_id;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getConsultantId() {
		return consultantId;
	}



	public void setConsultantId(int consultantId) {
		this.consultantId = consultantId;
	}



	public Integer getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}



	public String getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(String string) {
		this.createdAt = string;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getSubTitle() {
		return subTitle;
	}



	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getTeaserImage() {
		return teaserImage;
	}



	public void setTeaserImage(String teaserImage) {
		this.teaserImage = teaserImage;
	}



	public String getThumbnailImage() {
		return thumbnailImage;
	}



	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}



	public Set<Campaign_Image> getCampaign_Image() {
		return campaign_Image;
	}



	public void setCampaign_Image(Set<Campaign_Image> campaign_Image) {
		this.campaign_Image = campaign_Image;
	}



	public int getActive() {
		return active;
	}



	public void setActive(int active) {
		this.active = active;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage_datatype() {
		return image_datatype;
	}

	public void setImage_datatype(String image_datatype) {
		this.image_datatype = image_datatype;
	}
}
