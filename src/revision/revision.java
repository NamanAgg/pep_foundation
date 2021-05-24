package revision;

public class revision {

	
	public static int floodfill(int sr,int sc,int dr,int dc,int[][]dir,String[]dirs,boolean[][]vis,String psf) {
		if(sr==dr&&sc==dc) {
			System.out.println(psf);
			return 1;
		}
		vis[sr][sc]=true;
		int count=0;
		
		for(int d=0;d<dir.length;d++) {
			int r=sr+dir[d][0];
			int c=sc+dir[d][1];
			
			if(r>=0 && c>=0 && r<vis.length && c<vis[0].length && !vis[r][c]) {
				count+=floodfill(r,c,dr,dc,dir,dirs,vis,psf+dirs[d]);
			}
		}
		vis[sr][sc]=false;
		return count;
	}
	
	
	
	public static void main(String[] args) {
		int n=2;
		int m=2;
		boolean[][]vis=new boolean[n][m];
		String[]dirs= {"W","nw","N","ne","E","se","S","sw"};
		int[][]dir= {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
		System.out.println(floodfill(0,0,n-1,m-1,dir,dirs,vis,""));
		
	}
}
