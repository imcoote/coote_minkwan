import java.io.*;
import java.util.*;

public class 유기농배추_1012 {

    static int width;
    static int height;
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상하
    static int[] dy = {0, 0, -1, 1}; // 좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            field = new int[width][height];
            visited = new boolean[width][height];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = 1; // 배추가 심어진 위치
            }

            int cnt = 0;
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (field[x][y] == 1 && !visited[x][y]) {
                        bfs(x, y);
                        cnt++; // 새로운 배추흰지렁이가 필요함
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int d = 0; d < 4; d++) {
                int nextX = currentX + dx[d];
                int nextY = currentY + dy[d];

                if (nextX >= 0 && nextY >= 0 && nextX < width && nextY < height) {
                    if (field[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }
}
