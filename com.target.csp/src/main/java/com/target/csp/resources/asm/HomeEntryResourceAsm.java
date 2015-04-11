package com.target.csp.resources.asm;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import com.target.csp.resources.HomeEntryResource;
import com.target.csp.controllers.HomeController;
import com.target.csp.entities.HomeEntry;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

public class HomeEntryResourceAsm extends ResourceAssemblerSupport<HomeEntry, HomeEntryResource>  {

	public HomeEntryResourceAsm() {
		super(HomeController.class, HomeEntryResource.class);
	}

	@Override
	public HomeEntryResource toResource(HomeEntry entity) {
		HomeEntryResource res = new HomeEntryResource();
		res.setTitle(entity.getTitle());
		res.setNum(entity.getNum());
		/*Link link = linkTo(methodOn(HomeController.class)
				.getHomeEntry(entity.getNum())).withSelfRel();*/
		Link link = linkTo(HomeController.class).slash(entity.getNum()).withRel("Rakans");
		res.add(link.withSelfRel());
		res.add(link.withRel("Sankar"));
		res.add(link);
		System.out.println(res);
		return res;
	}
}
