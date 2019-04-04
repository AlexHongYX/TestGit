import java.util.ArrayList;
//将字符串数组中的字符中的数字转化为数字数组并返回
//需要处理字符串数组中的第一个字符（多一个[）和最后一个字符（多一个])
//调用StringArrayToIntArray类中的StringArrayToIntArrayUtil方法，并传入一个字符串数组，即可得到返回的数字数组
public class StringArrayToIntArray {

    private static ArrayList<String> StringArrayToStringList(String[] strings){
        ArrayList<String> StringList = new ArrayList<>();
        for(int i=0;i<strings.length;i++){
                if(i==0){
                    strings[i] = strings[i].substring(2,strings[i].length()-1);
                }else if(i==strings.length-1){
                    strings[i] = strings[i].substring(1,strings[i].length()-2);
                }else{
                    strings[i] = strings[i].substring(1,strings[i].length()-1);
                }
                StringList.add(strings[i]);
            }
        return StringList;
    }

    private static Integer[] StringListToIntArray(ArrayList<String> StringList){

        Integer[] ints = new Integer[StringList.size()];
        for(int i=0;i<StringList.size();i++){
            ints[i] = Integer.valueOf(StringList.get(i));
        }
        return ints;
    }

    private static Integer[] StringArrayToIntArrayUtil(String[] strings){
        return StringListToIntArray(StringArrayToStringList(strings));
    }


    public static void main(String[] args){
        String[] strings = {"[\"50\"","\"15\"","\"55\"","\"15553\"","\"79\"","\"15\"","\"40]\""};
        Integer[] integers = StringArrayToIntArray.StringArrayToIntArrayUtil(strings);
        for(int i:integers){
            System.out.println(i);
        }
    }

}
