package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Mobile;
import com.klef.soa.service.MobileService;

@RestController
@RequestMapping("/mobile")
public class MobileController {

	@Autowired
	private MobileService ms;
	
//	@RequestMapping("/test")
	@GetMapping("/")
	public String test() {
		return "API is working";
	}
	
	@GetMapping("/displayall")
	public ResponseEntity<?> displayAll(){
		List<Mobile> list = ms.displayAll();
		if(!list.isEmpty()) {
		return ResponseEntity.ok(list);
		}else {
			return ResponseEntity.status(404).body("No mobiles");
		}
	}
	
	@GetMapping("/displaybyid/{id}")
	public ResponseEntity<?> displayById(@PathVariable long id){
		Mobile m = ms.displayById(id);
		if(m==null) {
			return ResponseEntity.status(404).body("Mobile Not Found");
		}
		return ResponseEntity.ok(m);
	}
	
	@PostMapping("/addmobile")
	public ResponseEntity<?> addmobile(@RequestBody Mobile m){
		Mobile mobile = ms.addMobile(m);
		return ResponseEntity.status(201).body(mobile);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteBYId(@RequestParam long id){
		String res = ms.deleteMobile(id);
		if(res.equals("Deleted successfully")) {
		return ResponseEntity.status(200).body(res);
		}else {
			return ResponseEntity.status(404).body(res);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateMobile(@RequestBody Mobile m){
		Mobile mobile = ms.update(m);
		return ResponseEntity.ok(mobile);
	}
	
	@GetMapping("/brand/{brand}")
	public ResponseEntity<List<Mobile>> findByBrand(@PathVariable String brand) {
		List<Mobile> list = ms.findByBrand(brand);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/storage/{val}")
	public ResponseEntity<List<Mobile>> findByStorage(@PathVariable double val) {
		List<Mobile> list = ms.findByStorage(val);
		return ResponseEntity.ok(list);
	}
}
 