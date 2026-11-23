import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int n = sum - 100;

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if(arr[i] + arr[j] == n){
                    arr[i] = 100;
                    arr[j] = 100;
                    i = 8;
                    break;
                }
            }
        }

        Arrays.sort(arr);

        for (int i = 0; i < 7; i++) {
            bw.write(arr[i] + " ");
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }
}