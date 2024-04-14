import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 0;
        int max = Integer.MAX_VALUE;
        
        while(min <= max){
            int mid = (min + max) / 2;
    
            if(canAcross(mid, k, stones)){
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }
        
        return answer;
    }
    
    public boolean canAcross(int M, int k, int[] stones){
        int count = 0;
        for(int i = 0; i < stones.length; i++){
            if(stones[i] < M){
                count++;
                if(count == k){
                    return false;
                }
            } else {
                count = 0;
            }
        }
        
        return true;
    }
}