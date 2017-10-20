/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author R.Zhu
 * 	
 * 2017年9月28日
 */
public class TestList {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(1);
		for(int i=0;i<100000;i++){
			list.add(0,i);
		}
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}

}
