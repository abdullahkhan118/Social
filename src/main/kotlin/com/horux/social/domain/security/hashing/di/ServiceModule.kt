package com.horux.social.domain.security.hashing.di

import com.horux.social.domain.security.hashing.HashingService
import com.horux.social.domain.security.hashing.SHA256HashingService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ServiceModule {
    @Bean
    @SHA256HashingServiceQualifier
    fun newInstance(): HashingService = SHA256HashingService()
}