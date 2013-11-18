import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StutterTest {

	/**
	 * isDelimit should tolerate the null character
	 * Expected result:false
	 * 
	 */
	@Test
	public void isDelimitNullTrue(){
		boolean result = Stutter.isDelimit((char)0);
		assertTrue(result);
	}
	@Test
	public void isDelimitNullFalse(){
		boolean result = Stutter.isDelimit((char)0);
		assertFalse(result);
	}
	@Before
	public void mainstuff(){
		
	
	String into = "This is my new new thing";
	InputStream is = new ByteArrayInputStream(Charset.forName("UTF-16").encode(into).array());
	System.setIn(is);
	}
	
	@Test
	public void checkDupesTest(){
		
		Stutter.isDelimit((char) '+');
		Stutter.isDelimit((char) 'b');
		Stutter.checkDupes((int)0);	
		
	}
	
	
	
	
	
	
}
