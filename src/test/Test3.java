package test;
import java.util.Random;

public class Test3 {

	public static void main(String[] args) {
		int vip = 1;
		int N = 10;//鱼的倍数
		int b = 0;// 炮的命中率加�?
		int X = 100;//每段场景概率 50~150
		int Y =100;//个人彩金池加�? 100或�??130
		long rd = new Random(System.currentTimeMillis()).nextInt(64*10000000);
		System.out.println("                          :"+64*10000000);
		System.out.println("System.currentTimeMillis():"+System.currentTimeMillis()/1000);
		System.out.println("rd:                       :"+rd);
		boolean isDie = rd * N < ((64*1000 + (vip +64 * b) * N) * X * Y);
		boolean isDie2 = rd * N < ((64*1000 + vip * N) * X * Y);
		if(isDie) System.out.println("die");
		else System.out.println("undie");
		//
	}
	

}