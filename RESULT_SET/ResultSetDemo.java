package RESULT_SET;

import java.sql.*;
import java.util.Scanner;

public class ResultSetDemo {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Employee Name: ");
        String name = sc.nextLine();
        System.out.println("Employee Salary: ");
        int salary = sc.nextInt();

        PreparedStatement ps = null;
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Register the Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_Code","root","student");
            System.out.println("Connection Established");

            //PreparedStatement ps = con.prepareStatement("Create Table Employee(emp_id int,emp_name varchar(20),salary int)");
            //PreparedStatement ps = con.prepareStatement(" Insert Into Employee value('"+id+"','"+name+"','"+salary+"') ");
            //PreparedStatement ps = con.prepareStatement("Update Employee Set emp_name = ? where emp_id = ? ");
            //ps.setString(1,"Abhishek Singh");
            //ps.setString(2, "101");

            ps = con.prepareStatement("Select emp_id,emp_name,salary from Employee",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

            System.out.println("Employee data Fetched the data");
            ResultSet rs = ps.executeQuery();
            rs.afterLast();

            System.out.println("EMPLOYEE DETAILS: ");
            while(rs.previous()){
                String name1 = rs.getString("emp_id");
                int id1 = rs.getInt("emp_id");
                int salary1 = rs.getInt("salary");
                System.out.println("Id: "+id1);
                System.out.println("Name: "+name1);
                System.out.println("Salary: "+salary1);
                System.out.println("----------------------");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            ps.close();
            con.close();
        }
    }
}
