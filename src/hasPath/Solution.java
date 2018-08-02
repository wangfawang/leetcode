package hasPath;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ�
 * �����ƶ�һ�����ӡ����һ��·�������˾����е�ĳһ�����ӣ���֮�����ٴν���������ӡ� ���� a b c e s f c s a d e e ������3 X
 * 4 �����а���һ���ַ���"bcced"��·�������Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��
 * ·�������ٴν���ø��ӡ�
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
 * ֻʵ����index�㶨���Թ�Ѱ·�����index�仯���÷����Ͳ�����
 * @author hasee
 *
 */
public class Solution {
	// �����������ҵ��ƶ�
	int xx[] = { 0, 0, 1, -1 };
	int yy[] = { -1, 1, 0, 0 };
	int index = 0;

	// ������滮Ϊ��ά����
	char[][] newMatrix = null;

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		HashSet<Point> hs = new HashSet<Point>();// �����λ��
		LinkedList<Point> queue = new LinkedList<Point>();// ����bfs�Ķ���

		// �����
		int x = -1, y = -1;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i] == str[0]) {
				x = i / cols;
				y = i % cols;
				Point p = new Point(x, y, -1);
				hs.add(p);
			}
		}

		// ����hashset
		for (Point start : hs) {
			initMatrix(matrix, rows, cols);// ��ʼ����������
			newMatrix[start.x][start.y] = '#';
			start.index = 1;//��һ��Ҫ�ҵ�str����
			queue.offer(start);
			while (!queue.isEmpty()) {
				Point temp = queue.poll();
				index = temp.index;
				// ��ʼ����������̽
				for (int i = 0; i < 4; i++) {
					int newX = temp.x + xx[i];
					int newY = temp.y + yy[i];

					// ���Խ�磬���������
					if (newX < 0 || newX >= rows || newY < 0 || newY >= cols)
						continue;
					// ���������Ŀ���������������
					if (!(newMatrix[newX][newY] == str[index]) || newMatrix[newX][newY] == '#') {
						continue;
					}

					// ���㱾�β���
					// �������str���ȣ�˵���Ѿ��ҵ�·��
					if (index == str.length)
						return true;
					newMatrix[newX][newY] = '#';// ��#�����Ѿ��߹���·
					Point nextPoint = new Point(newX, newY, index+1);
					queue.offer(nextPoint);
				}
			}

		}

		// ���������㣬����bfs��û���ҵ�����˵��û��·��
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
