class min_Cost_Climbing_Stairs{

    public int solve(int i, int[] cost){
        if(i>=cost.length) return 0;

        int one = solve(i+1, cost);
        int two = solve(i+2, cost);

        return cost[i] + Math.min(one, two);

    }

    public int minCostClimbingStairs(int[] cost) {
        return solve(0, cost);
    }
}