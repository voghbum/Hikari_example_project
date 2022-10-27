package com.voghbum.hikari_example_project.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.persistence.GeneratedValue;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class DataSource {
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource ds;

    static {
        //eski connectionlar için. DataSourceClassPath set etmek daha uygun.
        config.setJdbcUrl("jdbc:h2:mem:hikari_test_db");

        config.setUsername("sa");
        config.setPassword("password");

        //direk cache mekanizmasını kapar. false olduğunda aşağıdaki iki ayarın
        //anlamı yok.
        config.addDataSourceProperty("cachePrepStmts", "true");

        //mysql ile ilgili. Connection başına cache'e alınacak statement sayısı
        config.addDataSourceProperty("prepStmtCacheSize", "250");

        //cache'de tutulacak sql statementların maksimum uzunluğu
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        //Clientın bir connection için bekleybileceği maksimum süre.
        // Bu süre connection bulunmadan açılırsa SQLException fırlatılır.
        config.addDataSourceProperty("connectionTimeOut", 10000);

        //Bir connection'ın idle modda takılabileceği süre. Fakat eğer havuzda minimumIdle sayısından
        //Daha az connection var ise bu kural işlemez.
        //Bir connection'ın idle modda olup olmadığı 15-30 sn arasında boşta olup olmamasına göre belirlenir.
        config.setIdleTimeout(30_000);

        ds = new HikariDataSource(config);
    }

    private DataSource() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
