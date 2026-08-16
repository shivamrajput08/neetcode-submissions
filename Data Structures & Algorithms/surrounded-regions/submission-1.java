class Solution {
    private void dfs(char[][] grid , int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 'O' ){
            return;
        }
        grid[i][j] = '#';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i < n ; i++){
           if(grid[i][0] == 'O'){
            dfs(grid,i,0);
           }
           if(grid[i][m-1] == 'O'){
            dfs(grid,i,m-1);
           }
        }
        for(int j = 0 ; j < m ; j++){
            if(grid[0][j] == 'O'){
                dfs(grid,0,j);
            }
            if(grid[n-1][j] == 'O'){
                dfs(grid,n-1,j);
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 'O'){
                    grid[i][j] = 'X';
                }else if(grid[i][j] == '#'){
                    grid[i][j] = 'O';
                }
            }
        }
    }
}
