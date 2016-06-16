package edu.projectuz.mCal.config;

import edu.projectuz.mCal.web.converter.StringToDateConverter;
import edu.projectuz.mCal.web.converter.StringToTimeZoneConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.
        DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.
        EnableWebMvc;
import org.springframework.web.servlet.config.annotation.
        WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.
        InternalResourceViewResolver;
import org.springframework.web.servlet.
        config.annotation.ResourceHandlerRegistry;

import java.io.IOException;

@Configuration
@EnableWebMvc
@ComponentScan("edu.projectuz.mCal.web")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public final ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Override
    public final void configureDefaultServletHandling(
            final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public final void addFormatters(final FormatterRegistry registry) {
        registry.addConverter(new StringToDateConverter());
        registry.addConverter(new StringToTimeZoneConverter());
    }

    @Override
    public final void addResourceHandlers(
            final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public final MultipartResolver multipartResolver() throws IOException {
        CommonsMultipartResolver multipartResolver =
                new CommonsMultipartResolver();
        multipartResolver.setMaxInMemorySize(0);
        return multipartResolver;
    }
}
