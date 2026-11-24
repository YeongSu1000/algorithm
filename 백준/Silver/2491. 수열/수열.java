import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] size = new int[n];
        int[] size2 = new int[n];
        size[0] = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int length = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i] >= arr[i - 1]){
                length++;
                size[i] = length;
            }else{
                length = 1;
            }
        }

        length = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i] <= arr[i - 1]){
                length++;
                size2[i] = length;
            }else{
                length = 1;
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            if(size[i] > max){
                max = size[i];
            }
            if(size2[i] > max){
                max = size2[i];
            }
        }
        bw.write(max + "");

        bw.flush();
        bw.close();

    }
}