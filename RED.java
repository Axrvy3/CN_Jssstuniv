import java.util.*;

public class RED {
	
	public static void main(String[] args) {
		
		int MAX_PACKETS = 10;
		int QUEUE_SIZE = 10;
		double MAX_PROB = 0.7;
		double MIN_PROB = 0.3;

		Random rand = new Random();
		int queue_length = 0;
		double drop_prob = MIN_PROB;

		for(int i = 0; i < MAX_PACKETS; i++) {
			
			if(queue_length == QUEUE_SIZE) {
				
				System.out.println("Packet dropped (Queue Full)");
				drop_prob = MIN_PROB;
			}
			else if ((double)rand.nextDouble() < drop_prob) 
			{
				System.out.println("Packet Dropped (RANDOM)");
				drop_prob += (MAX_PROB - MIN_PROB) / (MAX_PACKETS - 1);
			}
			else 
			{
				System.out.println("Packet Accepted");
				queue_length++;
				drop_prob = MIN_PROB;
			}
		}
	}
}
