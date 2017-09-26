package test;

public class TestStr {
	public static void main(String[] args) {
		StringBuilder a= new StringBuilder();
		update(a);
		System.out.println(a);
	}
	private static void update(StringBuilder a){
		a.append("woshi");
	}
}
