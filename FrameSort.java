import java.util.*;

public class FrameSort {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		List <int[]> frame = new ArrayList<>();

		System.out.println("Enter the number of Frames requried");
		int n = sc.nextInt();
		

		Random rd = new Random();

		for(int i = 0; i < n; i++) 
		{
			int num = rd.nextInt();
			if(num < 1) num *= -1;
			System.out.printf("Enter the data for %d frame " , (i+1));

			int data = sc.nextInt();
			frame.add(new int[]{num, data});
		
		}

		System.out.println("Data at client end");

		System.out.println("Sequence Number\t Data");

		for(int [] frames: frame) 
			System.out.printf("%d\t%d\n", frames[0], frames[1]);

		System.out.println("Data Received at server side\n Sorting is Done");

		int count = 1;

		for(int[] i:frame) {
			i[0] = count++;
			System.out.printf("%d\t%d\n", i[0], i[1]);
		}
		
	}
	
}
