class Solution {
    public boolean canFinish(int[] piles,int h,int k){
        int total=0;
        for(int pile:piles){
            total+= (pile+k-1)/k;
        }
        return total<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
       int left=1;
       int right=0;
       for(int pi:piles){
        right=Math.max(right,pi);
       }
       int answer=right;
       while(left<=right){
        int mid=left + (right-left)/2;
        if(canFinish(piles,h,mid)){
            answer=mid;
            right=mid-1;
        }
        else{
            left=mid+1;
        }
       }
       return answer;
    }
}
