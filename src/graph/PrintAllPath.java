//*******************Print All Paths
//1. You are given a graph, a source vertex and a destination vertex.
//2. You are required to find and print all paths between source and destination. Print 
//     them in lexicographical order.(just print all paths)
//    E.g. Check the following paths
//             012546
//             01256
//             032546
//             03256
//    The lexicographically smaller path is printed first.
//Sample Input
//7
//8
//0 1 10
//1 2 10
//2 3 10
//0 3 10
//3 4 10
//4 5 10
//5 6 10
//4 6 10
//0
//6
//Sample Output
//0123456
//012346
//03456
//0346
package graph;
import java.util.*;
import java.io.*;
public class PrintAllPath {
	 public static class Edge {
	        int v = 0;
	        int w = 0;

	        Edge(int v, int w) {
	            this.v = v;
	            this.w = w;
	        }
	   }
	         
	    public static int allPath(ArrayList<Edge>[]graph,int src, int dest, boolean[] vis, String ans) {
	        if (src == dest) {
	            System.out.println(ans + dest);
	            return 1;
	        }

	        int count = 0;
	        vis[src] = true;
	        for (Edge e : graph[src]) {
	            if (!vis[e.v])
	                count += allPath(graph,e.v, dest, vis, ans + src);
	        }

	        vis[src] = false;
	        return count;
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
	    boolean[]vis = new boolean[vtces];
	      // write all your codes here
	      allPath(graph,src,dest,vis,"");
	   }


}
