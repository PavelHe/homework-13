package com.github.pavelhe.configuration;

import org.springframework.context.annotation.*;
import org.springframework.security.access.expression.method.*;
import org.springframework.security.config.annotation.method.configuration.*;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class AclMethodSecurityConfiguration extends GlobalMethodSecurityConfiguration {

    private final MethodSecurityExpressionHandler defaultMethodSecurityExpressionHandler;

    public AclMethodSecurityConfiguration(MethodSecurityExpressionHandler defaultMethodSecurityExpressionHandler) {
        this.defaultMethodSecurityExpressionHandler = defaultMethodSecurityExpressionHandler;
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return defaultMethodSecurityExpressionHandler;
    }
}
