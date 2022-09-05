package website.bfmatching.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import website.bfmatching.interceptor.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //인터셉터 등록.
    @Override
    public void addInterceptors(InterceptorRegistry registry){

        //login 인터셉터 등록
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/", "/members/new", "/login", "/logout",
                        "/login/**", "/login**", "/error",
                        "/*.ico", "/css/**", "/js/**", "/post/{*postId}"
                );


    }
}
