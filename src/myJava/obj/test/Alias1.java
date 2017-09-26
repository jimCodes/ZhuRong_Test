package myJava.obj.test;

public class Alias1 {
	
	int i;

	Alias1(int ii) {
		i = ii;
	}
/*	Alias1 y = x; // Assign the handle
	它会新建一个Alias1 句柄，但不是把它分配给由new创建的一个新鲜对象，而是分配给一个现有的句柄。所
	以句柄x 的内容——即对象 x指向的地址——被分配给y，所以无论 x还是y 都与相同的对象连接起来。这
	样一来*/
	public static void main(String[] args) {
		Alias1 x = new Alias1(7);
		Alias1 y = x; // Assign the handle
		System.out.println("x: " + x.i);//7
		System.out.println("y: " + y.i);//7
		System.out.println("Incrementing x");
		x.i++;
		System.out.println("x: " + x.i);//8
		System.out.println("y: " + y.i);//8
	}
} 