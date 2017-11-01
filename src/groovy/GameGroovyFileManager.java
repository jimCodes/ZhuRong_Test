package groovy;

import java.io.File;
import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;

import groovy.lang.GroovyClassLoader;

public class GameGroovyFileManager {
	public static String sendGroovyCodeText(String filePath) throws CompilationFailedException, IOException {
    	String groovyFilePath=System.getProperty("user.dir") + File.separator + "memoryscript";
		String pathname=groovyFilePath + "/"+filePath;
		File file=new File(pathname);
		if(!file.exists()){
			return "file exist-->"+pathname;
		}
		try {
			//执行groovy代码
			ClassLoader parent = GameGroovyManager.class.getClassLoader();
			@SuppressWarnings("resource")
			GroovyClassLoader loader = new GroovyClassLoader(parent);				
			Class<?> clz = loader.parseClass(file);

			IGameGroovy object = (IGameGroovy) clz.newInstance();
			object.execute();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
}
