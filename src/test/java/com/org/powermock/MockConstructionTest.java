package com.org.powermock;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.org.service.MockService;
import com.org.util.MockUtility;

// @RunWith(PowerMockRunner.class)
// @PrepareForTest(MockService.class)
public class MockConstructionTest {

	@Test
	public void mockConstruction() throws Exception {
		// init
		final String name = "hello";
		MockService mockService = new MockService();
		MockUtility mockUtility = new MockUtility(name);
		
		
		// return obj on no argument constructor call
		PowerMockito.whenNew(MockUtility.class).withNoArguments().thenReturn(mockUtility);
		MockUtility defaultConstructorMockUtility = mockService.getUtil();
		assertEquals("name", defaultConstructorMockUtility.getName());
	}

}
