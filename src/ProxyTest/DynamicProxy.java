package ProxyTest;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

public class DynamicProxy {
	public static void main(String args[]) {
		RelSubject real = new RelSubject();
		Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
				new Class[] { Subject.class }, new ProxyHandler(real));

		proxySubject.doSomething();

		// write proxySubject class binary data to file
		createProxyClassFile();
	}

	public static void createProxyClassFile() {
		String name = "ProxySubject";
		byte[] data = ProxyGenerator.generateProxyClass(name, new Class[] { Subject.class });
		try {
			FileOutputStream out = new FileOutputStream(name + ".class");
			out.write(data);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}