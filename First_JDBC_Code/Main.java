package First_JDBC_Code;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
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
            ps = con.prepareStatement("CREATE TABLE IF NOT EXISTS Student(name VARCHAR(50), rollno INT)");

            //=======================INSERT==============================
            //ps = con.prepareStatement("INSERT INTO Student value (?,?)");
            //ps.setString(1,"Amit");
            //ps.setString(2, String.valueOf(1005));

            //=======================UPDATE==============================
            //ps = con.prepareStatement("UPDATE Student SET name = ? Where rollno = ? ");
            //ps.setString(1,"Rahul");
            //ps.setString(2, String.valueOf(1005));

            //========================DELETE=============================
            //ps = con.prepareStatement("DELETE FROM student WHERE name = 'Amit' ");

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
