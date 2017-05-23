package com.suglobov.jackal;

import com.suglobov.jackal.database.config.DataConfig;
import com.suglobov.jackal.justice.config.JusticeConfig;
import com.suglobov.jackal.rest.config.WebConfig;
import com.suglobov.jackal.salvage.config.SalvageConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by cactu on 31.03.2017.
 */

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                DataConfig.class,
                SalvageConfig.class,
                JusticeConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

