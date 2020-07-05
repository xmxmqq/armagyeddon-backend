package com.blockchain.armagyeddon.config;

import org.springframework.context.annotation.Configuration;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import lombok.RequiredArgsConstructor;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .mvcMatchers("/","/sign-up", "/check-email-token", "/login").permitAll() // 인증 허가

                .mvcMatchers("/").permitAll()
                .anyRequest().authenticated();


//        http.formLogin()// 로그인 폼 사용
//                .loginPage("/login")
//                .defaultSuccessUrl("/main") // 로그인 성공시 main 호출
//                .permitAll();

        http.logout()
                .logoutSuccessUrl("/");

    }

}



