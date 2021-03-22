package com.yyn.serve;

import com.yyn.serve.netty.NettyServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableConfigurationProperties
@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = {"com.yyn.serve.mappers"})
public class ServeApplication {

    public static void main(String[] args) {


        final ConfigurableApplicationContext run = SpringApplication.run(ServeApplication.class, args);
        final NettyServer bean = run.getBean(NettyServer.class);
        try {
            bean.start();
        } catch (Exception e) {
            System.out.println("netty启动异常");
        }
    }

}
