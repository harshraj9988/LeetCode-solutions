import java.util.*;

/**
 * You are given a list of bombs. The range of a bomb is defined as the area
 * where its effect can be felt. This area is in the shape of a circle with the
 * center as the location of the bomb.
 * 
 * The bombs are represented by a 0-indexed 2D integer array bombs where
 * bombs[i] = [xi, yi, ri]. xi and yi denote the X-coordinate and Y-coordinate
 * of the location of the ith bomb, whereas ri denotes the radius of its range.
 * 
 * You may choose to detonate a single bomb. When a bomb is detonated, it will
 * detonate all bombs that lie in its range. These bombs will further detonate
 * the bombs that lie in their ranges.
 * 
 * Given the list of bombs, return the maximum number of bombs that can be
 * detonated if you are allowed to detonate only one bomb.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: bombs = [[2,1,3],[6,1,4]]
 * Output: 2
 * Explanation:
 * The above figure shows the positions and ranges of the 2 bombs.
 * If we detonate the left bomb, the right bomb will not be affected.
 * But if we detonate the right bomb, both bombs will be detonated.
 * So the maximum bombs that can be detonated is max(1, 2) = 2.
 * Example 2:
 * 
 * 
 * Input: bombs = [[1,1,5],[10,10,5]]
 * Output: 1
 * Explanation:
 * Detonating either bomb will not detonate the other bomb, so the maximum
 * number of bombs that can be detonated is 1.
 * Example 3:
 * 
 * 
 * Input: bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
 * Output: 5
 * Explanation:
 * The best bomb to detonate is bomb 0 because:
 * - Bomb 0 detonates bombs 1 and 2. The red circle denotes the range of bomb 0.
 * - Bomb 2 detonates bomb 3. The blue circle denotes the range of bomb 2.
 * - Bomb 3 detonates bomb 4. The green circle denotes the range of bomb 3.
 * Thus all 5 bombs are detonated.
 * 
 * 
 * Constraints:
 * 
 * 1 <= bombs.length <= 100
 * bombs[i].length == 3
 * 1 <= xi, yi, ri <= 105
 */
public class detonate_The_Maximum_Bombs {
    public int maximumDetonation(int[][] bombs) {
        int maxDetonatedBombs = 0;
        int totalBombs = bombs.length;
        Map<Integer, List<Integer>> withinRange = new HashMap<>();
        findBombsWithinTheRangeOfEachOther(bombs, withinRange);
        for (int currBomb = 0; currBomb < totalBombs; currBomb++) {
            maxDetonatedBombs = Math.max(maxDetonatedBombs, detonateBomb(withinRange, currBomb, totalBombs));
        }
        return maxDetonatedBombs;
    }

    private void findBombsWithinTheRangeOfEachOther(int[][] bombs, Map<Integer, List<Integer>> withinRange) {
        int n = bombs.length;
        for (int i = 0; i < n; i++) {
            long r = bombs[i][2];
            r *= r;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                long x = bombs[j][0] - bombs[i][0], y = bombs[j][1] - bombs[i][1];
                x *= x;
                y *= y;
                if (x + y > r)
                    continue;
                if (withinRange.containsKey(i)) {
                    withinRange.get(i).add(j);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(j);
                    withinRange.put(i, list);
                }
            }
        }
    }

    private int detonateBomb(Map<Integer, List<Integer>> withinRange, int currBomb, int totalBombs) {
        int bombsDetonated = 0;
        boolean[] detonated = new boolean[totalBombs];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currBomb);
        detonated[currBomb] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int bomb = queue.poll();
                bombsDetonated++;
                List<Integer> nextBombs = withinRange.get(bomb);
                if(nextBombs==null) continue;
                for (Integer nextBomb : nextBombs) {
                    if (detonated[nextBomb])
                        continue;
                    detonated[nextBomb] = true;
                    queue.add(nextBomb);
                }
            }
        }
        return bombsDetonated;
    }
}
