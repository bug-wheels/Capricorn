package com.github.bw.capricorn.server;

import com.github.bw.capricorn.server.config.CapricornServerPropertiesAutoConfiguration;
import com.github.bw.capricorn.server.config.DataSourceTransactionManagerAutoConfiguration;
import com.github.bw.capricorn.server.config.EndPointAutoConfiguration;
import com.github.bw.capricorn.server.config.ServerServiceRegistryAutoConfiguration;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({CapricornServerPropertiesAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class,
    ServerServiceRegistryAutoConfiguration.class,
    EndPointAutoConfiguration.class})
public @interface EnableCapricornServer {

}
