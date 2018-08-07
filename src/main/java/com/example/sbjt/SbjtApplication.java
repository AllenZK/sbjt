package com.example.sbjt;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication //隐式的定义了搜索包，来加载主类；如果您不想使用@SpringBootApplication，它导入的@EnableAutoConfiguration和@ComponentScan注释会定义该行为，因此您也可以使用它。
public class SbjtApplication  {

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SbjtApplication.class);
	}*/

	public static void main(String[] args) {
		/**
		 * 自定义springApplication
		 */
		SpringApplication sapp = new SpringApplication(SbjtApplication.class);
		//sapp.setBannerMode(Banner.Mode.OFF); //关闭横幅
		//sapp.setAdditionalProfiles("dev");//设置激活对应配置文件


		sapp.run(args);
		//SpringApplication.run(SbjtApplication.class, args);
	}
}
