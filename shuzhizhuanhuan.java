package text;

import java.lang.Math;

public class shuzhizhuanhuan {
	public static void main(String[] arg)
	{
		long n = 123456789;
		float f = n;
		System.out.println(f);
		double a = 3.8415;
		int b = (int)a;
		System.out.println(b);
		int c;
		c = (int)Math.round(a);    //round�������صĽ��Ϊlong����
		System.out.println(c);
		int d;
		d = 2+3	<<35;
		System.out.println(d);
	}
}
