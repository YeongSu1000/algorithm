import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());


        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= n; i++) {
            graph.get(i).sort(Collections.reverseOrder());
        }

        // DFS
        boolean[] visited = new boolean[n + 1];
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while(!stack.isEmpty()){
            int now = stack.pop();
            if(visited[now]){
                continue;
            }
            visited[now] = true;
            bw.write(now + " ");
            for(int next : graph.get(now)){
                if(!visited[next]){
                    stack.push(next);
                }
            }
        }

        bw.newLine();
        // BFS
        for (int i = 1; i <= n; i++) {
            graph.get(i).sort(Comparator.naturalOrder());
        }

        boolean[] visited2 = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while(!queue.isEmpty()){
            int now = queue.poll();
            if(visited2[now]){
                continue;
            }
            visited2[now] = true;
            bw.write(now + " ");
            for(int next : graph.get(now)){
                if(!visited2[next]){
                    queue.offer(next);
                }
            }
        }
        bw.flush();
        bw.close();

    } // end
}