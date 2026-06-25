class Solution {
    public void helper(List<Integer> curr,List<Integer> main,List<List<Integer>> res){
        if(curr.size()==main.size()){
            res.add(new ArrayList<>(curr));
            return ;
        }
        for(int i=0;i<main.size();i++){
            if(curr.contains(main.get(i))){
                continue;
            }
            curr.add(main.get(i));
            helper(curr,main,res);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> main=new ArrayList<>();
        for(int num:nums){
            main.add(num);
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(new ArrayList<>(),main,res);
        return res;
    }
}
