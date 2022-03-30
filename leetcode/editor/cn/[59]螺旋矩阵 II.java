/**
给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 

 

 示例 1： 

 
输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
 

 示例 2： 

 
输入：n = 1
输出：[[1]]
 

 

 提示： 

 
 1 <= n <= 20 
 
 Related Topics 数组 矩阵 模拟 👍 651 👎 0

*/

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int loop = n / 2;
        int mid = n / 2;
        int count = 1;

        int offset = 1;
        int startX = 0, startY = 0;

        while (loop > 0) {
            int i = startX;
            int j = startY;
            for (; j < startY + n - offset; j++) {
                result[i][j] = count++;
            }
            for (; i < startX + n - offset; i++) {
                result[i][j] = count++;
            }
            for (; j > startY; j--) {
                result[i][j] = count++;
            }
            for (; i > startX; i--) {
                result[i][j] = count++;
            }
            loop--;
            startX++;
            startY++;
            offset += 2;
        }

        if (n % 2 == 1) {
            result[mid][mid] = count;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
