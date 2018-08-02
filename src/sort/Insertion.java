package sort;

/**
 * ��������Insertion-Sort�����㷨������һ�ּ�ֱ�۵������㷨�����Ĺ���ԭ����ͨ�������������У�����δ�������ݣ��������������дӺ���ǰɨ�裬
 * �ҵ���Ӧλ�ò����롣
 * 
 * �㷨����
 * 
 * һ����˵���������򶼲���in-place��������ʵ�֡������㷨�������£�
 * 
 * �ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ������� ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ�裻 �����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ�ã�
 * �ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ�ã� ����Ԫ�ز��뵽��λ�ú� �ظ�����2~5��
 * 
 * 
 * @author hasee
 *
 */
public class Insertion {
	public int[] InsertionSort(int[] arr) {
		int preIndex = 0;
		int current = 0;
		for (int i = 1; i < arr.length; i++) {// ɨ��δ�����Ԫ��
			preIndex = i - 1;
			current = arr[i];// ��������
			while (preIndex >= 0 && arr[preIndex] > current) {// ��ǰ�������ڱ�������ʱ��ǰ�������һλ
				arr[preIndex + 1] = arr[preIndex];
				preIndex--;
			}
			arr[preIndex + 1] = current;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 3, 5, 8, 4, 14 };
		int[] res = new Insertion().InsertionSort(arr);
		ArrayUtil.printArray(res);
	}
}
