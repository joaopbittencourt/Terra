package com.house58.terra.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


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
       /*
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )

                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();*/
        http.authorizeHttpRequests((authz) ->
                authz.requestMatchers(HttpMethod.GET, "/api/anamnesis/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/contract/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/healthinsurance/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/modality/").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/checking/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/register-appointment/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/patient/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/responsible/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/prontuario/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/session/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/shedule/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/therapy/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/team/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/user/**").hasAnyRole(ADMIN, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/anamnesis/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/contract/**").denyAll()
                        .requestMatchers(HttpMethod.GET, "/api/healthinsurance/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/service-package/**").hasAnyRole(ADMIN)
                        .requestMatchers(HttpMethod.POST, "/api/modality/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.GET, "/api/service-package/**").hasAnyRole(ADMIN)
                        .requestMatchers(HttpMethod.POST, "/api/checking/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/register-appointment/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/healthinsurance/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/patient/**").hasAnyRole( RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/responsible/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/prontuario/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/session/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/shedule/**").hasAnyRole(ADMIN,AUXILIAR, TERAPEUTA, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/therapy/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/team/**").hasAnyRole(ADMIN,AUXILIAR, RECEPCIONISTA)
                        .requestMatchers(HttpMethod.POST, "/api/user/**").hasAnyRole(ADMIN, TERAPEUTA, RECEPCIONISTA)
                        .anyRequest().authenticated());

        http.sessionManagement(sess -> sess.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS));
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtConverter)));

        return http.build();

        /*
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/**").hasRole("ADMIN") // Exige ROLE_ADMIN
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter()))
                );
        return http.build();
*/

    }

    @Bean
    public Converter<Jwt, AbstractAuthenticationToken> jwtAuthenticationConverter() {
        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
        jwtConverter.setJwtGrantedAuthoritiesConverter(jwt -> {
            Map<String, Object> realmAccess = jwt.getClaim("realm_access");
            if (realmAccess == null || !realmAccess.containsKey("roles")) {
                return List.of();
            }
            List<String> roles = (List<String>) realmAccess.get("roles");
            return roles.stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList());
        });
        return jwtConverter;
    }
}