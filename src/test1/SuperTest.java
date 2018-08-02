package test1;

import java.util.Date;

public class SuperTest extends Date {


	public static void main(String[] args) {
		Integer i=0;
		Integer j = new Integer(0);
		Integer k = Integer.valueOf(123);
		Integer l = new Integer(123);
		System.out.println(i==j);
		System.out.println(j==k);
		System.out.println(k==l);
		System.out.println(j.equals(i));
	}
}
