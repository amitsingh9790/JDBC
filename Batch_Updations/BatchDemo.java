package Batch_Updations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchDemo {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCDEMO","root","student");

        PreparedStatement ps = con.prepareStatement("INSERT INTO STUDENT VALUE(?,?)");
        ps.setString(1,"Surendra Pratap Singh");
        ps.setInt(2,100);
        ps.addBatch();

        ps.setString(1,"Ravindra Pratap Singh");
        ps.setInt(2,101);
        ps.addBatch();

        ps.setString(1,"Birendra Pratap Singh");
        ps.setInt(2,102);
        ps.addBatch();

        int[] count = ps.executeBatch();
        for(int i:count){
            System.out.println(i);
        }
    }
}
