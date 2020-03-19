package DROP_BOX.Grid_Illumination;
/*
On a N x N grid of cells, each cell (x, y) with 0 <= x < N and 0 <= y < N has a lamp.

Initially, some number of lamps are on.  lamps[i] tells us the location of the i-th lamp that is on.  Each lamp that is on
illuminates every square on its x-axis, y-axis, and both diagonals (similar to a Queen in chess).

For the i-th query queries[i] = (x, y), the answer to the query is 1 if the cell (x, y) is illuminated, else 0.

After each query (x, y) [in the order given by queries], we turn off any lamps that are at cell (x, y) or are adjacent
8-directionally (ie., share a corner or edge with cell (x, y).)

Return an array of answers.  Each value answer[i] should be equal to the answer of the i-th query queries[i].



Example 1:

Input: N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
Output: [1,0]
Explanation:
Before performing the first query we have both lamps [0,0] and [4,4] on.
The grid representing which cells are lit looks like this, where [0,0] is the top left corner, and [4,4] is the bottom right corner:
1 1 1 1 1
1 1 0 0 1
1 0 1 0 1
1 0 0 1 1
1 1 1 1 1
Then the query at [1, 1] returns 1 because the cell is lit.  After this query, the lamp at [0, 0] turns off, and the grid now looks like this:
1 0 0 0 1
0 1 0 0 1
0 0 1 0 1
0 0 0 1 1
1 1 1 1 1
Before performing the second query we have only the lamp [4,4] on.  Now the query at [1,0] returns 0, because the cell is no longer lit.

 */

/*
Similar to 8 queen problem. Keystone is, light beam on each direction can be tagged by its slope. To speed up coordinate
lookup, I used long as hash key. This optimization makes the code 95% faster.

Runtime - O(Q + L) where Q is length of query array and L is length of lamp array
Space - O(L)
 */



import java.util.HashMap;
import java.util.Map;

public class Grid_Illumination {
    // Input
    // - a N * N graph G representing 2D locations
    // - a list L of locations representing lamps
    // - a list Q of locations representing queries. Each query has side effect.

    // Output
    // - an array of boolean representing whether the queried location is lighted

    // Constraints
    // - 1 <= N <= 1e9 - should represent G as adjacent list
    // - 0 <= L.len <= 2e4
    // - 0 <= Q.len <= 2e4

    // Concerns
    // Would L contains a location out side of G ? - igore this lamp
    // Would L contains duplicate locations ? - does not matter

    // Worse case runtime
    // - a complete scan over G takes O(N^2), which is 1e18 steps >> 1s, not acceptable
    // O(L^2) takes 1e8 steps, which is around 0.1s, acceptable
    // O(Q * L) ?
    // O(Q * logL) ?
    // O(Q + L) ?

    private int[][] dirs = new int[][]{
            {0, 0},
            {0, 1},
            {0, -1},
            {1, 0},
            {1, 1},
            {1, -1},
            {-1, 0},
            {-1, -1},
            {-1, 1}
    };

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> horizontal = new HashMap<>();
        Map<Integer, Integer> vertical = new HashMap<>();
        Map<Integer, Integer> positiveSlope = new HashMap<>();
        Map<Integer, Integer> negativeSlope = new HashMap<>();

        Map<Long, Boolean> lampsMap = new HashMap<>(); // <location hash key, whether lamp is turned on>
        for (int[] lamp : lamps) {
            Location loc = new Location(lamp[0], lamp[1]);
            lampsMap.put(loc.toHashkey(), true);
            horizontal.put(loc.y, 1 + horizontal.getOrDefault(loc.y, 0));
            vertical.put(loc.x, 1 + vertical.getOrDefault(loc.x, 0));
            positiveSlope.put(loc.x + loc.y, 1 + positiveSlope.getOrDefault(loc.x + loc.y, 0));
            negativeSlope.put(loc.x - loc.y, 1 + negativeSlope.getOrDefault(loc.x - loc.y, 0));
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Location loc = new Location(queries[i][0], queries[i][1]);
            //Get the result
            if (horizontal.getOrDefault(loc.y, 0) > 0
                    || vertical.getOrDefault(loc.x, 0) > 0
                    || positiveSlope.getOrDefault(loc.x + loc.y, 0) > 0
                    || negativeSlope.getOrDefault(loc.x - loc.y, 0) > 0) {
                ans[i] = 1;

                //Turn off the light
                for (int[] dir : dirs) {
                    Location next = new Location(loc.x + dir[0], loc.y + dir[1]);
                    if (next.x >= 0 && next.y >= 0 && next.x < N && next.y < N) {
                        long hashKey = next.toHashkey();
                        if (!lampsMap.getOrDefault(hashKey, false)) continue;

                        lampsMap.put(hashKey, false);
                        horizontal.put(next.y, horizontal.get(next.y) - 1);
                        vertical.put(next.x, vertical.get(next.x) - 1);
                        positiveSlope.put(next.x + next.y, positiveSlope.get(next.x + next.y) - 1);
                        negativeSlope.put(next.x - next.y, negativeSlope.get(next.x - next.y) - 1);
                    }
                }
            }
        }
        return ans;
    }

    private class Location {
        int x;
        int y;

        Location(int i, int j) {
            this.x = i;
            this.y = j;
        }

        long toHashkey() {
            long ans = this.x;
            return (ans << 30) | this.y;
        }
    }
}
