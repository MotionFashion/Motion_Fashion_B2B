package MotionFashion.B2B.Project.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "articles")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	private long ean;
	private long sku;
	private String  articleNumber;
	private String size;
	private String color;
	private long quantity;
	private String description;
	
	
	@Column(name="purchasePrice")
   // @ColumnDefault("0.0")
	private BigDecimal  purchasePrice;
	
	@Column(name="retailPrice")
    //@ColumnDefault('0.0')
	private BigDecimal  retailPrice;
	
	@Column(name="materialComposition", nullable = true) 
	private String materialComposition;
	
	private String brand;
	
	 @ManyToMany(mappedBy = "productlist")
	private Set<Campaign> campaign;
	 
	 
	public Set<Campaign> getCampaign() {
		return campaign;
	}

	public void setCampaign(Set<Campaign> campaign) {
		this.campaign = campaign;
	}

	@ManyToOne
	@JoinColumn(name="genderId")
	@JsonIgnore
	private Gender gender;
	
	@Column(name="productGroupId") 
	private long  productGroupId;
	
	
	@Column(name="additionalInformation", nullable = true) 
	private String additionalInformation;
	
	@Column(name="originCountryId") 
	private long originCountryId;
	
	private double weight;
	
	@Column(name="customsTariffNumber", nullable = true) 
	private Long customsTariffNumber;
	
	@Column(name="careInstructions", nullable = true) 
	private String careInstructions;

//	@ManyToMany(mappedBy = "productlist")
//	private Set<Campaign> campaignlist;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEan() {
		return ean;
	}

	public void setEan(long ean) {
		this.ean = ean;
	}

	public long getSku() {
		return sku;
	}

	public void setSku(long sku) {
		this.sku = sku;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}



	public String getMaterialComposition() {
		return materialComposition;
	}

	public void setMaterialComposition(String materialComposition) {
		this.materialComposition = materialComposition;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	


	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public long getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(long productGroupId) {
		this.productGroupId = productGroupId;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public long getOriginCountryId() {
		return originCountryId;
	}

	public void setOriginCountryId(long originCountryId) {
		this.originCountryId = originCountryId;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Long getCustomsTariffNumber() {
		return customsTariffNumber;
	}

	public void setCustomsTariffNumber(Long customsTariffNumber) {
		this.customsTariffNumber = customsTariffNumber;
	}

	public String getCareInstructions() {
		return careInstructions;
	}

	public void setCareInstructions(String careInstructions) {
		this.careInstructions = careInstructions;
	}


	

	
}