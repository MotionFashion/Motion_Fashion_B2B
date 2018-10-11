package MotionFashion.B2B.Project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import MotionFashion.B2B.Project.model.Campaign;





public interface CampaignRepository extends CrudRepository<Campaign,Integer>{

	
	@Query(value="SELECT * FROM test_database.campaigns c where c.active=1",nativeQuery = true)
	public List<Campaign> findAllActive();
}
