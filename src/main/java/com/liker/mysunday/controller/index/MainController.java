package com.liker.mysunday.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * MainController首页跳转 
 * 
 * @author LIKER
 */
@Controller
@RequestMapping(value = "/index")
public class MainController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "angular/hello";
	}
}
