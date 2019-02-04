package com.netas.interview.rest.authentication;


import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NameBinding
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RUNTIME)
public @interface Secured { }

