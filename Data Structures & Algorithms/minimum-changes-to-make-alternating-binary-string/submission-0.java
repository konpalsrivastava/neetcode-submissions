class Solution {
    public int minOperations(String s) {
        char expected ;
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                expected = '0';
            }
            else{
                expected = '1';
            }
            if(expected!=s.charAt(i)){
                cnt++;
            }
        }
        return Math.min(cnt,s.length()-cnt);
    }
}