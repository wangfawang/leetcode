package reverseSentence;

/**
 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish����������
 * ��ȴ������������˼�����磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a
 * student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 * 
 * @author hasee
 *
 */
public class Solution {
	public String ReverseSentence(String str) {
		if (str.trim().length() == 0)
			return str;
		String[] words = str.split(" ");
		String res = "";
		int len = words.length;
		for (int i = 0; i < len / 2; i++) {
			String temp = words[len - i - 1];
			words[len - i - 1] = words[i];
			words[i] = temp;
		}
		for (int i = 0; i < words.length; i++) {
			res += words[i] + " ";
		}
		return res.trim();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().ReverseSentence(" "));
	}
}
