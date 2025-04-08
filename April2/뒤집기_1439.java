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
        // test
        // test2
        // test3
        // test4
        // testLast
        System.out.println(Math.min(cnt0, cnt1));
    }
}