package com.practice.practice.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
        http.cors().disable()
        http.authorizeRequests()
            .antMatchers(
                "/favicon*",
                "/android-chrome-*.png",
                "/manifest.webmanifest",
                "/actuator/health",
                "/apple-touch-icon.png",
                "/static/css/**",
                "/static/js/**",
                "/static/media/**",
                "/api/**"
            ).permitAll()
            .antMatchers(
                "/protected/**"
            ).authenticated()

    }
}