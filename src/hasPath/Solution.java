package hasPath;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，
 * 向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的3 X
 * 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 * 
 * @author hasee
 *
 */

class Point {
	int x;
	int y;
	int index;

	Point(int x, int y, int index) {
		this.x = x;
		this.y = y;
		this.index = index;
	}
}


/**
 * 只实现了index恒定的迷宫寻路，如果index变化。该方法就不行了
 * @author hasee
 *
 */
public class Solution {
	// 用作上下左右的移动
	int xx[] = { 0, 0, 1, -1 };
	int yy[] = { -1, 1, 0, 0 };
	int index = 0;

	// 将数组规划为二维矩阵
	char[][] newMatrix = null;

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		HashSet<Point> hs = new HashSet<Point>();// 存起点位置
		LinkedList<Point> queue = new LinkedList<Point>();// 用于bfs的队列

		// 找起点
		int x = -1, y = -1;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i] == str[0]) {
				x = i / cols;
				y = i % cols;
				Point p = new Point(x, y, -1);
				hs.add(p);
			}
		}

		// 遍历hashset
		for (Point start : hs) {
			initMatrix(matrix, rows, cols);// 初始化矩阵数组
			newMatrix[start.x][start.y] = '#';
			start.index = 1;//下一个要找的str索引
			queue.offer(start);
			while (!queue.isEmpty()) {
				Point temp = queue.poll();
				index = temp.index;
				// 开始上下左右试探
				for (int i = 0; i < 4; i++) {
					int newX = temp.x + xx[i];
					int newY = temp.y + yy[i];

					// 如果越界，则不满足查找
					if (newX < 0 || newX >= rows || newY < 0 || newY >= cols)
						continue;
					// 如果不等于目标数，则不满足查找
					if (!(newMatrix[newX][newY] == str[index]) || newMatrix[newX][newY] == '#') {
						continue;
					}

					// 满足本次查找
					// 如果等于str长度，说明已经找到路径
					if (index == str.length)
						return true;
					newMatrix[newX][newY] = '#';// 用#代表已经走过的路
					Point nextPoint = new Point(newX, newY, index+1);
					queue.offer(nextPoint);
				}
			}

		}

		// 如果遍历起点，并且bfs后没有找到，则说明没有路径
		return false;

	}

	private void initMatrix(char[] matrix, int rows, int cols) {
		index = 0;
		newMatrix = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				newMatrix[i][j] = matrix[index++];
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new Solution().hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(), 5, 8,
				"SLHECCEIDEJFGGFIE".toCharArray()));
	}
}
