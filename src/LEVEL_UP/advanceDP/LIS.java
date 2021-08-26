
package LEVEL_UP.advanceDP;
import java.util.Arrays;
public class LIS {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[]dp=new int[n];
        Arrays.fill(dp,1);
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++)
                if(nums[j]<nums[i])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            
            ans=dp[i]>ans?dp[i]:ans;
        }
        return ans;
    }
    public static int MaximumOverlappingBridges(int[][]points){

        Arrays.sort(points,(t,o)->{
            return t[0]-o[0];
        });

        int[] dp=new int[points.length];
        Arrays.fill(dp,1);
        int ans=0;
        for(int i=0;i<points.length;i++){
            for(int j=0;j<i;j++)
                if(points[j][1]<points[i][1])
                    dp[i]=Math.max(dp[i],dp[j]+1);
            
            ans=dp[i]>ans?dp[i]:ans;
        }

        return ans;

    }
}
