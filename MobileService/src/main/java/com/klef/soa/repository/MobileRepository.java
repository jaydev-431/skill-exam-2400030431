package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Mobile;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {
	
	List<Mobile> findByBrand(String brand);
	
	List<Mobile> findByStorage(double storage);

}
