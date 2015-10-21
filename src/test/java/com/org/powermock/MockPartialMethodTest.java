package com.org.powermock;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.org.service.MockService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MockService.class)
public class MockPartialMethodTest {

	@Test
	public void mockPartialPrivateMethod() throws Exception {
		MockService mockService = new MockService();
		mockService = PowerMockito.spy(mockService);
		PowerMockito.doReturn(false).when(mockService, "isNeedHandle", anyInt());

		// verify
		boolean res = mockService.handle(2);
		assertFalse(res);
		PowerMockito.verifyPrivate(mockService, times(1)).invoke("isNeedHandle", anyInt());
	}

}
