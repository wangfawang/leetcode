package sort;

/**
 * �򵥲�������ĸĽ��档�����������Ĳ�֮ͬ�����ڣ��������ȱȽϾ����Զ��Ԫ�ء�ϣ�������ֽ���С�������� �㷨����
 * 
 * �Ƚ�����������ļ�¼���зָ��Ϊ���������зֱ����ֱ�Ӳ������򣬾����㷨������
 * 
 * ѡ��һ����������t1��t2������tk������ti>tj��tk=1�� ���������и���k�������н���k ������
 * ÿ�����򣬸��ݶ�Ӧ������ti�����������зָ�����ɳ���Ϊm �������У��ֱ�Ը��ӱ����ֱ�Ӳ������򡣽���������Ϊ1
 * ʱ������������Ϊһ�������������ȼ�Ϊ�������еĳ��ȡ�
 * 
 * @author hasee
 *
 */
public class Shell {
	public int[] shellSort(int[] arr) {
		int len = arr.length;
		int temp;
		int gap = 1;
		int preIndex;
		while (gap < len / 3) {// ��̬����������,����һ���㷨
			gap = gap * 3 + 1;
		}
		while (gap >= 1) {// ĳ��������ѭ��,i����gap
			for (int i = gap; i < len; i++) {// j������Զ�˵�ֵ
				preIndex = i - gap;
				temp = arr[i];
				while (preIndex >= 0 && arr[preIndex] > temp) {
					arr[preIndex + gap] = arr[preIndex];
					preIndex = preIndex - gap;
				}
				arr[preIndex + gap] = temp;
			}
			ArrayUtil.printArray(arr);
			gap = (gap - 1) / 3;
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 4,3,6,5 };
		ArrayUtil.printArray(arr);
		int[] res = new Shell().shellSort(arr);
		ArrayUtil.printArray(res);
	}
}
