package com.exemplo;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;


@Configuration
@ApplicationPath("v1")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(BookResource.class);
    }
}
