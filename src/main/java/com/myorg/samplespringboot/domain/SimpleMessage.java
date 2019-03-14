package com.myorg.samplespringboot.domain;

import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
public class SimpleMessage {
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private String content;
	
	

}
