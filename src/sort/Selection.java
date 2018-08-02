package sort;

/**
 * ѡ������(Selection-sort)��һ�ּ�ֱ�۵������㷨�����Ĺ���ԭ��������δ�����������ҵ���С����Ԫ�أ���ŵ��������е���ʼλ�ã�Ȼ��
 * �ٴ�ʣ��δ����Ԫ���м���Ѱ����С����Ԫ�أ�Ȼ��ŵ����������е�ĩβ���Դ����ƣ�ֱ������Ԫ�ؾ�������ϡ�
 * 
 * 
 * �㷨���� n����¼��ֱ��ѡ������ɾ���n-1��ֱ��ѡ������õ��������������㷨�������£� ��ʼ״̬��������ΪR[1..n]��������Ϊ�գ�
 * ��i������(i=1,2,3��n-1)��ʼʱ����ǰ���������������ֱ�ΪR[1..i-1]��R(i..n������������ӵ�ǰ��������-ѡ���ؼ�����С�ļ�¼
 * R[k]���������������ĵ�1����¼R������ʹR[1..i]��R[i+1..n)�ֱ��Ϊ��¼��������1�������������ͼ�¼��������1��������������
 * n-1�˽��������������ˡ�
 * 
 * @author hasee
 *
 */
public class Selection {
	public int[] selectionSort(int[] arr) {
		int len = arr.length;
		int minIndex, temp;
		for (int i = 0; i < len - 1; i++) {
			minIndex = i;// ��С���±�
			for (int j = i + 1; j < len; j++) {
				if (arr[j] < arr[minIndex]) {// Ѱ����С��
					minIndex = j;
				}
			}
			// ����С����������������ĩβ
			temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 3, 5, 8, 4, 14 };
		int[] res = new Selection().selectionSort(arr);
		ArrayUtil.printArray(res);
	}
}
