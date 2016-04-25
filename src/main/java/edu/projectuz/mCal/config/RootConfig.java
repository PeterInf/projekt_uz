package edu.projectuz.mCal.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import edu.projectuz.mCal.config.RootConfig.WebPackage;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages={"edu.projectuz.mCal"},
        excludeFilters={
                @ComponentScan.Filter(type= FilterType.CUSTOM, value= WebPackage.class)
        })
public class RootConfig {
        public static class WebPackage extends RegexPatternTypeFilter{
                public WebPackage() {
                        super(Pattern.compile("edu.projectuz.mCal\\.web"));
                }
        }
}
