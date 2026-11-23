import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] on = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            on[i] = Integer.parseInt(st.nextToken());
        }

        int studentNum = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < studentNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1) {
                for (int j = b; j < on.length; j += b) {
                    on[j] = (on[j] + 1) % 2;
                }
            }

            if (a == 2) {
                int l = b - 1, r = b + 1;
                on[b] = (on[b] + 1) % 2;
                for (; l > 0 && r < on.length; l--, r++) {
                    if(on[l] != on[r]){
                        break;
                    }
                    on[l] = (on[l] + 1) % 2;
                    on[r] = (on[r] + 1) % 2;
                }
            }
        }
        
        for (int i = 1; i < on.length; i++) {
            bw.write(on[i] + " ");
            if(i % 20 == 0){
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }
}