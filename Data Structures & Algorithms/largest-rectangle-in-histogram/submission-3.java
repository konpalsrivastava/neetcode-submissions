class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[heights.length];
        int[] nse = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) pse[i] = -1;
            else{
                pse[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) nse[i] = heights.length;
            else{
                nse[i] = st.peek();
            }
            st.push(i);
        }
        int maxarea=0;
        for(int i=0;i<heights.length;i++){
            int width = nse[i]-pse[i]-1;
            int area = heights[i]*width;
            maxarea = Math.max(maxarea,area);
        }
        return maxarea;
    }
}
