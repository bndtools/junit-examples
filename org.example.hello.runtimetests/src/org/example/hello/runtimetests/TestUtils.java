package org.example.hello.runtimetests;

import java.text.MessageFormat;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class TestUtils {

	@SuppressWarnings("unchecked")
	public static <T> T waitForService(BundleContext context, Class<T> service, String filter, long timeout) {

		String serviceName = service.getName();

		ServiceTracker tracker = null;
		if (filter != null) {
			try {
				Filter combined = FrameworkUtil.createFilter(String.format("(&(%s=%s)%s)", Constants.OBJECTCLASS, serviceName, filter));
				tracker = new ServiceTracker(context, combined, null);
			} catch (InvalidSyntaxException e) {
				fail("Invalid filter syntax.");
			}
		} else {
			tracker = new ServiceTracker(context, serviceName, null);
		}

		try {
			tracker.open();
			Object instance;
			if (timeout <= 0) {
				instance = tracker.getService();
			} else {
				instance = tracker.waitForService(timeout);
			}

			if (instance == null) {
				fail(MessageFormat.format("Service \"{0}\" not available.", serviceName));
			}

			// Now get the service through BundleContext as we are closing the
			// tracker
			ServiceReference[] serviceReferences = null;
			try {
				serviceReferences = context.getServiceReferences(serviceName, filter);
			} catch (InvalidSyntaxException e) {
				fail("Invalid filter syntax.");
			}

			if (serviceReferences == null || serviceReferences.length == 0) {
				fail(MessageFormat.format("Service \"{0}\" not available.", serviceName));
			}

			return (T) context.getService(serviceReferences[0]);
		} catch (InterruptedException e) {
			fail("Interrupted.");
		} finally {
			tracker.close();
		}
		return null;
	}

	private static void fail(String message) {
		throw new RuntimeException(message);
	}
}
