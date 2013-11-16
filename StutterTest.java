import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.junit.Test;


public class StutterTest {
	ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	PrintStream original;
	@Test
	public final void testMainStdIn() throws IOException{
		original = System.out;
		System.setOut(new PrintStream(outContent));
		
		outContent.reset();
		String args[] = {null};
		String input = "This line has no stutter\n"+"this line has stutter stutter\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Stutter.main(args);
		assertEquals("Repeated word on line 2: stutter stutter\n", outContent.toString());
		
		outContent.reset();
		args = new String[]{};
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		Stutter.main(args);
		assertEquals("Repeated word on line 2: stutter stutter\n", outContent.toString());
		System.setOut(original);
	}
	
	@Test
	public final void testMainFileIn() throws IOException{
		PrintWriter writer = new PrintWriter("testInputFile", "UTF-8");
		writer.println("This line has no stutter");
		writer.println("this line has stutter stutter");
		writer.close();
		
		original = System.out;
		System.setOut(new PrintStream(outContent));
		String args[] = new String[]{"testInputFile"};
		Stutter.main(args);	
		assertEquals("Repeated word on line 2: stutter stutter\n", outContent.toString());
		System.setOut(original);
	}


}