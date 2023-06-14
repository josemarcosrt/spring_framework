package com.jpa.spring.one.to.many.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailInput {

	private Long id;
    private String dsEmail;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDsEmail() {
		return dsEmail;
	}
	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;  
	}
}

