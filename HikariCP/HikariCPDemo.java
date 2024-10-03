package HikariCP;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class HikariCPDemo {
    public static void main(String[] args) throws Exception {

        //2. Establish the connection between Java application and database
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/jdbcdemo");
        config.setUsername("root");
        config.setPassword("student");
        config.setMaximumPoolSize(10);

        HikariDataSource dataSource = new HikariDataSource(config);
        Connection con = dataSource.getConnection();

        //3. Create Statement/Prepare Statement/Callable Statement
        PreparedStatement ps = con.prepareStatement("Create table If Not Exists Student(name varchar(20),rollno int primary key)");
        ps.executeUpdate();
        ps = con.prepareStatement("Insert Into Student Values('Lion',102)");
        int count = ps.executeUpdate();
        if (count > 0)
            System.out.println("Successful");
        else System.out.println("Failed");
    }
}
