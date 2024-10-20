package STEPS_TO_CREATE_CONNECTION_AND_EXECUTE_THE_QUERY;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main2 {
    public static void main(String[] args) throws SQLException {
                int rollno = 106;
                String name = "Rahul";

                Connection con = null;
                PreparedStatement ps = null;
                try{
                    // 1. load or register the driver 
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    System.out.println("Driver Registered");

                    // 2. Establish Connection
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDEMO","root","student");
                    System.out.println("Connection Established");

                    // 3. create statement/PreparedStatment/CollableStatement
                    //===================CREATE TABLE===========================
                    //ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS Student(name VARCHAR(50), rollno INT)");

                    //=======================INSERT==============================
                    ps = con.prepareStatement("INSERT INTO Student value ('"+name+"','"+rollno+"')");

                    int count = ps.executeUpdate(); //return no. of rows affected
                    System.out.println(count);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    assert ps != null;
                    ps.close();
                    con.close();
                }
    }
}
