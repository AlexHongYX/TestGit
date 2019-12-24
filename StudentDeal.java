package SelectSystem;

import java.io.*;
import java.util.*;
public class StudentDeal {
	public String findNameByNum(String num)
	{
		String name="查无此人";
		try {
			FileReader fr=new FileReader("d:\\student.txt");
			BufferedReader br=new BufferedReader(fr);
			String str=br.readLine();
			while(str!=null)
			{
				String[] infos=str.split(",");
				if(infos[0].equals(num))
				{
					name=infos[1];
					break;
				}
				str=br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		return name;
	}
	
	public String findNumByName(String name)
	{
		String num="查无此号";
		try {
			FileReader fr=new FileReader("d:\\student.txt");
			BufferedReader br=new BufferedReader(fr);
			String str=br.readLine();
			while(str!=null)
			{
				String[] infos=str.split(",");
				if(infos[1].equals(name))
				{
					num=infos[0];
					break;
				}
				str=br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		return num;
	}
	
	public String findResultByPara(String paraName,String paraValue)
	{
		String result="";
		int i,j=0;
		if(paraName.equals("姓名"))
		{
			result="查无此人";
			i=1;
			j=0;
		}
		else
		{
			result="查无此号";
			i=0;
			j=1;
		}
		try {
			FileReader fr=new FileReader("d:\\student.txt");
			BufferedReader br=new BufferedReader(fr);
			String str=br.readLine();
			while(str!=null)
			{
				String[] infos=str.split(",");
				if(infos[i].equals(paraValue))
				{
					result=infos[j];
					break;
				}
				str=br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	public int getStudentCountBySex(String sex)
	{
		int count=0;
		try {
			FileReader fr=new FileReader("d:\\student.txt");
			BufferedReader br=new BufferedReader(fr);
			String str=br.readLine();
			while(str!=null)
			{
				String[] infos=str.split(",");
				if(infos[2].equals(sex))
				{
					count++;
				}
				str=br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		return count;
	}
	
	public void addStudent(StudentInfo stu)
	{
		if(!isExist(stu.getNum()))
		{
			try {
				FileWriter fw = new FileWriter("d:\\student.txt", true);
				BufferedWriter bw = new BufferedWriter(fw);
				StringBuffer str = new StringBuffer();
				str.append(stu.getNum() + ",");
				str.append(stu.getName() + ",");
				str.append(stu.getSex());
				bw.newLine();
				bw.write(str.toString());
				bw.close();
				fw.close();
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	private boolean isExist(String num)
	{
		boolean result=false;
		try {
			FileReader fr=new FileReader("d:\\student.txt");
			BufferedReader br=new BufferedReader(fr);
			String str=br.readLine();
			while(str!=null)
			{
				String[] infos=str.split(",");
				if(infos[0].equals(num))
				{
					result=true;
					break;
				}
				str=br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	private ArrayList<String> getAllStudents()
	{
		ArrayList<String> result=new ArrayList<String>();
		try {
			FileReader fr=new FileReader("d:\\student.txt");
			BufferedReader br=new BufferedReader(fr);
			String str=br.readLine();
			while(str!=null)
			{
				result.add(str);
				str=br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		return result;
	}

	public void updateStudent(StudentInfo stu)
	{
		if(isExist(stu.getNum()))
		{
			ArrayList<String> oldList=getAllStudents();
			for(int i=0;i<oldList.size();i++)
			{
				if(oldList.get(i).toString().split(",")[0].equals(stu.getNum()))
				{
					oldList.remove(i);
					StringBuffer str = new StringBuffer();
					str.append(stu.getNum() + ",");
					str.append(stu.getName() + ",");
					str.append(stu.getSex());
					oldList.add(str.toString());
					break;
				}
			}
			try {
				FileWriter fw = new FileWriter("d:\\student.txt");
				BufferedWriter bw = new BufferedWriter(fw);
			    for(int i=0;i<oldList.size();i++)
			    { 	
			    	bw.write(oldList.get(i).toString());
			    	bw.newLine();
			    }
				bw.close();
				fw.close();
			} catch (FileNotFoundException e) {
	
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public String deleteStudent(String num)
	{
		String result1="学号未找到！！";
		String result2="删除成功！";
		if(isExist(num))
		{
			ArrayList<String> oldList=getAllStudents();
			for(int i=0;i<oldList.size();i++)
			{
				if(oldList.get(i).toString().split(",")[0].equals(num))
				{
					oldList.remove(i);
					break;
				}
			}
			try {
				FileWriter fw = new FileWriter("d:\\student.txt");
				BufferedWriter bw = new BufferedWriter(fw);
			    for(int i=0;i<oldList.size();i++)
			    { 	
			    	bw.write(oldList.get(i).toString());
			    	bw.newLine();
			    }
				bw.close();
				fw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result2;
		}
		return result1;
	}
}
