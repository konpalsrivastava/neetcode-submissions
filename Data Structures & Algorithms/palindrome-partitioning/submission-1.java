class Solution {
    List<List<String>> ans = new ArrayList<>();
    public boolean palindrome(int l,int h, String s){
        while(l<h){
            if(s.charAt(l)!=s.charAt(h)){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
    public void helper(int start,String s, List<String> path){
        if(start==s.length()){
            ans.add(new ArrayList<>(path));
            return ;
        }
        for(int end = start;end<s.length();end++){
            if(palindrome(start,end,s)){
                path.add(s.substring(start,end+1));
                helper(end+1,s,path);
                path.remove(path.size()-1);
            }
        }

    }
    public List<List<String>> partition(String s) {
        helper(0,s,new ArrayList<>());
        return ans;
        
    }
}
