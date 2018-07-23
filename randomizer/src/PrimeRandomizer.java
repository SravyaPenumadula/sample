import java.util.*;
import java.util.concurrent.*;

public class PrimeRandomizer {
	
	public static void main(String[] args){
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20);
		
		Thread Prime = new Thread(new Prime(queue));
		
		Thread Randomizer = new Thread(new Randomizer(queue));
		
		Prime.start();
		Randomizer.start();
	}

}
