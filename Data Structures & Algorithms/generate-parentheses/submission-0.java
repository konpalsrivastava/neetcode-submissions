class Solution {
    static void helper(String p, int open,int closed,int n,List<String> res){
        if(p.length()==2*n){
            res.add(p);
            return ;
        }
        if(open<n){
            helper(p+"(",open+1,closed,n,res);
        }
        if(closed<open){
            helper(p+")",open,closed+1,n,res);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper("",0,0,n,res);
        return res;
    }
}
