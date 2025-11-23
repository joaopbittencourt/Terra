package com.house58.terra.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public static final String RECEPCIONISTA = "Recepcionista";
    public static final String AUXILIAR = "Auxiliar";
    public static final String TERAPEUTA = "Terapeuta";
    public static final String ADMIN = "administrador";
    private final JwtConverter jwtConverter;

    public SecurityConfig(JwtConverter jwtConverter) {
        this.jwtConverter = jwtConverter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) ->
                authz.requestMatchers(HttpMethod.GET, "/api/anamnesis/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/contract/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/healthinsurance/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/modality/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/checking/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/register-appointment/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/patient/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/responsible/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/prontuario/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/session/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/shedule/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/discipline/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/team/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/user/**").hasAnyRole(ADMIN, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/anamnesis/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/contract/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/healthinsurance/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/modality/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/checking/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/register-appointment/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/patient/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/responsible/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/prontuario/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/session/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/shedule/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/discipline/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/team/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/user/**").hasAnyRole(ADMIN, TERAPEUTA, RECEPCIONISTA)
                        .anyRequest().authenticated());

        http.sessionManagement(sess -> sess.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS));
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtConverter)));

        return http.build();
    }
}