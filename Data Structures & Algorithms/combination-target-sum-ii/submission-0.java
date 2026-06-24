class Solution {
    public void helper(List<Integer> main,List<Integer> curr,int target,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(curr));
            return ;
        }
        if(target<0 || main.isEmpty()){
            return ;
        }
        int element = main.get(0);
        curr.add(element);
        int i=1;
        while(i<main.size() && main.get(i).equals(main.get(0))){
            i++;
        }
        List<Integer> rem = new ArrayList<>(main.subList(1,main.size()));
        helper(rem,curr,target-element,res);

        curr.remove(curr.size()-1);

        List<Integer> rem1 = new ArrayList<>(main.subList(i,main.size()));
        helper(rem1,curr,target,res);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> main = new ArrayList<>();
        for(int num:candidates){
            main.add(num);
        }
        List<List<Integer>> res = new ArrayList<>();
        Collections.sort(main);
        helper(main,new ArrayList<>(),target,res);
        return res;
    }
}
