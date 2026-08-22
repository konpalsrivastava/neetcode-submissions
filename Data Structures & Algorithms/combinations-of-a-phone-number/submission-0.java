class Solution {
    String[] letter = {""," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        helper(ans,digits,"",0);
        return ans;
    }
    public void helper(List<String> ans, String digits,String curr,int idx){
        if(idx==digits.length()){
            ans.add(curr);
            return ;
        }
        int x = digits.charAt(idx)-'0';
        String possible = letter[x];
        for(char ch : possible.toCharArray()){
            helper(ans,digits,curr+ch,idx+1);
        }
        }
}
