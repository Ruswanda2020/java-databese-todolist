package begginer_progremmer.util;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseUtilTest {
        @Test
        void connationTest() throws SQLException {
                HikariDataSource dataSource= DatabaseUtil.getDataSource();
                Connection connection=dataSource.getConnection();


                connection.close();
                dataSource.close();
        }
}
