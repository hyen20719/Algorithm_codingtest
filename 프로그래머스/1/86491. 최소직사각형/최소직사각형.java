class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        for(int[] size : sizes){
            // 더 큰 값은 가로에, 작은 값은 세로에
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);
            
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }
        
        return maxWidth*maxHeight;
    }
}