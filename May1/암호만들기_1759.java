import java.io.*;
import java.util.*;

public class 암호만들기_1759 {

    static int L, C;
    static char[] letters;
    static char[] pwd;
    static StringBuilder sb = new StringBuilder();

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    static void createPwd(int index, int vowelCount, int consonantCount, int start) {
        if (index == L) { // 암호가 완성되면
            if (vowelCount >= 1 && consonantCount >= 2) { // 모음 1이상, 자음 2이상 확인하고
                for (char c : pwd) {
                    sb.append(c); // 결과에 추가
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            pwd[index] = letters[i]; // 정렬된 문자 배열안에서 처음부터 넣음
            if (isVowel(letters[i])) { // 모음이라면 모음 카운트 1 올리고 다음 문자열 확인해서 재귀
                createPwd(index + 1, vowelCount + 1, consonantCount, i + 1);
            } else { // 자음이라면 자음 카운트 1 올리고 다음 문자열 확인해서 재귀
                createPwd(index + 1, vowelCount, consonantCount + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        letters = new char[C];
        pwd = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            letters[i] = st.nextToken().charAt(0); // letters 배열이 char형이라서 charAt으로 추가해야 함
        }

        Arrays.sort(letters); // 알파벳순으로 정렬해주기

        createPwd(0, 0, 0, 0);

        System.out.println(sb);
    }
}