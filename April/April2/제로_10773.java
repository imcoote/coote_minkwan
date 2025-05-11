/*
- 문제 풀이 시간: 15분
- 시간복잡도:
    - O(N): K개에 대한 스택연산
- 메모리: 23892KB
- 실행시간: 208ms
- 풀이
    - 스택을 활용한 수 입력 관리
*/

import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 제로_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<K; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp==0){
                stack.pop();
            }
            else{
                stack.push(tmp);
            }
        }
        // 스택의 모든 수 합 구하기
        int sum = 0;
        for(int n : stack){
            sum += n;
        }
        System.out.print(sum);
    }
}