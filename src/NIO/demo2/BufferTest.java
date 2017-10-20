package NIO.demo2;

import java.nio.CharBuffer;

public class BufferTest {
	public static void main(String[] args) {
		CharBuffer cb = CharBuffer.allocate(1000);
		char[] array = new char[1000];
		CharBuffer cbf = CharBuffer.wrap(array);
	}
}
