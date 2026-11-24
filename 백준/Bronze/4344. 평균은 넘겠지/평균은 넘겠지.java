import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            int n = Integer.parseInt(st.nextToken());
            int[] score = new int[n];
            for (int j = 0; j < n; j++) {
                score[j] = Integer.parseInt(st.nextToken());
                sum += score[j];
            }
            double avr = (double) sum / n;
            int goodScore = 0;
            for (int j = 0; j < n; j++) {
                if(score[j] > avr){
                    goodScore++;
                }
            }

            double rate = (double)goodScore / n * 100;

            bw.write(String.format("%.3f", rate) + "%");
            bw.newLine();
        }

        bw.flush();
        bw.close();

    } // end
}