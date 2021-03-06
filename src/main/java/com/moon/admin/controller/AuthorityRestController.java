package com.moon.admin.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moon.entity.Authority;
import com.moon.service.AuthorityService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthorityRestController {

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	AuthorityService authService;
	
	@GetMapping
	public List<Authority> findAll(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return authService.findAuthoritiesOfAdministrators();
		}
		
		return authService.findAll();
	}
	
	@GetMapping("/getAuthByAcc")
	public Authority getAuthByAcc() {
		
		String username = request.getRemoteUser();
		
		return authService.getAuthotiryByAcc(username);
	}
	
	@PostMapping
	public Authority post(@RequestBody Authority auth) {
		
		return authService.create(auth);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {		
		 authService.deleteById(id);
	}

	
}
