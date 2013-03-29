package org.example.hello.impl;

import junit.framework.TestCase;

public class TestHelloImplJUnit3 extends TestCase {

	private HelloImpl helloImpl = new HelloImpl();
	
	public void testHelloImpl() {
		assertEquals("Hello", helloImpl.getHelloMessage());
	}
}
