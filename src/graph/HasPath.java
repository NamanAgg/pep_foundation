//**************Has Path?
//1. You are given a graph, a src vertex and a destination vertex.
//2. You are required to find if a path exists between src and dest. If it does, print true 
//     otherwise print false.
//Constraints
//None
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
//true
package graph;
import java.util.*;
import java.io.*;
public class HasPath {
	static class Edge {
	      int v;
	      int wt;

	      Edge(int nbr, int wt){
	         this.v = nbr;
	         this.wt = wt;
	      }
	   }
	   
	   public static boolean hasPath(int src,int dest, boolean[]vis,ArrayList<Edge>[] graph){
	       if(src==dest) return true;
	       
	       boolean res=false;
	       vis[src]=true;
	       
	       for(Edge e: graph[src]){
	           if(!vis[e.v]){
	               res=res||hasPath(e.v,dest,vis,graph);
	           }
	       }
	       
	       return res;
	   }
	   public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      int vtces = Integer.parseInt(br.readLine());
	      ArrayList<Edge>[] graph = new ArrayList[vtces];
	      for(int i = 0; i < vtces; i++){
	         graph[i] = new ArrayList<>();
	      }

	      int edges = Integer.parseInt(br.readLine());
	      for(int i = 0; i < edges; i++){
	         String[] parts = br.readLine().split(" ");
	         int v1 = Integer.parseInt(parts[0]);
	         int v2 = Integer.parseInt(parts[1]);
	         int wt = Integer.parseInt(parts[2]);
	         graph[v1].add(new Edge(v2, wt));
	         graph[v2].add(new Edge(v1, wt));
	      }

	      int src = Integer.parseInt(br.readLine());
	      int dest = Integer.parseInt(br.readLine());

	      // write your code here
	      boolean[] vis=new boolean[vtces];
	      System.out.println(hasPath(src,dest,vis,graph));
	    }

}
