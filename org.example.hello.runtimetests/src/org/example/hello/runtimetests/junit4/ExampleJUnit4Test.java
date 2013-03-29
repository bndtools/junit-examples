package org.example.hello.runtimetests.junit4;

import static org.example.hello.runtimetests.TestUtils.waitForService;
import static org.junit.Assert.assertEquals;
import org.example.hello.Hello;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

public class ExampleJUnit4Test {

    private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

    @Test
    public void testExampleJUnit4() throws Exception {
    	Hello hello = waitForService(context, Hello.class, null, 10000);
        assertEquals("Hello", hello.getHelloMessage());
    }
}
