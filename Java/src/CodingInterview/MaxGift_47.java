package CodingInterview;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2020/06/09
 *     标题   : 礼物的最大价值
 *     题目   : 在一个m x n的棋盘的每一个都放有一个礼物，每个礼物都有一定的价值（大于0），你可以从棋盘的左上角开始拿格子里的礼物，
 *              并每次向左或向下移动一格，直到达到棋盘的右下角。给定一个棋盘集器上面的礼物，请计算你最多能达到多少价值的礼物？
 *     思路   : 动态规划
 * </pre>
 */
class MaxGift_47 {

    public static void main(String[] args) {

        int[][] gifts = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};

        System.out.println(maxGifts(gifts));

    }


    public static int maxGifts(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] gifts = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (i == 0 && j == 0) {
                    gifts[i][j] = grid[i][j];
                }

                if (i == 0 && j > 0) {
                    gifts[i][j] = gifts[i][j - 1] + grid[i][j];
                }
                if (j == 0 && i > 0) {
                    gifts[i][j] = gifts[i - 1][j] + grid[i][j];
                }

                if (i > 0 && j > 0) {
                    gifts[i][j] = Math.max(gifts[i - 1][j], gifts[i][j - 1]) + grid[i][j];
                }
            }
        }

        return gifts[rows - 1][cols - 1];
    }
}
