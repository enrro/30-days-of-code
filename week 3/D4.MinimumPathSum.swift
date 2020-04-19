class Solution {
    func minPathSum(_ grid: [[Int]]) -> Int {
        guard grid != nil || grid.count > 0 else {return 0}
        var dp: [[Int]] = Array(repeating:Array(repeating:0, count:grid[0].count), count:grid.count)
        
        for i in 0..<grid.count{
            for j in 0..<grid[i].count{
                dp[i][j] += grid[i][j]
                if i > 0 && j > 0{
                    dp[i][j] += min(dp[i][j-1],dp[i-1][j])
                    
                }else if j > 0{
                    dp[i][j] += dp[i][j - 1]
                }else if i > 0{
                    dp[i][j] += dp[i - 1][j]
                }
            }
        }
        
        return dp[dp.count - 1][dp[0].count - 1]
    }
}