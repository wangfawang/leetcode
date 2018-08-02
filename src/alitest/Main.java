package alitest;

import java.util.Scanner;

/**
 * ��ͼ��ĳ��������Աp����Ҫ��a��b��c��d4����ݵ����Ͱ�������������Ա��Ҫѡ��ʲô��·�ߣ�����������·�̵����͡�������ͼ����Ա���������(0,0)��
 * ����·��ֻ������ͼ�еķ������ʻ��ÿ��С���������Σ��ұ߳�Ϊ1����p��d�ľ������4���������n�����͵����꣬������������·��ֵ��
 * ����㿪ʼ���n�������Ͳ��ص���ʼ��ľ��룩��
 * 
 * @author hasee
 *
 */

class Point {
	int px;
	int py;
	boolean visited;

	public Point(int px, int py) {
		this.px = px;
		this.py = py;
		this.visited = false;
	}

	public int getLength(Point p) {
		return Math.abs(px - p.px) + Math.abs(py - p.py);
	}
}

public class Main {
	public static final Point START = new Point(0, 0);
	public static int minpath = Integer.MAX_VALUE;

	public static int calculate(Point start, Point[] points, int sum, int count) {
		if (count == points.length) {// �������ĵ����볤����ȣ������������ԭ��
			minpath = Math.min(minpath, sum + start.getLength(START));
			return minpath;
		}
		for (int i = 0; i < points.length; i++) {
			if (points[i].visited == false) {// �����δ�����ʣ�����ʲ����㳤��
				sum += points[i].getLength(start);
				if (sum < minpath) {// ���·����С����С·�����������һ��
					points[i].visited = true;
					calculate(points[i], points, sum, count + 1);
				}
				sum -= points[i].getLength(start);// ���·���ʹ�����С·��������ݵ���һ���㣨���ݷ����Ǹղŵķ��ʵ���false��������·����Ҳ����
				points[i].visited = false;
			}
		}
		return minpath;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = Integer.parseInt(scanner.nextLine().trim());
		Point[] points = new Point[num];
		for (int i = 0; i < num; i++) {
			String[] locations = scanner.nextLine().trim().split(",");
			points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
		}
		scanner.close();
		System.out.println(calculate(START, points, 0, 0));
	}

}
