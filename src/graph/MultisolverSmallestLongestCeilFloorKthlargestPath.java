//*****************Multisolver - Smallest, Longest, Ceil, Floor, Kthlargest Path
//1. You are given a graph, a src vertex and a destination vertex.
//2. You are give a number named "criteria" and a number "k".
//3. You are required to find and print the values of 
//3.1 Smallest path and it's weight separated by an "@"
//3.2 Largest path and it's weight separated by an "@"
//3.3 Just Larger path (than criteria in terms of weight) and it's weight separated by an "@"
//3.4 Just smaller path (than criteria in terms of weight) and it's weight separated by an "@"
//3.5 Kth largest path and it's weight separated by an "@"
//Constraints
//None
//Sample Input
//7
//9
//0 1 10
//1 2 10
//2 3 10
//0 3 40
//3 4 2
//4 5 3
//5 6 3
//4 6 8
//2 5 5
//0
//6
//30
//4
//Sample Output
//Smallest Path = 01256@28
//Largest Path = 032546@66
//Just Larger Path than 30 = 012546@36
//Just Smaller Path than 30 = 01256@28
//4th largest path = 03456@48
package graph;
import java.util.*;
import java.io.*;
public class MultisolverSmallestLongestCeilFloorKthlargestPath {
	  public static class Edge {
	        int v = 0;
	        int w = 0;

	        Edge(int v, int w) {
	            this.v = v;
	            this.w = w;
	        }
	   }
	   

	 public static class pair {
	        int largestWeight = -(int) 1e9;
	        String largestPath = "";
	        int smallestWeight = (int) 1e9;
	        String smallestPath = "";

	        int ceil = (int) 1e9;
	        String ceilPath = "";
	        int floor = -(int) 1e9;
	        String floorPath = "";

	    }

	    public static class pqPair {
	        int wsf = 0;
	        String psf = "";

	        pqPair(int wsf, String psf) {
	            this.wsf = wsf;
	            this.psf = psf;
	        }
	    }

	    static PriorityQueue<pqPair> pq = new PriorityQueue<>((a, b) -> {
	        return a.wsf - b.wsf;
	    });

	    public static void allSolution(ArrayList<Edge>[]graph,int src, int dest, boolean[] vis   , pair p, String psf, int wsf, int givenWeight,int k) {

	        if (src == dest) {
	            if (wsf > p.largestWeight) {
	                p.largestWeight = wsf;
	                p.largestPath = psf + dest;
	            }

	            if (wsf < p.smallestWeight) {
	                p.smallestWeight = wsf;
	                p.smallestPath = psf + dest;
	            }

	            if (wsf < givenWeight)
	                if (wsf > p.floor) {
	                    p.floor = wsf;
	                    p.floorPath = psf + dest;
	                }
	            if (wsf > givenWeight)
	                if (wsf < p.ceil) {
	                    p.ceil = wsf;
	                    p.ceilPath = psf + dest;
	                }

	            pq.add(new pqPair(wsf, psf + dest));
	            if (pq.size() > k)
	                pq.remove();

	            return;
	        }

	        vis[src] = true;
	        for (Edge e : graph[src]) {
	            if (!vis[e.v])
	                allSolution(graph,e.v, dest, vis, p, psf + src, wsf + e.w, givenWeight, k);
	        }

	        vis[src] = false;
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
	         graph[v1].add(new Edge(v2, wt));
	         graph[v2].add(new Edge(v1, wt));
	      }

	      int src = Integer.parseInt(br.readLine());
	      int dest = Integer.parseInt(br.readLine());

	      int criteria = Integer.parseInt(br.readLine());
	      int k = Integer.parseInt(br.readLine());

	      boolean[] visited = new boolean[vtces];
	      pair p = new pair();
	      allSolution(graph, src, dest, visited,p,"",0,criteria,k);
	      System.out.println("Smallest Path = " + p.smallestPath  + "@" + p.smallestWeight);
	      System.out.println("Largest Path = " + p.largestPath + "@" + p.largestWeight);
	      System.out.println("Just Larger Path than " + criteria + " = " + p.ceilPath + "@" +  p.ceil);
	      System.out.println("Just Smaller Path than " + criteria + " = " + p.floorPath + "@" + p.floor);
	      System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
	   }
}
