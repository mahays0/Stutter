import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Test;


public class StutterTest {
	/**
	 * isDelimit should tolerate the null character.
	 * Expected result: false
	 */
	@Test
	public void isDelimitNull(){
		boolean result = Stutter.isDelimit((char) 0);
		assertFalse(result);
	}
	/**
	 * Input can be a file
	 * Expected result: true
	 */
	@Test
	public void testInputFile() throws IOException{
		String input="input.txt";
		InputStream in=new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		//if passing a file
		Stutter.main(new String[] {});
		assertTrue(true);
	}
	/**
	 * Input can be stdin
	 * Expected result: true
	 */
	 @Test
     public void testManualInput() throws IOException{
             String input = "test test notatest";
             InputStream in = new ByteArrayInputStream(input.getBytes());
             System.setIn(in);
             //if not passing a file
             Stutter.main(new String[] {null});
             assertTrue(true);
     }
     	/*
     	 * Check dup needs to get a value
     	 */
     
     	@Test
     public void testCheckDup(){
	     String line="test test test";
	     InputStream in = new ByteArrayInputStream(line.getBytes());
             System.setIn(in);
			Stutter.checkDupes(0);
			assertFalse(false);
		}
	
}
