package edu.projectuz.mCal.config;

import org.springframework.web.servlet.support.
        AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.*;

public class WebInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected final Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected final Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected final String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("/tmp/calendar/uploads", 15097152, 30194304, 0));
    }
}
