package reOrderArray;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，
 * 偶数和偶数之间的相对位置不变。
 * 
 * @author hasee
 *
 */
public class Solution {
	public void reOrderArray(int [] array) {
		StringBuilder sb1 = new StringBuilder();//用来放奇数
		StringBuilder sb2 = new StringBuilder();//用来放偶数
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
