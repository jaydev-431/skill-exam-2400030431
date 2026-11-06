package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Mobile;

public interface MobileService {

//	Insert, Update, Delete, Display All, Display By ID
	
	Mobile addMobile(Mobile m);
	Mobile update(Mobile m);
	String deleteMobile(long id);
	List<Mobile> displayAll();
	Mobile displayById(long id);
	List<Mobile> findByBrand(String brand);
	List<Mobile> findByStorage(double s);
	
	
}
