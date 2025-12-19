class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int minX = 0;
        int minY = 0;
        
        for(int[] size : sizes){
            if(size[0]<size[1]){
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
            minX = Math.max(minX, size[0]);
            minY = Math.max(minY, size[1]);
        }

        return minX*minY;
    }
}