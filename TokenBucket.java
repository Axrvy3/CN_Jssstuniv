import java.util.*;

public class TokenBucket {

	public static void main(String[] args)	{
		
		int tokens = 0;
		int rate = 10;
		int capacity = 100;
		int request[] = new int[100];

		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Enter the number of requests: ");
		n = sc.nextInt();

		System.out.println("Enter no of packets per request: ");
		for(int i = 0; i < n; i++)
			request[i] = sc.nextInt();

		for(int i = 0; i < n; i++) {
			
			if(tokens+rate > capacity)
				tokens = capacity;
			else 
				tokens = tokens + rate;

			if(tokens >= request[i]) {
				tokens = request[i];

				System.out.println("Request granted tokens remaning " + tokens);
			}
			else {
				System.out.println("Request denied not enough tokens " + tokens);
			}

		}

	}

}
