import java.util.*;

public class courseScheduleTopologicalSortDSAContest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // number of courses
        int M = sc.nextInt();  // number of prerequisite pairs

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            // B -> A  (B is prerequisite of A)
            graph[B].add(A);
            indegree[A]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            for (int neighbor : graph[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (order.size() != N) {
            System.out.println("Impossible");
        } else {
            System.out.println("Possible");
            for (int course : order) {
                System.out.print(course + " ");
            }
        }

        sc.close();
    }
}
