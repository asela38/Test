package com.asela;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.time.StopWatch;

public class EfficientOffice {

     {
        try {
            System.setIn(new FileInputStream("efficient-office-input-0.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int         n    = -1, m = -1;
    private boolean[][] grid = null;

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        ThreadLocalRandom.current().ints()
            .limit(1000)
            .forEach(i -> {
                EfficientOffice obj = new EfficientOffice();
                stopWatch.start();
                obj.solve();
                stopWatch.stop();
                System.out.println(stopWatch.toString());
                stopWatch.reset();
            });
           
    }

    private void solve() {
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            grid = new boolean[n][m];

            // Load the grid
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    grid[i][j] = scanner.nextInt() == 0;
        }

        int max = 0;
        for (int i = 0; i < n - max; i++) {
            for (int j = 0; j < m - max; j++) {
                // Is good starting point
                if (!get(grid, i, j))
                    continue;
                int c = 0;
                while (hasABoarderAtDistance(grid, i, j, c))
                    c++;

                max = Math.max(c, max);
            }
        }

        System.out.println(max);
    }

    private boolean hasABoarderAtDistance(boolean[][] grid, int i, int j, int n) {
        // Has Edge on Right
        for (int x = 0; x < n; x++)
            if (!get(grid, i + x, j + n))
                return false;
        // Has Edge on Bottom
        for (int x = 0; x < n; x++)
            if (!get(grid, i + n, j + x))
                return false;
        // Has bottom right connecter exist
        return get(grid, i + n, j + n);

    }

    private boolean get(boolean[][] grid, int i, int j) {
        if (i >= n)
            return false;
        if (j >= m)
            return false;
        return grid[i][j];
    }
}
