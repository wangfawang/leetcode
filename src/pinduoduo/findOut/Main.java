package pinduoduo.findOut;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * ����һ��̽�ռұ������˵ص׵��Թ�֮�У�Ҫ�ӵ�ǰλ�ÿ�ʼ�ҵ�һ��ͨ���Թ����ڵ�·�����Թ�������һ����ά������ɣ��еĲ�����ǽ���еĲ�����·��
 * �Թ�֮���е�·�ϻ����ţ�ÿ���Ŷ����Թ���ĳ���ط�����֮ƥ���Կ�ף�ֻ�����õ�Կ�ײ��ܴ��š������һ���㷨������̽�ռ��ҵ����������·������ǰ������
 * �Թ���ͨ��һ����ά�����ʾ�ģ�ÿ��Ԫ�ص�ֵ�ĺ�������
 * 0-ǽ��1-·��2-̽�ռҵ���ʼλ�ã�3-�Թ��ĳ��ڣ���д��ĸ-�ţ�Сд��ĸ-��Ӧ��д��ĸ��������ŵ�Կ�� ��������:
 * �Թ��ĵ�ͼ���ö�ά�����ʾ����һ���Ǳ�ʾ���������������M��N �����M���Ǿ�������ݣ�ÿһ�ж�Ӧ������һ�У��м�û�пո񣩡�M��N��������100,
 * �Ų�����10�ȡ�
 * 
 * �������: ·���ĳ��ȣ���һ������
 * 
 * ��������1: 5 5 02111 01a0A 01003 01001 01111
 * 
 * �������1: 7
 * 
 * 
 * ��Ŀ˼·��
 * �����������֮ǰû���˽⵽BFS�����ԸϿ�ߣ��һ�¿α�����������̾��룬����ŵ�����������10��������ֱ��һ������BFS����������Ҫ��¼����Կ�׵�״̬��
 * ����ʹ��״̬ѹ���ö���������ʾ����Կ��״̬��
 * ��BFS֮ǰ�ȸ�����ʼ״̬���ã�����������һ��Կ�׵ĸ�����������Ϊ������ߵĹ����м�¼Կ����Ϣ�������������һ��״̬ѹ������
 * ��һ������������û��ĳһ��Կ��,��������Ķ����Ʊ�ʾʱ��iλΪ1�����е�a+i��Կ��,����û��,�൱���Թ�ÿһ������1024��״̬��
 * 
 * 
 * ���������ͨ��bfs���ˡ�Կ�ס����״̬, ����keys[x][y][key]��������� ������Ϊx,������Ϊy,Կ��״̬Ϊkey�ĵ��Ƿ���ʹ�,
 * Կ�׵�״̬ ���ö���������ʾ ���10 ��Կ�� �Ǿ���1024, �����������еڶ���Կ�׺͵��İ�Կ�� ��ô�ҵ�Կ��״̬���� 0101000000 Ҳ����
 * 320
 * 
 * @author hasee
 *
 */
public class Main {
	// �ĸ�����
	private static int[] xx = new int[] { 0, 0, 1, -1 };
	private static int[] yy = new int[] { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			scanner.nextLine();

			char[][] datas = new char[m][n];
			for (int i = 0; i < m; i++) {
				datas[i] = scanner.nextLine().toCharArray();
			}

			int x0 = 0, y0 = 0;// ���λ��
			int xd = 0, yd = 0;// ����λ��

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m; j++) {
					if (datas[i][j] == '2') {
						x0 = i;
						y0 = j;
						continue;
					}

					if (datas[i][j] == '3') {
						xd = i;
						yd = j;
						break;
					}
				}
			}

			System.out.println(bfs(datas, m, n, x0, y0, xd, yd));
		}

	}

	private static int bfs(char[][] datas, int m, int n, int x0, int y0, int xd, int yd) {
		LinkedList<Node> queue = new LinkedList<>();

		int[][][] keys = new int[m][n][1024];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int s = 0; s < 1024; s++) {
					keys[i][j][s] = Integer.MAX_VALUE;
				}
			}
		}

		queue.add(new Node(x0, y0, 0));
		keys[x0][y0][0] = 0;

		Node node = null;
		int x = 0;
		int y = 0;
		int key = 0;

		while (queue.size() > 0) {// �����в�Ϊ��
			node = queue.poll();
			x = node.x;
			y = node.y;
			key = node.key;

			if (x == xd && y == yd)
				return keys[x][y][key];

			for (int i = 0; i < 4; i++) {
				// ���������ƶ�
				x = node.x + xx[i];
				y = node.y + yy[i];
				key = node.key;
				//�ڷ�Χ�ڣ����Ҳ���ǽ���ͼ��������ߣ�����������
				if (!isValid(x, y, m, n, datas))
					continue;
				// ���10��Կ��
				if (datas[x][y] >= 'a' && datas[x][y] <= 'j') {//�������������˵����Կ�״��ڡ�a~j����Կ��
					key = key | (0x1 << (datas[x][y] - 'a'));
				}
				// �ж�Ӧ��Կ�׼��������ߣ�û��������
				if (datas[x][y] >= 'A' && datas[x][y] <= 'J') {// door
					if ((key & (0x1 << (datas[x][y] - 'A'))) > 0) {// haskey
						// key = key | ~(0x1 << (datas[x][y] - 'A'));
					} else {
						continue;
					}
				}
				// keys[x][y][key] Կ����
				if (keys[x][y][key] > keys[node.x][node.y][node.key] + 1) {
					keys[x][y][key] = keys[node.x][node.y][node.key] + 1;
					queue.add(new Node(x, y, key));
				}

			}
		}

		return Integer.MAX_VALUE;
	}

	private static boolean isValid(int x, int y, int m, int n, char[][] data) {
		if (x >= 0 && x < m && y >= 0 && y < n && data[x][y] != '0')
			return true;
		return false;
	}

	private static class Node {
		int x;
		int y;
		int key;

		public Node(int x, int y, int keys) {
			this.x = x;
			this.y = y;
			this.key = keys;
		}
	}

}
