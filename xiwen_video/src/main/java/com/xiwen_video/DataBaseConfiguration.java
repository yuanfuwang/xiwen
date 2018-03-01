package com.xiwen_video;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/**
 * 数据库配置：解析properties文件
 * @author Song.Wang
 *
 */
//@Configuration
//@PropertySource("classpath:mybatis/mybatis.properties")
public class DataBaseConfiguration {
	private static Logger log = LoggerFactory.getLogger(DataBaseConfiguration.class); 
	
	@Value("${spring.datasource.type}")  
    private Class<? extends DataSource> dataSourceType;  
  
    @Bean(name="writeDataSource")  
    @Primary  
    @ConfigurationProperties(prefix = "spring.datasource")  
    public DataSource writeDataSource() {  
        log.info("-------------------- writeDataSource init ---------------------");  
        return DataSourceBuilder.create().type(dataSourceType).build();  
    }  
    /** 
     * 有多少个从库就要配置多少个 
     * @return 
     */  
    @Bean(name = "readDataSource1")  
    @ConfigurationProperties(prefix = "spring.slave")  
    public DataSource readDataSourceOne(){  
        log.info("-------------------- readDataSourceOne init ---------------------");  
        return DataSourceBuilder.create().type(dataSourceType).build();  
    }  
  
//    @Bean("readDataSources")  
//    public List<DataSource> readDataSources(){  
//        List<DataSource> dataSources=new ArrayList<>();  
//        dataSources.add(readDataSourceOne());  
//        return dataSources;  
//    } 
}
