package text;

import java.util.*;

public class InputText {
	public static void main(String[] arg)
	{
		Scanner in = new Scanner(System.in);
		
		//get first input
		System.out.println("What is your name?");
		String name = in.nextLine();
		
		//get second input
		System.out.println("How old are you?");
		int age = in.nextInt();
		
		//display output on console
		System.out.println("Hello, "+name+". Next year,you will be" + (age+1));
	}
}
