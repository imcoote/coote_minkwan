import java.io.*;
import java.util.*;

public class 나이트의이동_7562 {
    static int length;
    static int x1, y1, x2, y2;
    static boolean[][] visited;
    // 나이트 8방향
    static int[] dx = {2, 2, -2, -2, 1, 1, -1, -1};
    static int[] dy = {1, -1, 1, -1, 2, -2, 2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            length = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            sb.append(bfs()).append("\n");
        }
        System.out.print(sb);
    }

    static int bfs() {
        visited = new boolean[length][length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x1, y1, 0}); // 현재위치와 이동거리
        visited[x1][y1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (x == x2 && y == y2) {
                return dist;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < length && ny < length && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return 0;
    }
}
