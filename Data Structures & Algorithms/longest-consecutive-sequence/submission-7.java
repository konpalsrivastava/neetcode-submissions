class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> seq = new HashSet<>();
        for(int num:nums){
            seq.add(num);
        }
        int maxlen=0;
        for(int num:seq){
            if(!seq.contains(num-1)){
                int curr=num;
                int len=1;
                while(seq.contains(curr+1)){
                    curr++;
                    len++;
                }
                maxlen=Math.max(maxlen,len);
            }
        }
        return maxlen;
    }
}
