package cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableOAuth2Sso
@EnableSwagger2
@EnableFeignClients(basePackages = "cn.config")
@EnableHystrix
public class EurekaPrescription_8081 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaPrescription_8081.class,args);
    }
}
