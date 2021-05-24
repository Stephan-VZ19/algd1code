/**
 * 
 */
package _05_Sortieren;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

/**
 * @author Christoph Stamm
 *
 */
class BridgeTests {
	InputStream stdin = System.in;
	PrintStream stdout = System.out;
	ByteArrayOutputStream os = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(os);
	
	void run(String input, String output) {
		try {
			System.setIn(new ByteArrayInputStream(input.getBytes()));
			System.setOut(ps);
			Bridge.main(null);
			String s = os.toString().replace(System.lineSeparator(), "\n");
			assertEquals(output.replace(System.lineSeparator(), "\n"), s);
		} catch (IOException e) {
			fail();
			e.printStackTrace();
		} finally {
			System.setIn(stdin);
			System.setOut(stdout);
		}		
	}
	
	@Test
	void test1() {
		final String inp = "1\r\n"
				+ "4\r\n"
				+ "1\r\n"
				+ "2\r\n"
				+ "5\r\n"
				+ "10\r\n";
		final String out = "17\r\n"
				+ "1 2\r\n"
				+ "1\r\n"
				+ "5 10\r\n"
				+ "2\r\n"
				+ "1 2\r\n";	
		run(inp, out);
	}

	@Test
	void test2() {
		final String inp = "1\r\n"
				+ "5\r\n"
				+ "1\r\n"
				+ "2\r\n"
				+ "3\r\n"
				+ "9\r\n"
				+ "10\r\n";
		final String out = "21\r\n"
				+ "1 2\r\n"
				+ "1\r\n"
				+ "9 10\r\n"
				+ "2\r\n"
				+ "1 3\r\n"
				+ "1\r\n"
				+ "1 2\r\n";
		run(inp, out);
	}

	@Test
	void test3() {
		final String inp = "1\r\n"
				+ "20\r\n"
				+ "95\r\n"
				+ "95\r\n"
				+ "88\r\n"
				+ "89\r\n"
				+ "62\r\n"
				+ "70\r\n"
				+ "51\r\n"
				+ "53\r\n"
				+ "45\r\n"
				+ "47\r\n"
				+ "32\r\n"
				+ "38\r\n"
				+ "28\r\n"
				+ "31\r\n"
				+ "27\r\n"
				+ "28\r\n"
				+ "24\r\n"
				+ "23\r\n"
				+ "5\r\n"
				+ "15\r\n";
		final String out = "803\r\n"
				+ "5 15\r\n"
				+ "5\r\n"
				+ "95 95\r\n"
				+ "15\r\n"
				+ "5 15\r\n"
				+ "5\r\n"
				+ "88 89\r\n"
				+ "15\r\n"
				+ "5 15\r\n"
				+ "5\r\n"
				+ "62 70\r\n"
				+ "15\r\n"
				+ "5 15\r\n"
				+ "5\r\n"
				+ "51 53\r\n"
				+ "15\r\n"
				+ "5 15\r\n"
				+ "5\r\n"
				+ "45 47\r\n"
				+ "15\r\n"
				+ "5 15\r\n"
				+ "5\r\n"
				+ "32 38\r\n"
				+ "15\r\n"
				+ "5 15\r\n"
				+ "5\r\n"
				+ "28 31\r\n"
				+ "15\r\n"
				+ "5 15\r\n"
				+ "5\r\n"
				+ "27 28\r\n"
				+ "15\r\n"
				+ "5 23\r\n"
				+ "5\r\n"
				+ "5 24\r\n"
				+ "5\r\n"
				+ "5 15\r\n";
		run(inp, out);
	}
}
