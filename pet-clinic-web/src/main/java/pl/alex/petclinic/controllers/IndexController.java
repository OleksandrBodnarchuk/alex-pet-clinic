package pl.alex.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	@RequestMapping(method = RequestMethod.GET, value = { "", "/", "index", "index.html" })
	public String index() {
		return "index";
	}
	
	@RequestMapping("/oups")
	public String errorPage() {
		return "notImplemented";
	}
}
