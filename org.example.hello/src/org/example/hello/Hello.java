package org.example.hello;

import aQute.bnd.annotation.ProviderType;

@ProviderType
public interface Hello {

	void sayHello();
	
	void setHelloMessage(String message);
	
	String getHelloMessage();

}
