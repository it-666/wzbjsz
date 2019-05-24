package com.wzb.applet;

import com.wzb.tools.exception.OrgExceptionInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("com.wzb.applet.mapper.*")
public class AppletApplication {

//	/**
//	 * 统一异常处理，，拦截器
//	 * @return
//	 */
//	@Bean
//	public OrgExceptionInterceptor doCatchException(){
//		return  new OrgExceptionInterceptor();
//	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(AppletApplication.class);
		application.setBannerMode(Banner.Mode.LOG);
		application.run(args);
	}

}

