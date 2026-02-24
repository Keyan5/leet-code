class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int len = grid.length; // since n * n
        int rowMax[] = new int[len];
        int colMax[] = new int[len];
        int ans = 0;
        for(int r=0; r<len; r++)
        {
            for(int c=0; c<len; c++)
            {
                rowMax[r] = Math.max(rowMax[r], grid[r][c]);
                colMax[c] = Math.max(colMax[c], grid[r][c]);
            }
        }
        for(int r=0; r<len; r++)
            for(int c=0; c<len; c++)
                ans += Math.min(rowMax[r], colMax[c]) - grid[r][c];
        return ans;
    }
}