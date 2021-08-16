import java.util.*;
import java.io.*;
public class practice {
    

    public int maxGroups(int N,int []arr){
        int ans=0;
        Arrays.sort(arr);
        int i=0;
        while(i<N-1){
            if(arr[i]==arr[i+1]){
                ans++;//they can form a diff grp
                i+=2;
            }
            else{
                //it means it can be a part of already made grp
                i++;
            }
        }
        return ans;
    }
}
