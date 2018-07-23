import java.util.*;
import java.util.concurrent.*;
class Prime implements Runnable {
	
	private BlockingQueue<Integer> queue;
	
	public Prime (BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				queue.put(produce());
				
				Thread.sleep(500);
				
			}
			
			queue.put(-1);
			
			System.out.println("Producer STOPPED");
		} catch (InterruptedException ie){
			ie.printStackTrace();
		}
	}
	private Integer produce() {
		Integer number = new Integer((int) (Math.random() * 100));
		
		if(number==1){System.out.println(number + "is not prime");
		return 0;
		}
		if(number > 2 && number%2 == 0) {
			return 0;
		}
		int top = (int)Math.sqrt(number);
		for (int i = 3; i < top; i+=2){
			if(number % i == 0){
				System.out.println(number + "is not prime");
				return 0;
			}
		}
		
		System.out.println("Producing number => " + number);
		
		return number;
	}
	
	

}
