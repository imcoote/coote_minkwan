// 문제 풀이 시간: 5시간
// 시간복잡도: O(n*m+klogk)
// n*m은 행렬, k는 hashmap의 key의 수, log k는 정렬
// 메모리 사용량: 25916KB
// 행과 열 연산 모두 같은 방식이므로 열 계산때 전치하여 행계산 처럼 사용
// 각 요소의 카운트는 key, value를 사용하는 hashmap 사용
// hashmap을 정렬할 새로운 리스트

import java.util.*;

public class 이차원배열과연산_17140 {

    static int[][] transpose(int[][] A){
        int rows = A.length;
        int cols = A[0].length;
        int [][] transposed = new int[cols][rows];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                transposed[j][i] = A[i][j];
            }
        }
        return transposed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] fl = sc.nextLine().split(" ");
        int r = Integer.parseInt(fl[0]) - 1;
        int c = Integer.parseInt(fl[1]) - 1;
        int k = Integer.parseInt(fl[2]);

        int [][] A = new int [3][3];
        for(int i=0; i<3; i++){
            String[] l = sc.nextLine().split(" ");
            for(int j=0; j<3; j++){
                A[i][j] = Integer.parseInt(l[j]);
            }
        }

        for (int t = 0; t<=100; t++){
            if (0 <= r && r < A.length && 0 <= c && c < A[0].length && A[r][c] == k) {
                System.out.println(t);
                return;
            }

            boolean cal_R = true;
            if (A.length < A[0].length){
                cal_R = false;
                A = transpose(A);
            }

            int maxCol = 0;
            for (int i=0; i<A.length; i++){
                Map<Integer, Integer> counts = new HashMap<>();
                for(int j=0; j<A[i].length; j++){
                    if (A[i][j]==0){
                        continue;
                    }
                    counts.put(A[i][j], counts.getOrDefault(A[i][j], 0) + 1);
                }

                List<Map.Entry<Integer, Integer>> countList = new ArrayList<>(counts.entrySet());
                countList.sort((a, b) -> {
                    if(!a.getValue().equals(b.getValue())) {
                        return a.getValue().compareTo(b.getValue());
                    }
                    return a.getKey().compareTo(b.getKey());
                });

                List<Integer> newList = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : countList){
                    newList.add(entry.getKey());
                    newList.add(entry.getValue());
                }


                int[] tmpArr = new int[newList.size()];
                for (int j = 0; j < newList.size(); j++) {
                    tmpArr[j] = newList.get(j);
                }
                A[i] = tmpArr;
                if (A[i].length > maxCol) {
                    maxCol = A[i].length;
                }

            }

            for(int i=0; i<A.length; i++){
                if (A[i].length > 100){
                    A[i] = Arrays.copyOf(A[i], 100);
                }
                while (A[i].length < maxCol){
                    A[i] = Arrays.copyOf(A[i], A[i].length + 1);
                    A[i][A[i].length - 1] = 0;
                }
            }

            if (cal_R==false){
                A = transpose(A);
            }

        }

        System.out.println(-1);

    }
}
