import java.util.*;
import java.util.concurrent.*;

public class Randomizer implements Runnable  {
	
	private BlockingQueue<Integer> queue;
	
	public Randomizer(BlockingQueue<Integer> queue){
		this.queue = queue;
	}
	
	public void run() {
		try {
			
			while (true) {
				
			Integer number = queue.take();
			if (number == null || number == -1) {
				break;
			}
			
			if(number == 0) {
				continue;
			}
			
			consume(number);
			
			Thread.sleep(1000);
			
			}
			
			System.out.println("Consumer STOPPED.");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	private void consume(Integer number) {
		System.out.println("Consuming number <= " +number);
	}

}
