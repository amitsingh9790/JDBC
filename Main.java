import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        try{
            // 1. load or register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Register the driver");
            //2. Establish Connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDEMO","root","student");
            System.out.println("Connection Established");

            //3. create statement/PreparedStatement/CollableStatement
            //ps = con.prepareStatement("CREATE TABLE Student(name VARCHAR(50), rollno INT)");
            //ps = con.prepareStatement("INSERT INTO student VALUES('Amit',103)");
            ps = con.prepareStatement("INSERT INTO student VALUES('',)");

            //4. execute the Query
            int count = ps.executeUpdate(); //return no. of rows affected
            System.out.println(count);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            ps.close();
            con.close();
        }
    }
}
