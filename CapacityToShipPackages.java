//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days
//TC : nlog(r)  -> n - number of packages; r -> capacity range [total sum of weights - max weight]
//SC : O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for(int wt : weights){
            low = Math.max(low,wt);
            high += wt;
        }
        while(low <= high){
            int currCap = low + (high - low)/2;
            int currDays = 0;
            int cap = 0;
            for(int wt : weights){
                if(cap + wt > currCap){
                    currDays++;
                    cap = 0;
                }
                cap += wt;
            }
            if(currDays < days){
                high = currCap - 1;
            }else{
                low = currCap + 1;
            }
        }
        return low;
    }
}
