import java.sql.*;

public class ConnectionDB {

    public static void main(String[] args) {

        Connection connect=null;

        String url="jdbc:mysql://localhost:3306/";
        String driver="com.mysql.jdbc.Driver"; //1
        String dbName="testing";
        String user="root";
        String pass="";
        try {

        Class.forName(driver).newInstance(); //obj of the driver
            connect=DriverManager.getConnection(url+dbName,user,pass);
        System.out.println(connect.isClosed());
        //how do we fire query
            Statement st=connect.createStatement();
            ResultSet rs=st.executeQuery("Select * from  employee");
            while (rs.next()){
                System.out.println(rs.getString(1)+"----"+rs.getString("PLACE"));
            }
            st.executeUpdate("Insert into employee values ('smith','USA',40)");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if ((connect!=null) &&(!connect.isClosed()));
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
