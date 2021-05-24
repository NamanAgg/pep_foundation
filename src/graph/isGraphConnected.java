//***************Is Graph Connected
//1. You are given a graph.
//2. You are required to find and print if the graph is connected (there is a path from 
//     every vertex to every other).
//Constraints
//None
//Sample Input
//7
//5
//0 1 10
//2 3 10
//4 5 10
//5 6 10
//4 6 10
//Sample Output
//false
package graph;
import java.util.*;
import java.io.*;
public class isGraphConnected {
	 static class Edge {
	      int src;
	      int v;
	      int wt;

	      Edge(int src, int nbr, int wt) {
	         this.src = src;
	         this.v = nbr;
	         this.wt = wt;
	      }
	   }
	   public static boolean isGraphConnected(int N, ArrayList<Edge>[] graph) {
	        boolean[] vis = new boolean[N];
	        int components = 0;
	        for (int i = 0; i < N; i++) {
	            if (!vis[i]) {
	                components++;
	                dfs(i, vis,graph);
	            }
	        }

	        return components == 1;
	    }
	    
	    public static void dfs(int src, boolean[] vis, ArrayList<Edge>[] graph) {
	        vis[src] = true;
	        for (Edge e : graph[src])
	            if (!vis[e.v])
	                dfs(e.v, vis,graph);
	    }
	    
	    

	   public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      int vtces = Integer.parseInt(br.readLine());
	      ArrayList<Edge>[] graph = new ArrayList[vtces];
	      for (int i = 0; i < vtces; i++) {
	         graph[i] = new ArrayList<>();
	      }

	      int edges = Integer.parseInt(br.readLine());
	      for (int i = 0; i < edges; i++) {
	         String[] parts = br.readLine().split(" ");
	         int v1 = Integer.parseInt(parts[0]);
	         int v2 = Integer.parseInt(parts[1]);
	         int wt = Integer.parseInt(parts[2]);
	         graph[v1].add(new Edge(v1, v2, wt));
	         graph[v2].add(new Edge(v2, v1, wt));
	      }

	      // write your code here
	      System.out.println(isGraphConnected(vtces,graph));
	   }
}
