import java.sql.*;
import java.util.ArrayList;

/**
 * Created by xiaoaxiao on 2020/1/3
 * Description:
 */
public class BuildDAO {
    private Connection con;
    public BuildDAO()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //��������
            String conStr="jdbc:mysql://127.0.0.1:3306/build_message?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
            //���������ַ���
            String user = "root";
            String password = "8023hyx1999hyx";
            con= DriverManager.getConnection(conStr,user,password);
            //�������ݿ����Ӷ���
        }
        catch (ClassNotFoundException e) {//��׽����������δ�ҵ��쳣
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (SQLException e) {//��׽�����������ӻ��߲����쳣
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    //���ݷ�������ѯ�û�
    public BuildInfo findBuiByBno(String bno)
    {
        BuildInfo bui=null;
        try{
            PreparedStatement ps=con.prepareStatement("select * from build where bno=?");
            ps.setString(1, bno);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                String name=rs.getString(2);
                String sex=rs.getString(3);
                int age=rs.getInt(4);
                String dept=rs.getString(5);
                bui=new BuildInfo(bno,name,sex,age,dept);
            }
            ps.close();
            //�ر�SQL���ִ�ж���
            //con.close();
            //�ر����ݿ����Ӷ���
        }
        catch (SQLException e) {//��׽�����������ӻ��߲����쳣
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return bui;
    }

    //������������ѯѧ��
    public ArrayList<BuildInfo> findBuiByBname(String bname)
    {
        ArrayList<BuildInfo> result=new ArrayList<>();
        try{
            Statement st=con.createStatement();
            String strSQL="select * from build where bname like '%"+bname+"%'";
            ResultSet rs=st.executeQuery(strSQL);
            while(rs.next())
            {
                String sno=rs.getString(1);
                String name=rs.getString(2);
                String sex=rs.getString(3);
                int age=rs.getInt(4);
                String dept=rs.getString(5);
                BuildInfo bui=new BuildInfo(sno,name,sex,age,dept);
                result.add(bui);
            }
            st.close();
            //�ر�SQL���ִ�ж���
            //con.close();
            //�ر����ݿ����Ӷ���
        }
        catch (SQLException e) {//��׽�����������ӻ��߲����쳣
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    public void addBuild(BuildInfo bui)
    {
        try{
            PreparedStatement ps=con.prepareStatement("insert into build values(?,?,?,?,?)");
            //����SQL���ִ�ж���
            ps.setString(1, bui.getBno());
            ps.setString(2,bui.getBname());
            ps.setString(3, bui.getSex());
            ps.setInt(4,bui.getAge());
            ps.setString(5,bui.getBdept());
            ps.execute();
            ps.close();
            //�ر�SQL���ִ�ж���
            //con.close();
            //�ر����ݿ����Ӷ���
        }
        catch (SQLException e) {//��׽�����������ӻ��߲����쳣
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void delBuild(String bno)
    {
        try{
            PreparedStatement ps=con.prepareStatement("delete from build where bno=?");
            //����SQL���ִ�ж���
            ps.setString(1, bno);
            ps.execute();
            ps.close();
            //�ر�SQL���ִ�ж���
            //con.close();
            //�ر����ݿ����Ӷ���
        }
        catch (SQLException e) {//��׽�����������ӻ��߲����쳣
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void updateBuild(BuildInfo bui)
    {

        try{
            PreparedStatement ps=con.prepareStatement("update build set bname=?,bsex=?,bage=?,bdept=? where bno=?");
            //����SQL���ִ�ж���
            ps.setString(1,bui.getBname());
            ps.setString(2, bui.getSex());
            ps.setInt(3,bui.getAge());
            ps.setString(4,bui.getBdept());
            ps.setString(5, bui.getBno());
            ps.execute();
            ps.close();
            //�ر�SQL���ִ�ж���
            //con.close();
            //�ر����ݿ����Ӷ���
        }
        catch (SQLException e) {//��׽�����������ӻ��߲����쳣
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
