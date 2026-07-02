class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         Stack<Integer> st = new Stack<>();
         int[] ans = new int[temperatures.length];
         Arrays.fill(ans,0);
         for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty()&&temperatures[st.peek()]<temperatures[i]){
                int poppedDay = st.pop();
                ans[poppedDay]=i-poppedDay;
            }
            st.push(i);
         }
         return ans;
    }
}
