package Test3;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Lemon
 * @create 2022-11-07-14:21
 */
@Configuration  //配置类
@ComponentScan(basePackages = "Test3")  //组件扫描
@EnableTransactionManagement  //开启事务
public class Config {
    //创建数据库连接池
    @Bean
    public DataSource getDruidDataSource() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        InputStream is = new FileInputStream("src/jdbc.properties");
        Properties ps = new Properties();
        ps.load(is);
        dataSource.setDriverClassName(ps.getProperty("driverClassName"));
        dataSource.setUrl(ps.getProperty("url"));
        dataSource.setUsername(ps.getProperty("name"));
        dataSource.setPassword(ps.getProperty("password"));
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        is.close();
        return dataSource;
    }

    //创建 JdbcTemplate 对象
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        //到 ioc 容器中根据类型找到 dataSource
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //注入 dataSource
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    //创建事务管理器
    @Bean
    public DataSourceTransactionManager
    getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new
                DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
