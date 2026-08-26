class Solution {
    public int expand(int left,int right,String s){
        int cnt=0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            count+=expand(i,i,s);
            count+=expand(i,i+1,s);
        }
        return count;
    }
}
