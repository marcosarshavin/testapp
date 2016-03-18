package com.mytest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {


	@RequestMapping(value = "/hello")
	public ResponseEntity<String> hello() {

		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
}
