package com.org.powermock;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.org.util.MockUtility;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MockUtility.class)
public class MockJavaLibraryTest {

	@Test
	public void mockThreadClass() throws Exception {
		// init
		PowerMockito.mockStatic(Thread.class);

		// verify
		MockUtility.sleep(1000);

		PowerMockito.verifyStatic(times(1));
		Thread.sleep(anyLong());
	}

	@Test
	public void mockFileClass() throws Exception {
		// init
		File file = mock(File.class);
		PowerMockito.whenNew(File.class).withArguments(anyString()).thenReturn(file);

		// action
		MockUtility.readFile(anyString());

		// assert
		verify(file, times(1)).getAbsolutePath();
	}

}
