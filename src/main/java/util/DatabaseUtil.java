package util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {
    private static HikariDataSource dataSource;

    static {
        HikariConfig config =new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_todolist");
        config.setUsername("root");
        config.setPassword("wanda@20101999");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10*60_000);

        dataSource =new HikariDataSource(config);

    }

    public static HikariDataSource getDataSource() {
        return dataSource;
    }
}
