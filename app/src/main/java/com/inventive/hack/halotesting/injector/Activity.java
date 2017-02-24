/**
 * Copyright (C) 2015 android10.org. All rights reserved.
 * @author Fernando Cejas (the android10 coder)
 */
package com.inventive.hack.halotesting.injector;

import java.lang.annotation.Retention;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Scope para las dependencias de las actividades.
 */
@Scope @Retention(RUNTIME)
public @interface Activity {}
