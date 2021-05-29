//***************Is Graph Bipartite
//1. You are given a graph.
//2. You are required to find and print if the graph is bipartite
//Note -> A graph is called bipartite if it is possible to split it's vertices in two sets of mutually 
//               exclusive and exhaustive vertices such that all edges are across sets.
//Input Format
//Input has been managed for you
//Output Format
//true if the graph is bipartite, false otherwise
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
//Sample Output
//false
package graph;
import java.util.*;
import java.io.*;
public class isGraphBipartite {
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
		   
		   public static boolean isBipartite(ArrayList<Edge>[] graph,int src,int[]vis){
		        LinkedList<Integer> que = new LinkedList<>();
		       

		        que.addLast(src);
		        int color = 0;

		        // -1 -> undefine, 0 -> red, 1 -> green.
		        while(que.size() != 0){
		            int size = que.size();
		            while(size-- > 0){
		                int rvtx = que.removeFirst();
		                if(vis[rvtx] != -1){
		                    if(vis[rvtx] != color)  // conflict
		                      return false;
		                    
		                    continue;
		                }

		                vis[rvtx] = color;
		                for(Edge e : graph[rvtx]){
		                    if(vis[e.v] == -1){
		                        que.addLast(e.v);
		                    }
		                }
		            }

		            color = (color + 1) % 2;
		        }

		        return true;
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
		      boolean res=false;
		       int[] vis = new int[vtces];
		        Arrays.fill(vis,-1);
		        for(int i=0;i<vis.length;i++){
		            if(vis[i]==-1){
		                res=isBipartite(graph,i,vis);
		            }
		        }
		        
		        System.out.println(res);
		   }
}
