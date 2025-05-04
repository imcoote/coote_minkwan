/*
- 문제 풀이 시간: 30분
- 시간복잡도: O(N)
- 메모리: 14312KB
- 실행시간: 104ms
- 풀이
    - 숫자가 바뀔 때마다 카운트를 해줌
    - 문자열의 첫번째 숫자부터 확인
    - 뒤집는 경우는 숫자가 바뀌는 순간 0 또는 1중 최솟값 카운트를 출력
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 뒤집기_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int cnt0 = 0;
        int cnt1 = 0;

        if (S.charAt(0) == '0') {
            cnt0++;
        }
        else {
            cnt1++;
        }

        for (int i=1; i<S.length(); i++){
            if (S.charAt(i) != S.charAt(i-1)){
                if (S.charAt(i) == '0') {
                    cnt0++;
                }
                else {
                    cnt1++;
                }
            }
        }
        System.out.println(Math.min(cnt0, cnt1));
    }
}