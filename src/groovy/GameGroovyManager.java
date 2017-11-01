package groovy;


import java.rmi.RemoteException;

import groovy.lang.GroovyClassLoader;
public class GameGroovyManager{
	public static void sendGroovyCodeText(String codeText) throws RemoteException {
		//执行groovy代码
		ClassLoader parent = GameGroovyManager.class.getClassLoader();
		@SuppressWarnings("resource")
		GroovyClassLoader loader = new GroovyClassLoader(parent);				
		Class<?> clz = loader.parseClass(codeText);
		try {
			IGameGroovy object = (IGameGroovy) clz.newInstance();
			object.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
