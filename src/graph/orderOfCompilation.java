//***************Order Of Compilation
//1. You are given a directed acyclic graph. The vertices represent tasks and edges represent 
//    dependencies between tasks.
//2. You are required to find and print the order in which tasks could be done. The task that should be 
//    done at last should be printed first and the task which should be done first should be printed last. 
//    This is called topological sort. Check out the question video for details.
//
//Topological sort -> A permutation of vertices for a directed acyclic graph is called topological sort if 
//                                    for all directed edges uv, u appears before v in the graph
//
//Constraints
//None
//Sample Input
//7
//7
//0 1
//1 2
//2 3
//0 3
//4 5
//5 6
//4 6
//Sample Output
//4
//5
//6
//0
//1
//2
//3
package graph;
import java.util.*;
import java.io.*;
public class orderOfCompilation {
	   static class Edge {
		      int e;
		      int v;

		      Edge(int src, int v) {
		         this.e = e;
		         this.v = v;
		      }
		   }
		   public static void dfs_topo(ArrayList<Edge>[] graph,int src, boolean[] vis, ArrayList<Integer> ans) {
		        vis[src] = true;
		        for (Edge e : graph[src]) {
		            if (!vis[e.v])
		                dfs_topo(graph,e.v, vis, ans);
		        }

		        ans.add(src);
		    }

		    public static void topologicalSort(ArrayList<Edge>[] graph,int N) {
		        boolean[] vis = new boolean[N];
		        ArrayList<Integer> ans = new ArrayList<>();
		        for (int i = 0; i < N; i++) {
		            if (!vis[i]) {
		                dfs_topo(graph,i, vis, ans);
		            }
		        }
		       while(ans.size()!=0)
		        System.out.println(ans.remove(ans.size()-1));
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
		         graph[v1].add(new Edge(v1, v2));
		      }

		      // write your code here
		      
		      topologicalSort(graph,vtces);
		   }	
}
