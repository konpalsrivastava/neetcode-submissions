class Solution {
    public void helper(List<Integer> p ,List<Integer> up,List<List<Integer>> res){
        if(up.isEmpty()){
            res.add(new ArrayList<>(p));
            return ;
        }
        int element = up.get(0);
        List<Integer> rem = up.subList(1,up.size());
        p.add(element);
        helper(p,rem,res);
        p.remove(p.size()-1);
        helper(p,rem,res);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> up = new ArrayList<>();
        for(int num:nums){
            up.add(num);
        }
        List<List<Integer>> res= new ArrayList<>();
        helper(new ArrayList<>(),up,res);
        return res;
    }
}
