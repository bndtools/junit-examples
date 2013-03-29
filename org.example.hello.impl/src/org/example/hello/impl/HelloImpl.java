package org.example.hello.impl;

import org.example.hello.Hello;

import aQute.bnd.annotation.component.Component;

@Component
public class HelloImpl implements Hello {

	private String message = "Hello";
	
	@Override
	public void sayHello() {
		System.out.println(message);
	}

	@Override
	public void setHelloMessage(String message) {
		this.message =message;  
		
	}

	@Override
	public String getHelloMessage() {
		return message;
	}

}
