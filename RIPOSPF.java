====================================================RIP===========================================================

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] g = {
            {0, 2, 5, 0, 0},
            {2, 0, 1, 4, 0},
            {5, 1, 0, 2, 0},
            {0, 4, 2, 0, 3},
            {0, 0, 0, 3, 0}
        };

        System.out.print("Enter source (A-E): ");
        int s = sc.next().toUpperCase().charAt(0) - 'A';
        System.out.print("Enter destination (A-E): ");
        int d = sc.next().toUpperCase().charAt(0) - 'A';

        for (int k = 0; k < 2; k++) {
            int[] dist = new int[5], par = new int[5];
            boolean[] vis = new boolean[5];
            Arrays.fill(dist, 999);
            Arrays.fill(par, -1);
            dist[s] = 0;

            for (int i = 0; i < 5; i++) {
                int u = -1;
                for (int j = 0; j < 5; j++)
                    if (!vis[j] && (u == -1 || dist[j] < dist[u])) u = j;

                if (u == -1 || dist[u] == 999) break;
                vis[u] = true;

                for (int v = 0; v < 5; v++)
                    if (g[u][v] > 0 && dist[u] + g[u][v] < dist[v]) {
                        dist[v] = dist[u] + g[u][v];
                        par[v] = u;
                    }
            }

            System.out.println(k == 0 ? "\n--- RIP ---" : "\n--- OSPF ---");
            List<Integer> path = new ArrayList<>();
            for (int x = d; x != -1; x = par[x]) path.add(x);
            Collections.reverse(path);

            System.out.print("Path: ");
            for (int x : path) System.out.print((char)('A' + x) + " ");
            System.out.println("\nCost: " + dist[d]);
        }
        sc.close();
    }
}




====================================================OSPF===========================================================
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] g = {
            {0, 2, 5, 0, 0},
            {2, 0, 1, 4, 0},
            {5, 1, 0, 2, 0},
            {0, 4, 2, 0, 3},
            {0, 0, 0, 3, 0}
        };

        System.out.print("Enter source (A-E): ");
        int s = sc.next().toUpperCase().charAt(0) - 'A';
        System.out.print("Enter destination (A-E): ");
        int d = sc.next().toUpperCase().charAt(0) - 'A';

        int[] dist = new int[5], par = new int[5];
        boolean[] vis = new boolean[5];

        Arrays.fill(dist, 999);
        Arrays.fill(par, -1);
        dist[s] = 0;

        for (int i = 0; i < 5; i++) {
            int u = -1;

            for (int j = 0; j < 5; j++)
                if (!vis[j] && (u == -1 || dist[j] < dist[u]))
                    u = j;

            if (u == -1 || dist[u] == 999) break;
            vis[u] = true;

            for (int v = 0; v < 5; v++)
                if (g[u][v] > 0 && dist[u] + g[u][v] < dist[v]) {
                    dist[v] = dist[u] + g[u][v];
                    par[v] = u;
                }
        }

        List<Integer> path = new ArrayList<>();
        for (int x = d; x != -1; x = par[x])
            path.add(x);

        Collections.reverse(path);

        System.out.println("\n--- OSPF (Dijkstra) ---");
        System.out.print("Shortest Path: ");

        for (int x : path)
            System.out.print((char) ('A' + x) + " ");

        System.out.println("\nCost: " + dist[d]);
        sc.close();
    }
}
