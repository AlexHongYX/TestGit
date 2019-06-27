package text;

public class charchuan {
	public static void main(String[] arg)
	{
		String s = "JavaHello";
		System.out.println(s);
		String s1 = s.substring(0,3);   //substring容易计算子串的长度b-a
		System.out.println(s1);
		int a = 12;
		String s2 = "SUST"+a;
		System.out.println(s2);
		String s3 = String.join("/","S","M","L","Xl");
		System.out.println(s3);
		int index = s.offsetByCodePoints(0,2);
		System.out.println(index);
		int cp = s.codePointAt(1);
		System.out.println(cp);
	}
}
