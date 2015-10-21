package com.org.powermock;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.org.service.MockService;
import com.org.util.MockUtility;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MockUtility.class)
public class StaticMethodTest {

	@Test
	public void mockStaticMethodAndVerifyStaticMethod() {
		// init
		MockService mockService = new MockService();
		PowerMockito.mockStatic(MockUtility.class);

		// verify return value
		when(MockUtility.isSafe(anyInt())).thenReturn(false);
		boolean res = mockService.isAllowBuy(2);
		assertFalse(res);

		// verify method call
		PowerMockito.verifyStatic(times(1));
		MockUtility.isSafe(anyInt());
	}

	@Test(expected = RuntimeException.class)
	public void mockStaticMethodThrowException() {
		// prepare
		MockService service = new MockService();
		PowerMockito.mockStatic(MockUtility.class);

		// verify exception
		PowerMockito.doThrow(new RuntimeException()).when(MockUtility.isSafe(anyInt()));
		service.isAllowBuy(2);
	}

}
