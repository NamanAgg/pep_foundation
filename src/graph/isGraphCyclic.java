//**************Is Graph Cyclic
//1. You are given a graph.
//2. You are required to find and print if the graph is cyclic.
//Input Format
//Input has been managed for you
//Output Format
//true if the graph is cyclic, false otherwise

//Sample Input
//7
//6
//0 1 10
//1 2 10
//2 3 10
//3 4 10
//4 5 10
//5 6 10
//Sample Output
//false
package graph;
import java.util.*;
import java.io.*;
public class isGraphCyclic {
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
		   
		   public static int bfs( ArrayList<Edge>[] graph,int src, boolean[] vis) {
		       int level = 0, cycleCount = 0;

		        LinkedList<Integer> que = new LinkedList<>();
		        que.addLast(src);

		        while (que.size() != 0) {
		            int size = que.size();
		            
		            while (size-- > 0) {
		                int rVtx = que.removeFirst();
		                if (vis[rVtx]) {
		                    cycleCount++;
		                    continue;
		                }

		                vis[rVtx] = true;
		                for (Edge e : graph[rVtx]) {
		                    if (!vis[e.v]) {
		                        que.addLast(e.v);
		                    }
		                }
		            }
		            level++;
		        }
		        return cycleCount;
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
		      boolean[]vis=new boolean[vtces];
		      int count=0;
		      for(int i=0;i<vis.length;i++)
		        if(!vis[i])
		            count+=bfs(graph,i,vis);
		    
		      if(count>0) System.out.println(true);
		      else System.out.println(false);
		      
		   }
}
