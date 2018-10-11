package MotionFashion.B2B.Project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import MotionFashion.B2B.Project.model.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
	
	
	
	
	//@Query("SELECT  FROM live5.articles")
	
   List<Product> findAll();
	
 
	
	
}
