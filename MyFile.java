package text;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class MyFile {
	public static void main() throws IOException
	{
		Scanner in = new Scanner(Paths.get("F:\\fputcfgetc.txt"),"UTF-8");
		String name = in.next();
		System.out.println(name);
	}
}
