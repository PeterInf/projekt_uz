package edu.projectuz.mCal.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages={"edu.projectuz.mCal.importers"},
        excludeFilters={
                @ComponentScan.Filter(type= FilterType.CUSTOM, value= EnableWebMvc.class)
        })
public class RootConfig {
}
