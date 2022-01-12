package com.github.bw.capricorn.server;

import com.github.bw.capricorn.server.config.EndPointAutoConfig;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({EndPointAutoConfig.class})
public @interface EnableCapricornServer {

}
