package reOrderArray;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�����֤������������
 * ż����ż��֮������λ�ò��䡣
 * 
 * @author hasee
 *
 */
public class Solution {
	public void reOrderArray(int [] array) {
		StringBuilder sb1 = new StringBuilder();//����������
		StringBuilder sb2 = new StringBuilder();//������ż��
        for(int i = 0;i<array.length;i++){
        	if(array[i]%2==1)
        		sb1.append(array[i]);
        	else
        		sb2.append(array[i]);
        }
        sb1.append(sb2);
        char[] ch = sb1.toString().toCharArray();
        for (int i = 0; i < ch.length; i++) {
			array[i] = ch[i]-'0';
		}
    }
	
	public static void main(String[] args) {
		
	}
}
