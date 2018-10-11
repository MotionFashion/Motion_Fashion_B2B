package MotionFashion.B2B.Project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Campaign_Image")
public class Campaign_Image {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="campaign_image_id")
	private int campaign_image_id;
	@Column(name="image")
	private String image; 
	
	@ManyToOne
	@JoinColumn(name="campaign_id")
	@JsonIgnore
	private Campaign campaign;

	public Campaign_Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Campaign_Image( String image, Campaign campaign) {
		super();
		
		this.image = image;
		this.campaign = campaign;
	}

	public int getCampaign_image_id() {
		return campaign_image_id;
	}

	public void setCampaign_image_id(int campaign_image_id) {
		this.campaign_image_id = campaign_image_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}
	
	
	
	
	
	
	

}
