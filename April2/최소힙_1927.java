import java.io.*;
import java.util.*;

public class 최소힙_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =	Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++) {
            long x = Integer.parseInt(br.readLine());
            if(x>0) {
                pq.add(x);
            }else if(x==0) {
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
        }
    }
}
