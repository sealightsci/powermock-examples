package com.org.powermock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import com.org.service.MockService;

public class PrivateFieldMethodTest {

	private MockService mockService;

	@Before
	public void setUp() {
		mockService = new MockService();
	}

	@Test
	public void modifyPrivateField() throws Exception {
		Field thresholdField = PowerMockito.field(MockService.class, "threshold");
		thresholdField.set(null, 10);
		int result = mockService.sumOfN();
		assertEquals(10, result);
	}

	@Test
	public void testPrivateMethod() throws Exception {
		Method isPositiveNumberMethod = PowerMockito.method(MockService.class, "isPositiveNumber",
				new Class[] { int.class });
		boolean result = (Boolean) isPositiveNumberMethod.invoke(mockService, 2);
		assertTrue(result);
	}

	@Test
	public void verifyPrivateMethodInvoke() throws Exception {
		mockService.foreach(2);
		PowerMockito.verifyPrivate(mockService, times(2)).invoke("isPositiveNumber", anyInt());
	}

}
