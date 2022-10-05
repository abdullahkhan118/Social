package com.horux.social.domain.security.hashing.di

import org.springframework.beans.factory.annotation.Qualifier

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class RegisterMapperQualifier