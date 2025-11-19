class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();

        for(int i=1; i<=(len/2)+1; i++){
            int result = dfs(s, i, 1).length();
            answer = i==1 ? result : (answer>result?result:answer);
        }

        return answer;
    }

    public String dfs(String s, int n, int repeat){
        if(s.length() < n) return s;
        String result = "";
        String pre = s.substring(0, n);
        String post = s.substring(n, s.length());

        // 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
        if(!post.startsWith(pre)){
            if(repeat ==1) return result += pre + dfs(post, n, 1);
            return result += Integer.toString(repeat) + pre + dfs(post, n, 1);
        }

        return result += dfs(post, n, repeat+1);
    }
}