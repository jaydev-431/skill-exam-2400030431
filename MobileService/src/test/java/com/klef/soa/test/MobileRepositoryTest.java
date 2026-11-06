package com.klef.soa.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.klef.soa.entity.Mobile;
import com.klef.soa.repository.MobileRepository;

public class MobileRepositoryTest {

	@Autowired
	private MobileRepository repo ;
	
	
	@Test
	public void test1() {
		long c = repo.count();
		assertTrue(c>0);
	}
	
	@Test
	void test2() {
		List<Mobile> list = repo.findAll();
		assertNotNull(list);
	}
	
	@Test
	void test3() {
		Optional<Mobile> container = repo.findById(1L);
		assertTrue(container.isPresent());
	}
	
	@Test
	void test4() {
		List<Mobile> list = repo.findByBrand("Samsung");
		assertTrue(list.size()>0);
	}
	
	@Test
	void test5() {
		List<Mobile> list = repo.findByStorage(256);
		assertNotNull(list);
	}
	
}
