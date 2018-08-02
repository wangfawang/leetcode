package sort;

public class MaxHeap {

	// ��������ѣ���array������ȫ��������˳��洢�ṹ
	public int[] buildMaxHeap(int[] array) {
		// �����һ���ڵ�array.length-1�ĸ��ڵ㣨array.length-1-1��/2��ʼ��ֱ�����ڵ�0������������
		for (int i = (array.length - 2) / 2; i >= 0; i--) {
			maxify(array, i, array.length);
		}
		return array;
	}

	// ��Ԫ��array[k]���������𲽵������νṹ
	public void maxify(int[] array, int k, int size) {
		int temp = array[k];
		for (int i = 2 * k + 1; i < size; i = i * 2 + 1) {// iΪ��ʼ��Ϊ�ڵ�k�����ӣ��ؽڵ�ϴ���ӽڵ����µ���
			if (i + 1 < size && array[i] < array[i + 1]) {// ȡ�ڵ�ϴ���ӽڵ���±꣬����Һ��Ӵ��ڵĻ�
				i++;// ����ڵ���Һ���>���ӣ���ȡ�Һ��ӽڵ���±�
			}
			if (temp >= array[i]) { // ���ڵ� >=������Ů�йؼ��ֽϴ��ߣ���������
				break;
			} else {// ���ڵ� <������Ů�йؼ��ֽϴ���
				array[k] = array[i]; // �������ӽ���нϴ�ֵarray[i]������˫�׽ڵ���
				k = i; // ���ؼ����޸�kֵ���Ա�������µ���,��ʱ��Ҫ�����������Ѿ�ת��
			}
		}
		array[k] = temp; // �������Ľ���ֵ��������λ��

	}

	// ������
	public int[] heapSort(int[] array, int k) {
		array = buildMaxHeap(array); // ��ʼ���ѣ�array[0]Ϊ��һ��ֵ����Ԫ��
		for (int i = array.length - 1; i > array.length - 1 - k; i--) {// �����������ܹ�length-1��������
			int temp = array[0]; // ���Ѷ�Ԫ�غͶѵ�Ԫ�ؽ��������õ���ǰ���Ԫ����ȷ������λ��
			array[0] = array[i];
			array[i] = temp;
			maxify(array, 0, i); // ������ʣ���Ԫ������ɶ�
		}
		return array;
	}

	public void toString(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static void main(String args[]) {
		MaxHeap hs = new MaxHeap();
		int[] array = { 87, 45, 78, 32, 17, 65, 53, 9, 122, 133 };
		System.out.print("��������ѣ�");
		hs.toString(hs.buildMaxHeap(array));
		System.out.print("\n" + "���������");
		hs.toString(hs.heapSort(array, 4));
	}
}
