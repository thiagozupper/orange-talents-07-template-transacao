package br.com.zupacademy.thiago.transacao.infra;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

    //Configurações de autorização
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests(authorizeRequests ->
        {
            try {
                authorizeRequests
                        .antMatchers(HttpMethod.GET, "/api/transacoes/**").hasAuthority("SCOPE_transacao")
                        .anyRequest().authenticated()
                        .and().csrf().disable()
                        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }
}
