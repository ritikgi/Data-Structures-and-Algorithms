class Solution {
    private int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private int maxGold =0;
    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i =0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] > 0){
                    backTrack(grid, i,j,0);
                }
            }
        }
        return maxGold;
    }
    private void backTrack(int[][] grid, int row, int col, int currentGold){
        currentGold += grid[row][col];
        maxGold = Math.max(maxGold, currentGold);

        int originalGold = grid[row][col];
        grid[row][col] =0;

        for(int[] dir : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] > 0){
                backTrack(grid, newRow, newCol, currentGold);
            }
        }
        grid[row][col] = originalGold;
    }
}
