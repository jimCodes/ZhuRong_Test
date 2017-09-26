package test;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class IoBufferTest {
		private static final int BSIZE = 1024;

		public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		IntBuffer ib = bb.asIntBuffer(); // view buffer

		// 存储int的数�?
		ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016});

		// 绝对位置读写
		System.out.println(ib.get(3));

		System.out.println("*******************************");
		System.out.println(ib.limit());
		ib.put(3, 1811);
		ib.flip();
		System.out.println(ib.limit());
		System.out.println("*******************************");
		
		ib.put(5);
		ib.rewind();

		while(ib.hasRemaining()){
		int i = ib.get();
		System.out.println(i);
		}
		System.out.println("----------------");
		while(ib.hasRemaining()){
			int i = ib.get();
			System.out.println(i);
			}
		}

}
