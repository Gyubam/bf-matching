package website.bfmatching.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* '/images/**'로 호출하는 자원은 '/static/images/' 폴더 아래에서 찾는다. */
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/").setCachePeriod(60 * 60 * 24 * 365);
    }
}

//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        MustacheViewResolver resolver = new MustacheViewResolver();
//        resolver.setCharset("UTF-8");
//        resolver.setContentType("text/html; charset=UTF-8");
//        resolver.setPrefix("classpath:/templates/");
//        resolver.setSuffix(".html");
//
//        registry.viewResolver(resolver);
//    }
//}