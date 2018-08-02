package sort;

/**
 * ð��������һ�ּ򵥵������㷨�����ظ����߷ù�Ҫ��������У�һ�αȽ�����Ԫ�أ�������ǵ�˳�����Ͱ����ǽ���������
 * �߷����еĹ������ظ��ؽ���ֱ��û������Ҫ������Ҳ����˵�������Ѿ�������ɡ�����㷨��������������ΪԽС��Ԫ�ػᾭ�ɽ������������������еĶ��ˡ�
 * 
 * �㷨���� �Ƚ����ڵ�Ԫ�ء������һ���ȵڶ����󣬾ͽ�������������
 * ��ÿһ������Ԫ����ͬ���Ĺ������ӿ�ʼ��һ�Ե���β�����һ�ԣ�����������Ԫ��Ӧ�û����������� ������е�Ԫ���ظ����ϵĲ��裬�������һ����
 * �ظ�����1~3��ֱ��������ɡ�
 * 
 * @author hasee
 *
 */
public class Bubble {
	public int[] bubbleSort(int[] arr) {
		int length = arr.length;
		int temp;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - 1 - i; j++) {
				if (arr[j] >= arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = {3,9,6,8,-10,7,-11,19,30,12,23};
		int[] res = new Bubble().bubbleSort(arr);
		ArrayUtil.printArray(res);
	}
}
