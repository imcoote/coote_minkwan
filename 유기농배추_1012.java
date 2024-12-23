import java.util.Scanner;
import java.util.Stack;

public class 유기농배추_1012 {
    static int[][] farm;
    static boolean[][] visited;
    static int M, N;

    // DFS
    public static void dfs(int startX, int startY) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});
        visited[startX][startY] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && farm[nx][ny] == 1) {
                    stack.push(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            M = scanner.nextInt();
            N = scanner.nextInt();
            int K = scanner.nextInt();

            farm = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                farm[y][x] = 1;
            }

            int wormCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (farm[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        wormCount++;
                    }
                }
            }

            System.out.println(wormCount);

        }
        scanner.close();
    }
}
