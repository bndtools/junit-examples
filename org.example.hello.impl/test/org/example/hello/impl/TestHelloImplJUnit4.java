package org.example.hello.impl;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestHelloImplJUnit4 {

	private HelloImpl helloImpl = new HelloImpl();
	
	@Test
	public void testHelloImpl() {
		assertEquals("Hello", helloImpl.getHelloMessage());
	}
}
