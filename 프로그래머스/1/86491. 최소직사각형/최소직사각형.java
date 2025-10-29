class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        for(int i=0; i<sizes.length; i++){
            int width = sizes[i][0];
            int height = sizes[i][1];
            int temp=0;
            if(width < height) { // 세로가 크면 가로 자리로 교체
                temp = height;
                height = width;
                width = temp;
            }
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }
        
        return maxWidth*maxHeight;
    }
}