package migongwenti;

import java.util.LinkedList;
public class Main {
	public static void main(String[] args) {
		 int[][] array={
		            {0,0,1,0},
		            {1,0,1,0},
		            {0,0,1,0},
		            {0,0,0,0}
		           };
		 new Main().findMinRold(array);
	}
	//����ͼ�Ľڵ���Ϣ
	class Node{
		//��������;����һ���ڵ�ľ���
		int x;
		int y;
		int dis;
		//����ڵ��ǰ׺�����ڻ����������·����  ��·ͼ
		Node pre;
		public Node(int x , int y , int dis , Node pre) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.pre = pre;
		}
	}
	
	public void findMinRold(int[][] arr) {
		//����  ���������ĸ�����
		int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
		//��������
		LinkedList<Node> queue = new LinkedList<Node>();
		//������ʼ�ڵ�
		Node start = new Node(0,0,0,null);
		//�ѿ�ʼ�ڵ��������У������±�ǣ���ԭ�������������
		queue.offer(start);
		arr[0][0] = 1;
		
		//ѭ���������У����й�ȱ���
		Node temp = null;
		ok:
		while(!queue.isEmpty()) {
			temp = queue.poll();
			//���α�������ڵ���ĸ����򣬲��һ�û�б����������ڵ�
			for(int i = 0 ; i < 4 ; i++) {
				int newX = temp.x + direction[i][0];
				int newY = temp.y + direction[i][1];
				//�Ƿ�Խ�磬����
				if(newX < 0 || newX >= 4 || newY < 0 || newY >= 4) {
					continue;
				}
				//�ж��Ƿ�ýڵ����ͨ������Ϊ0
				if(arr[newX][newY] == 1) {
					continue;
				}
				//����ڵ�
				Node next = new Node(newX , newY , temp.dis+1 , temp);
				//�ýڵ����ͨ�����жϸýڵ��Ƿ������սڵ�
				if(newX == 3 && newY == 3) {
					queue.clear();
					//�൱��ͷ�巨��ת��
					queue.offerFirst(next);
					Node preNode = next.pre;
					while(preNode != null) {
						queue.offerFirst(preNode);
						preNode = preNode.pre;
					}
					int len = queue.size();
					System.out.println("���·������Ϊ��"+(len-1));
					for(Node it:queue) {
						System.out.println("("+it.x+","+it.y+") ");
					}
					break ok;
				}
				arr[newX][newY] = 1;
				queue.offer(next);
			}//for
			
		}//while
		
	}
 
}
