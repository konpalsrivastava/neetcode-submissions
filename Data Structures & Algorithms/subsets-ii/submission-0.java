class Solution {
    public void helper(List<Integer> up,List<Integer> p, List<List<Integer>> res){
        if(up.isEmpty()){
            res.add(new ArrayList<>(p));
            return ;
        }
        int element = up.get(0);
        p.add(element);
        int i=1;
        while(i<up.size() && up.get(i).equals(up.get(0))){
            i++;
        }
        List<Integer> rem = new ArrayList<>(up.subList(1,up.size()));
        helper(rem,p,res);

        p.remove(p.size()-1);

        List<Integer> rem1 = new ArrayList<>(up.subList(i,up.size()));
        helper(rem1,p,res);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> up =new ArrayList<>();
        for(int num:nums){
            up.add(num);
        }
        Collections.sort(up);
        List<List<Integer>> res = new ArrayList<>();
        helper(up,new ArrayList<>(),res);
        return res;
    }
}
