package reids;

public class BooTest {

	
	public static void main(String[] args) {
		BooTest booTest = new BooTest();
		Boolean isFlag = new Boolean(false);
		booTest.test(isFlag);
		System.out.println(isFlag);
		
		
	}
	
	
	
	public void test(Boolean isFlag){
		isFlag = true;
	}
}
