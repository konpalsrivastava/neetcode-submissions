class Solution {
    public boolean canfinish(int[] piles,int h,int k){
        int total = 0;
        for(int pile:piles){
            total += Math.ceil((double)pile/k);
        }
        return total<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int pile:piles){
            high = Math.max(pile,high);
        }
        int answer = high;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(canfinish(piles,h,mid)){
                answer = mid;
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return answer;
    }
}
