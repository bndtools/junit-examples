package org.example.hello.runtimetests.junit3;

import static org.example.hello.runtimetests.TestUtils.waitForService;
import junit.framework.TestCase;

import org.example.hello.Hello;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

public class ExampleJUnit3Test extends TestCase {

    private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();

    public void testExampleJUnit3() throws Exception {
        Hello hello = waitForService(context, Hello.class, null, 10000);
        assertEquals("Hello", hello.getHelloMessage());
    }
}
