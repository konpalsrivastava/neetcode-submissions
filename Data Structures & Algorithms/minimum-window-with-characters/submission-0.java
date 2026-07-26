class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        int left=0;
        int right=0;
        int start=0;
        int cnt=t.length();
        int minlen=Integer.MAX_VALUE;
        int[] freq=new int[128];
        for(char c : t.toCharArray()){
            freq[c]++;
        }
        while(right<s.length()){
            char c= s.charAt(right);
            if(freq[c]>0){
                cnt--;
            }
            freq[c]--;
            right++;
            while(cnt==0){
                if(right-left<minlen){
                    minlen=right-left;
                    start=left;
                }
                char leftc=s.charAt(left);
                freq[leftc]++;
                if(freq[leftc]>0){
                    cnt++;
                }
                left++;
            }
        }
        if(minlen==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+minlen);
    }
}
