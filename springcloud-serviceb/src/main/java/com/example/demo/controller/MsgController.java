package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {
	@RequestMapping("/hello")
	public String showHello() {
		return "This is Hello in service a";
	}

}
