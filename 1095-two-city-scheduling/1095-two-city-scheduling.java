class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a,b)->(a[0]-a[1]) - (b[0] - b[1]));
        int n = costs.length/2;
        int minCost = 0;

        for(int i =0; i < n; i++){
            minCost += costs[i][0];
            minCost += costs[i+n][1];
        }
        return minCost;
    }
}