package reverseSentence;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a
 * student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
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
