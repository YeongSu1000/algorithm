import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        while (a != -1 || b != -1 || c != -1) {
            bw.write(String.format("w(%d, %d, %d) = ",a,b,c) + w(a, b, c) + "\n");

            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
        bw.flush();
        bw.close();
    }

    static int[][][] dp = new int[21][21][21];

    static int w(int a, int b, int c) {
        if (a < 1 || b < 1 || c < 1) {
            return 1;
        } else if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        } else if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        } else if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
    }
}