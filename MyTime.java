package text;

import java.util.Date;

public class MyTime {
	public static void main(String[] arg)
	{
		Date mytime = new Date();
		System.out.printf("%tc",mytime);
		System.out.printf("\n");
		System.out.printf("%1$s %2$tB %2$te %2$tY", "Due date:", mytime);
	}
}
