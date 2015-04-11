package com.target.csp.resources;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HomeEntryResource extends ResourceSupport {
	
	
	private Long num;
	
	private String title;

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnore
	public Long getNum() {
		return num;
	}

	@JsonProperty
	public void setNum(Long num) {
		this.num = num;
	}

	
}
