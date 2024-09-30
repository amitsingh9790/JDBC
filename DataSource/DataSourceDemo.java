package DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataSourceDemo {
    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/jdbcdemo");
        dataSource.setUser("root");
        dataSource.setPassword("student");

        try(
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement("Insert Into Student values(?,?) ");
            )
        {
            ps.setString(1,"Rohit Singh");
            ps.setInt(2,112);
            int count = ps.executeUpdate();
            if(count>0) System.out.println("Successful");
            else System.out.println("Failed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
