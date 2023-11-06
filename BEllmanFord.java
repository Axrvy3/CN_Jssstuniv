import java.util.*;

public class BellmanFord {

	private static int N;
	private static int [][] graph;

	public static void bellmanFord(int src) {
		
		int [] dist = new int[N];

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;

		for (int i = 1; i < N; i++) {
			for (int u = 0; u < N; u++) {
				for (int v = 0; v < N; v++) {
					if(graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
						dist[v] = dist[u] + graph[u][v];	
					}
				}
			}
		}
		
		for (int u = 0; u < N; u++) {
			for (int v = 0; v < N; v++) {
				if(graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v]<dist[v]) {
						
						System.out.println("Negative Wegith Cycle Detected");
						return;
				}
			}
		}

		printSolution(dist);
	}
	
	public static void printSolution(int[] dist) {

		System.out.println("Vertex\tDistanec from Source");
		for(int i = 0; i < N; i++) {
			System.out.println((i+1) + "\t" + dist[i]);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Size of matrix");
		N = sc.nextInt();
		System.out.println("Enter weight matrix of graph");
		graph = new int[N][N];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				graph[i][j] = sc.nextInt();
			}
		}

		System.out.print("Enter source Vertex: ");
		int source = sc.nextInt();
		bellmanFord(source - 1);
	}

}
