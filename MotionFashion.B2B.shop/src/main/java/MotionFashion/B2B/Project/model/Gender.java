package MotionFashion.B2B.Project.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "gender")
public class Gender {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int genderId;
	
	private String gender;
	
	//@OneToMany(targetEntity=Product.class, mappedBy="gender", fetch=FetchType.EAGER)
	@OneToMany(targetEntity= Product.class, mappedBy="gender", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Product> products;
	
	

	public Gender() {
		
	}

	public Gender( String gender) {
		
		this.gender = gender;
		
	}

	public int getGenderId() {
		return genderId;
	}

	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	

}
