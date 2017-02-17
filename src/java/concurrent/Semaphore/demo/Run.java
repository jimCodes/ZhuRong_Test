package java.concurrent.Semaphore.demo;

public class Run {

	public static void main(String[] args) {

		RepastService repastService = new RepastService();
		int length = 10;
		ThreadGet[] getThread = new ThreadGet[length];
		ThreadSet[] setThread = new ThreadSet[length];

		for (int i = 0; i < getThread.length; i++) {
			getThread[i] = new ThreadGet(repastService);
			setThread[i] = new ThreadSet(repastService);
		}

		for(int j=0;j< getThread.length;j++){
			setThread[j].start();
			getThread[j].start();
		}
	}

}
