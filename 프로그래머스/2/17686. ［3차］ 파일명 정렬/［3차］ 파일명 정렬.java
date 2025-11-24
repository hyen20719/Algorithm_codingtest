import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        List<File> list = new ArrayList<>();

        // 파일명 처리
        for (int i = 0; i < files.length; i++) {
            String file = files[i];
            int st = 0;
            int end = 0;

            // 숫자 부분 찾기
            while (st < file.length() && !Character.isDigit(file.charAt(st))) {
                st++;
            }
            end = st;
            while (end < file.length() && Character.isDigit(file.charAt(end))) {
                end++;
            }

            // 파일의 HEAD, NUMBER, TAIL 분리
            String header = file.substring(0, st);
            String numStr = file.substring(st, end); // 숫자 부분 추출
            String tail = file.substring(end); // TAIL 부분

            // 숫자 부분은 원래의 문자열을 그대로 저장
            list.add(new File(header, numStr, tail, file, i)); // 원래 인덱스를 저장
        }

        // 정렬 기준 설정
        Collections.sort(list, (f1, f2) -> {
            // 1. 헤더 부분을 대소문자 구분 없이 사전순으로 비교
            int headCompare = f1.header.toLowerCase().compareTo(f2.header.toLowerCase());
            if (headCompare != 0) {
                return headCompare;
            }

            // 2. 숫자 부분은 숫자 순으로 비교 (숫자 앞의 0을 무시하기 위해 문자열로 비교)
            int numberCompare = Integer.compare(Integer.parseInt(f1.number), Integer.parseInt(f2.number)); // 숫자로 비교
            if (numberCompare != 0) {
                return numberCompare;
            }

            // 3. HEAD와 NUMBER가 같을 경우 원래 입력 순서를 유지
            return Integer.compare(f1.index, f2.index); // 원래 인덱스 순서대로 정렬
        });

        // 정렬된 파일명만 추출해서 반환
        int len = files.length;
        answer = new String[len];
        for (int i = 0; i < len; i++) {
            answer[i] = list.get(i).fileName;
        }

        return answer;
    }

    static class File {
        String header; // HEAD 부분
        String number; // NUMBER 부분 (숫자 앞의 0을 포함한 문자열로 저장)
        String tail; // TAIL 부분
        String fileName; // 전체 파일명
        int index; // 원래 입력 순서

        File(String header, String number, String tail, String fileName, int index) {
            this.header = header;
            this.number = number;
            this.tail = tail;
            this.fileName = fileName;
            this.index = index;
        }
    }
}
