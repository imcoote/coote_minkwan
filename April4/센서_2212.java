import java.io.*;
import java.util.*;

public class 센서_2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int [] sensor = new int [N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor); // 센서의 거리가 짧은 위치 순으로 오름차순 정렬

        int [] dist = new int [N-1]; // 센서 사이의 거리
        for (int i=0; i<N-1; i++){
            dist[i] = sensor[i+1] - sensor[i];
        }
        Integer [] distDesc = new Integer [N-1];
        for (int i=0; i<N-1; i++){
            distDesc[i] = dist[i];
        }
        Arrays.sort(distDesc, Collections.reverseOrder()); // dist 배열을 바로 내림차순 쓰니깐 안됨 -> Integer로 변환

        int sum = 0;
        int cut = Math.min(K-1, N-1); // 집중국이 K개면 그룹이 K개니깐 끊는 구간은 K-1개
        for (int i=cut; i<N-1; i++) {
            sum += distDesc[i];
        }
        System.out.print(sum);
    }
}
