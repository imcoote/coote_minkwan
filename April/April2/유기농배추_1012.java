/*
- 문제 풀이 시간: 45분
- 시간복잡도:
    - O(width * height) -> 모든 배추 탐색
    - O(K) -> 배추의 갯수
    - O(width * height) + O(K)
- 메모리: 15944KB
- 실행시간: 140ms
- 풀이
    - 큐를 사용한 bfs 구현
    - 배추 위치를 확인하기위해 bfs를 사용하여 방문한 노드를 표시
    - 상하좌우 인접한 위치 계산
    - 연결된 그룹마다 배추흰지렁이 필요
*/

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
