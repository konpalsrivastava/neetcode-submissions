class Solution {
    public void helper(List<Integer> main,int idx,List<Integer> curr,int target,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target<0||idx==main.size()){
            return;
        }
        int element = main.get(idx);
        curr.add(element);
        helper(main,idx,curr,target-element,res);
        curr.remove(curr.size()-1);
        helper(main,idx+1,curr,target,res);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> main = new ArrayList<>();
        for(int num:nums){
            main.add(num);
        }
        helper(main,0,new ArrayList<>(),target,res);
        return res;
    }
}
