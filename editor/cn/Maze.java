/**
 * Created by <a href="mailto:huangyebiaoke@outlook.com">huang</a> on 2020/10/27 15:58
 * 从迷宫的左上角走到右下角
 * 输入一个二维数组代表迷宫，1代表障碍物0代表可以行走
 * 输出一个字符串表示可行走的最短路径，用上下左右表示四个方向
 */
public class Maze {
    static int[][] map={
            {0,1,1,1,0},
            {0,0,1,1,1},
            {1,0,0,0,0},
            {1,0,0,1,0},
            {1,0,1,1,0}
    };
    public static void dfs(int x, int y){
        if (x<0||x>=map.length||y<0||y>=map.length){
            return;
        }
        if (map[x][y]!=0){
            return;
        }
        if(x==4&&y==4){
            map[x][y]=6;
            return;
        }
        map[x][y]=6;
        dfs(x+1,y);
        dfs(x-1,y);
        dfs(x,y+1);
        dfs(x,y-1);
    }

    public static void main(String[] args) {
        dfs(0,0);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
