import static org.junit.Assert.*;

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
}
