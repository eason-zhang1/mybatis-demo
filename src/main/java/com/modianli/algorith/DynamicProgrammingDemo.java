package com.modianli.algorith;

public class DynamicProgrammingDemo {

  public static void main(String[] args) {
	System.out.println(uniquePaths(4, 2));
	System.out.println(uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
  }

  /**
   * n和m均不超过100
   *
   * 有一个机器人的位于一个 m × n 个网格左上角。
   * 机器人每一时刻只能向下或者向右移动一步。机器人试图达到网格的右下角。
   * 问有多少条不同的路径？
   */
  private static int uniquePaths(int m, int n) {
	int[][] dp = new int[n][m];
	dp[0][0] = 1;
	for (int i = 0; i < m; i++) {
	  dp[0][i] = 1;
	}
	for (int j = 0; j < n; j++) {
	  dp[j][0] = 1;
	}
	for (int i = 1; i < n; i++) {
	  for (int j = 1; j < m; j++) {
		dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
	  }
	}

	return dp[n - 1][m - 1];
  }

  /**
   * "不同的路径" 的跟进问题：
   *
   * 现在考虑网格中有障碍物，那样将会有多少条不同的路径？
   * 网格中的障碍和空位置分别用 1 和 0 来表示。
   * 样例
   * 如下所示在3x3的网格中有一个障碍物：
   * [
   * [0,0,0],
   * [0,1,0],
   * [0,0,0]
   * ]
   * 一共有2条不同的路径从左上角到右下角。
   */
  private static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int n = obstacleGrid.length, m = obstacleGrid[0].length;

	int[][] dp = new int[n][m];
	dp[0][0] = 1;
	for (int i = 0; i < m; i++) {
	  if(obstacleGrid[0][i] == 0){
		dp[0][i] = 1;
	  }else{
	    break;
	  }

	}
	for (int j = 0; j < n; j++) {
	  if(obstacleGrid[j][0] == 0){
		dp[j][0] = 1;
	  }else{
		break;
	  }
	}
	for (int i = 1; i < n; i++) {
	  for (int j = 1; j < m; j++) {
	    if(obstacleGrid[i][j] == 0){
		  dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
		}else{
	      dp[i][j] = 0;
		}
	  }
	}

	return dp[n - 1][m - 1];
  }
}
