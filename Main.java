package First_JDBC_Code;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Scanner sc = new Scanner(System.in);
//        String name1 = sc.nextLine();
//        int rollno1 = sc.nextInt();

        Connection con = null;
        PreparedStatement ps = null;

        try{
            // 1. load or register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Register the driver");

            //2. Establish Connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDEMO","root","student");
            System.out.println("Connection Established");

            //3. create statement/PreparedStatment/CallableStatement
            //ps = con.prepareStatement("CREATE TABLE Student(name VARCHAR(50), rollno INT)");
            //INSERT
            ps = con.prepareStatement("INSERT INTO Student value ('Raj',1003)");
            //UPDATE
            ps = con.prepareStatement("UPDATE Student SET name = ? Where rollno = ? ");
            //ps = con.prepareStatement("UPDATE Student SET name = '"+name1+"' WHERE rollno = '"+rollno1+"' ");
            ps.setString(1,"Amit");
            ps.setString(2, String.valueOf(1003));
            
            //ps = con.prepareStatement("Select * From Student", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            //4. execute the Query
            ps.executeUpdate();
            //ResultSet rs = ps.executeQuery();

//            while (rs.next()){
//                String name2 = rs.getString("name"); 
//                int rollno2 = rs.getInt("rollno");
//                System.out.println(name2+" "+rollno2);
//            }
            
            //int count = ps.executeUpdate(); //return no. of rows affected
            //System.out.println(count);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            ps.close();
            con.close();
        }
    }
}
