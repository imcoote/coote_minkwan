/*
- 문제 풀이 시간: 40분
- 시간복잡도:
    - O(N * M)
- 메모리: 14604KB
- 실행시간: 120ms
- 풀이
    - 아기상어가 있는 곳은 안전거리를 0으로 두고, 아닌 곳은 아직 탐색하지 않은 곳으로 -1로 설정
    - 특정 위치에서 가장 가까운 아기상어가 있는 곳의 거리가 안전거리
*/

import java.io.*;
import java.util.*;

public class 아기상어2_17086 {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int N, M;
    static int[][] grid;
    static int[][] distance;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        distance = new int[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    distance[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    distance[i][j] = -1;
                }
            }
        }

        bfs();

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res = Math.max(res, distance[i][j]);
            }
        }

        System.out.println(res);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] currentLocation = queue.poll();
            int currentRow = currentLocation[0];
            int currentCol = currentLocation[1];

            for (int i = 0; i < 8; i++) {
                int nextRow = currentRow + dx[i];
                int nextCol = currentCol + dy[i];

                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
                    if (distance[nextRow][nextCol] == -1) {
                        distance[nextRow][nextCol] = distance[currentRow][currentCol] + 1;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }
    }
}
