import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsDfs {
	private LinkedList<Integer> adj[];

	BfsDfs(int v) {
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}

	void dfsUtil(int start, int v, BfsDfs graph, boolean visited[]) {
		visited[start] = true;
		System.out.print(start + " -> ");
		Iterator<Integer> iterator = graph.adj[start].listIterator();
		while (iterator.hasNext()) {
			int temp = iterator.next();
			if (!visited[temp])
				dfsUtil(temp, v, graph, visited);
		}
	}

	void dfs(int start, int v, BfsDfs graph) {
		boolean visited[] = new boolean[v];
		dfsUtil(start, v, graph, visited);
	}

	void bfs(int start, int v, BfsDfs graph) {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[v];
		q.add(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int present = q.peek();
			q.remove();
			System.out.print(present + " -> ");
			Iterator<Integer> iterator = graph.adj[present].listIterator();
			while (iterator.hasNext()) {
				int temp = iterator.next();
				if (visited[temp] != true) {
					q.add(temp);
					visited[temp] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of vertices & edges:");
		int v = sc.nextInt();
		int e = sc.nextInt();
		BfsDfs graph = new BfsDfs(v);
		System.out.println("Enter " + e + " edges");
		for (int i = 0; i < e; i++) {
			int source = sc.nextInt();
			int destination = sc.nextInt();
			graph.addEdge(source, destination);
		}
		graph.dfs(1, v, graph);
		System.out.println();
		graph.bfs(0, v, graph);
		sc.close();
	}
}

// 5 6
// 0 1
// 0 4
// 1 2
// 1 4
// 2 3
// 3 4