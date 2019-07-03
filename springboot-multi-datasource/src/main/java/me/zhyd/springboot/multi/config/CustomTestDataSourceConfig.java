package me.zhyd.springboot.multi.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * springboot
 * Created by yadong.zhang on com.zyd.multi.config
 * @Author: yadong.zhang
 * @Date: 2017/8/29 18:15
 */
@Configuration
@MapperScan(basePackages = "com.zyd.multi.mapper.custom", sqlSessionTemplateRef  = "customTestSqlSessionTemplate")
public class CustomTestDataSourceConfig {

    @Bean(name = "customTestDataSource")
    @ConfigurationProperties(prefix = "innodev.custom.database")
    public DataSource customTestDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "customTestSqlSessionFactory")
    public SqlSessionFactory customTestSqlSessionFactory(@Qualifier("customTestDataSource") DataSource customTestDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(customTestDataSource);

//        MapperHelper mapperHelper = new MapperHelper();
//        //特殊配置
//        Config config = new Config();
//        //具体支持的参数看后面的文档
//        config.setIDENTITY("MYSQL");
//        config.setNotEmpty(false);
//        //设置配置
//        mapperHelper.setConfig(config);
//        // 注册自己项目中使用的通用Mapper接口，这里没有默认值，必须手动注册
//        mapperHelper.registerMapper(MyMapper.class);
//        //配置完成后，执行下面的操作
//        mapperHelper.processConfiguration(sessionFactory.getObject().openSession().getConfiguration());
//        sessionFactory.setPlugins(new Interceptor[]{(Interceptor) mapperHelper});
        //指定mapper xml目录
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/custom/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean(name = "customTestTransactionManager")
    public DataSourceTransactionManager customTestTransactionManager(@Qualifier("customTestDataSource") DataSource customTestDataSource) {
        return new DataSourceTransactionManager(customTestDataSource);
    }

    @Bean(name = "customTestSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("customTestSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
