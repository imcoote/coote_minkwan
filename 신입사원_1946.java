import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 신입사원_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(reader.readLine());
            int[][] applicants = new int[N][2];

            for (int i = 0; i < N; i++) {
                String[] input = reader.readLine().split(" ");
                applicants[i][0] = Integer.parseInt(input[0]); // 서류 성적
                applicants[i][1] = Integer.parseInt(input[1]); // 면접 성적
            }

            // 서류성적으로 정렬
            Arrays.sort(applicants, (a, b) -> Integer.compare(a[0], b[0]));

            int lowestInterviewer = Integer.MAX_VALUE;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                int interviewRank = applicants[i][1];
                if (interviewRank < lowestInterviewer) {
                    cnt++;
                    lowestInterviewer = interviewRank;
                }
            }

            output.append(cnt).append("\n");
        }

        System.out.print(output);
    }
}
