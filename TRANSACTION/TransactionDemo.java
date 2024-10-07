package TRANSACTION;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionDemo {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDEMO","root","student");
//        Statement s = con.createStatement();
        PreparedStatement ps = con.prepareStatement("Insert Into Student value(?,?)");
        con.setAutoCommit(false);

        ps.setString(1,"A");
        ps.setInt(2,101);
        int count1 = ps.executeUpdate();

        ps.setString(1,"B");
        ps.setString(2,"103");
        int count2 = ps.executeUpdate();

        ps.setString(1,"C");
        ps.setInt(2,103);
        int count3 = ps.executeUpdate();

        if(count1>0 && count2>0 && count3>0){
            con.commit();
            System.out.println("Successful");
        }else {
            con.rollback();
            System.out.println("Failed");
        }
    }
}

