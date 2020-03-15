package com.jiangjf.studyweb;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.TimeZone;

@SpringBootApplication
public class StudyWebApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(StudyWebApplication.class);
        //app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonBuilderCustomizer() {
        return builder -> {
            builder.indentOutput(true);// json缩进
            builder.timeZone(TimeZone.getTimeZone("Asia/Shanghai"));// 时区
        };
    }

}
