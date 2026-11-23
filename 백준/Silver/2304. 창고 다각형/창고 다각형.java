import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int maxHight = 0;
        int maxIndex = 0;
        int sum = 0;
        int start = 1001;
        int end = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[l] = h;
            if (maxHight < h) {
                maxHight = h;
                maxIndex = l;
            }
            if (start > l) {
                start = l;
            }
            if (end < l) {
                end = l;
            }
        }

        int lMax = 0, rMax = 0;
        for (int i = start; i < maxIndex; i++) {
            if (lMax < arr[i]) {
                lMax = arr[i];
            }
            arr[i] = lMax;
        }

        for (int i = end; i > maxIndex ; i--) {
            if (rMax < arr[i]) {
                rMax = arr[i];
            }
            arr[i] = rMax;
        }

        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }

        bw.write(sum + " ");

        bw.flush();
        bw.close();

    } // end
}