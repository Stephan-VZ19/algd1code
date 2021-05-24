package sortieren_05;

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
class ShoemakerTests {
	InputStream stdin = System.in;
	PrintStream stdout = System.out;
	ByteArrayOutputStream os = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(os);

	void run(String input, String output) {
		try {
			System.setIn(new ByteArrayInputStream(input.getBytes()));
			System.setOut(ps);
			Shoemaker.main(null);
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
				+ "3 4\r\n"
				+ "1 1000\r\n"
				+ "2 2\r\n"
				+ "5 5\r\n"
				+ "";
		final String out = "2 1 3 4\r\n";
		run(inp, out);
	}

	@Test
	void test2() {
		final String inp = "1\r\n"
				+ "8\r\n"
				+ "5 6062\r\n"
				+ "866 8139\r\n"
				+ "830 5833\r\n"
				+ "667 2783\r\n"
				+ "183 3984\r\n"
				+ "732 501\r\n"
				+ "772 7517\r\n"
				+ "172 7126\r\n"
				+ "";
		final String out = "1 8 5 7 2 3 4 6\r\n";
		run(inp, out);
	}

	@Test
	void test3() {
		final String inp = "1\r\n"
				+ "8\r\n"
				+ "3 4\r\n"
				+ "1 1000\r\n"
				+ "2 2\r\n"
				+ "5 5\r\n"
				+ "8 9\r\n"
				+ "6 6\r\n"
				+ "7 100\r\n"
				+ "100 100\r\n";
		final String out = "2 7 1 5 3 4 6 8\r\n";
		run(inp, out);
	}

}
