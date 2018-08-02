package alitest;

import java.util.Scanner;

/**
 * 如图，某物流派送员p，需要给a、b、c、d4个快递点派送包裹，请问派送员需要选择什么的路线，才能完成最短路程的派送。假设如图派送员的起点坐标(0,0)，
 * 派送路线只能沿着图中的方格边行驶，每个小格都是正方形，且边长为1，如p到d的距离就是4。随机输入n个派送点坐标，求输出最短派送路线值（
 * 从起点开始完成n个点派送并回到起始点的距离）。
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
		if (count == points.length) {// 如果计算的点数与长度相等，则结束并返回原点
			minpath = Math.min(minpath, sum + start.getLength(START));
			return minpath;
		}
		for (int i = 0; i < points.length; i++) {
			if (points[i].visited == false) {// 如果点未被访问，则访问并计算长度
				sum += points[i].getLength(start);
				if (sum < minpath) {// 如果路径和小于最小路径，则计算下一点
					points[i].visited = true;
					calculate(points[i], points, sum, count + 1);
				}
				sum -= points[i].getLength(start);// 如果路径和大于最小路径，则回溯到上一个点（回溯方法是刚才的访问点标记false），并且路径和也回溯
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
