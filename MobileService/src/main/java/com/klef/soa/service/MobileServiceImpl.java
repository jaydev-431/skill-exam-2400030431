package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Mobile;
import com.klef.soa.repository.MobileRepository;

@Service
public class MobileServiceImpl implements MobileService {
	
	@Autowired
	private MobileRepository mobilerepo ;

	@Override
	public Mobile addMobile(Mobile m) {
		if(m!=null) {
			mobilerepo.save(m);
		}else {
			return null;
		}
		return m;
	}

	@Override
	public Mobile update(Mobile m) {
		long id = m.getId();
		Optional<Mobile> mob = mobilerepo.findById(id);
		if(mob.isPresent()) {
			Mobile mobile = mob.get();
			mobile.setModel(m.getModel());
			mobile.setBrand(m.getBrand());
			mobile.setPrice(m.getPrice());
			mobile.setRam(m.getRam());
			mobile.setStorage(m.getStorage());
			mobilerepo.save(mobile);
			return mobile;
		}else {
		return null;
		}
	}

	@Override
	public String deleteMobile(long id) {
		if(mobilerepo.existsById(id)) {
		mobilerepo.deleteById(id);
		return "Deleted successfully" ;
		}else {
			return "Mobile doesn't exist";
		}
	}

	@Override
	public List<Mobile> displayAll() {
		List<Mobile> list = mobilerepo.findAll();
		return list;
	}

	@Override
	public Mobile displayById(long id) {
		  return mobilerepo.findById(id).orElse(null);
//		Optional<Mobile> m = mobilerepo.findById(id);
//		return m.get();
	}
// .get() is used to extract the object from optional class.

	@Override
	public List<Mobile> findByBrand(String brand) {
		List<Mobile> l = mobilerepo.findByBrand(brand);
		return l;
	}

	@Override
	public List<Mobile> findByStorage(double s) {
		List<Mobile> l = mobilerepo.findByStorage(s);
		return l;
	}
}
