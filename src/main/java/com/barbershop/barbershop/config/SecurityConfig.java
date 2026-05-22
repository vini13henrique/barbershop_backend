package com.barbershop.barbershop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// marca esta classe como configuração do Spring
@Configuration
public class SecurityConfig {

    // marca este método como Bean gerenciado pelo Spring
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // desabilita proteção CSRF para API REST
        http.csrf(csrf -> csrf.disable())

                // define regras de autorização das requisições HTTP
                .authorizeHttpRequests(auth ->

                        // qualquer requisição precisa estar autenticada
                        auth.anyRequest().authenticated()
                )

                // habilita autenticação Basic Auth com configuração padrão
                .httpBasic(Customizer.withDefaults());

        // constrói e retorna cadeia final de filtros de segurança
        return http.build();
    }
}
