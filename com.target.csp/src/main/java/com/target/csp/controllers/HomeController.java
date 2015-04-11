package com.target.csp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.target.csp.entities.HomeEntry;
import com.target.csp.resources.HomeEntryResource;
import com.target.csp.resources.asm.HomeEntryResourceAsm;
import com.target.csp.services.HomeEntryService;

@Controller
@RequestMapping(value = "/rest/Home-entries/")
public class HomeController {

	@Autowired
	private HomeEntryService service;

	public HomeController(HomeEntryService service) {
		this.service = service;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody HomeEntry showHome() {
		HomeEntry entry = new HomeEntry();
		entry.setTitle("Basic home page");
		entry.setNum(12345678L);
		return entry;
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public @ResponseBody HomeEntry showHome1(@RequestBody HomeEntry entry) {
		return entry;
	}

	@RequestMapping(value = "/{HomeEntryId}", method = RequestMethod.GET)
	public ResponseEntity<HomeEntryResource> getHomeEntry(
			@PathVariable Long HomeEntryId) {
		HomeEntry entry = service.find(HomeEntryId);
		if (entry != null) {
			HomeEntryResource res = new HomeEntryResourceAsm()
					.toResource(entry);
			return new ResponseEntity<HomeEntryResource>(res, HttpStatus.OK);
		} else {
			return new ResponseEntity<HomeEntryResource>(HttpStatus.NOT_FOUND);
		}
	}

}
