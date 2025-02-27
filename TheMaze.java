// APPROACH 1: BFS
// TC : O(mn)
// SC: O(mn)

class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        int dirs[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        Queue<Integer> q = new LinkedList<Integer>();
        if(start[0]==destination[0]&&start[1]==destination[1])
            return true;
        q.add(start[0]); q.add(start[1]);
        maze[(start[0])][(start[1])] = 2;
        while(!q.isEmpty()){
            int i = q.poll();
            int j = q.poll();
        for(int[] dir:dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            while(r>=0 && r<n && c>=0 && c<m && maze[r][c]!=1){
                r+=dir[0]; c+=dir[1];
            }
            r-=dir[0]; c-=dir[1];
            if(r==destination[0]&&c==destination[1])
                return true;
            if(maze[r][c]==0){
                maze[r][c]=2; q.add(r); q.add(c);
            }
        }
    }
    return false;
    }
}

// APPROACH 2: DFS
// TC : O(mn)
// SC : O(mn)

class Solution {
    int n,m;
    int dirs[][];
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        n = maze.length;
        m = maze[0].length;
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        if(start[0]==destination[0]&&start[1]==destination[1])
            return true;
        return helper(maze, start, destination);
    }
    private boolean helper(int[][] maze, int[] start, int[] destination){
        if(start[0]==destination[0]&&start[1]==destination[1])
            return true;
        if(maze[start[0]][start[1]]==2)
            return false;
        maze[(start[0])][(start[1])] = 2;
        for(int[] dir:dirs){
            int r = start[0]+dir[0];
            int c = start[1]+dir[1];
            while(r>=0 && r<n && c>=0 && c<m && maze[r][c]!=1){
                r+=dir[0]; c+=dir[1];
            }
            r-=dir[0]; c-=dir[1];
            if(helper(maze, new int[]{r,c},destination)) return true;
            }
            return false;
        }
    }