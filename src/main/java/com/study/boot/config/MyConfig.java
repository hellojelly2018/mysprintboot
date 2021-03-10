package com.study.boot.config;

import com.study.boot.bean.Pet;
import com.study.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import javax.naming.Name;

/**
 * @author Yangjiali
 * @create 2021-03-15:10 15:10
 */
// 导入第三方的xml配置文件。例如一些老的项目，用的是xml文件
//@ImportResource("classpath:beans.xml")
//容器没有tomcatPet这个Bean，则容器不会装载这个配置类
//@ConditionalOnBean(name = "tomcatPet")
//默认为proxyBeanMethods = true，也就是单例。如果这个配置类中的实例没有依赖，则可以设置为false，可以提高装载速度。
@EnableConfigurationProperties(Pet.class)
@Configuration(proxyBeanMethods = true)  //singleton
public class MyConfig implements WebMvcConfigurer {

    @Bean
    public Pet tomcatPet() {
        return new Pet("tom", 20.2);
    }

    //@ConditionalOnBean(name = "tomcatPet") //必须在tomcatPet定义之后
    @Bean
    public User user01() {
        return new User("zhangsan", 33);
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        // 默认移除分号，也就是禁用了矩阵变量
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void configurePathMatch(PathMatchConfigurer configurer) {
//                UrlPathHelper urlPathHelper = new UrlPathHelper();
//                // 默认移除分号，也就是禁用了矩阵变量
//                urlPathHelper.setRemoveSemicolonContent(false);
//                configurer.setUrlPathHelper(urlPathHelper);
//            }
//        };
//    }
}
