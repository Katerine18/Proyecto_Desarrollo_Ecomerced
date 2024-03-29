package com.Tienda_Proyecto;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {
    //Los siguientes 5 métodos son para trabajar la parte de internacionalización del sitio web

    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/inicio/listado");
        registry.addViewController("/Contactanos/Contactanos").setViewName("/Contactanos/Contactanos");
        registry.addViewController("/Noticias/Noticias").setViewName("/Noticias/Noticias");
        registry.addViewController("/producto/listado").setViewName("/producto/listado");
        registry.addViewController("/Login/login").setViewName("/Login/login");
        registry.addViewController("/Registro/Registro").setViewName("/Registro/Registro");
        registry.addViewController("/Reseñas/Reseñas").setViewName("Reseñas/Reseñas");
        registry.addViewController("/Juegos/Juegos").setViewName("/Juegos/Juegos");
        registry.addViewController("/login").setViewName("/login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
        //faltan de darles forma
        registry.addViewController("/Favoritos/FavoritosUsuario").setViewName("/Favoritos/FavoritosUsuario");

    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/","/index","/errores/**",
                        "/carrito/**","/pruebas/**","/reportes/**",
                        "/registro/**","/js/**","/webjars/**","/css/**","/Noticias/**",
                        "/layout/**", "/Noticias/**", "/templates/**", 
                        "/celular/**", "/monitor/**", "/Contactanos/**", 
                        "/Favoritos/**", "/Juegos/**", 
                        "/Login/**", "/layout/**", 
                        "/Resenas/**", "/categoria/**", 
                        "/inicio/**", "/producto/**", "/Registro/**",
                        "/logout/**")
                        .permitAll()
                .requestMatchers(
                        "/producto/nuevo","/producto/guardar",
                        "/producto/modificar/**","/producto/eliminar/**",
                        "/categoria/nuevo","/categoria/guardar",
                        "/categoria/modificar/**","/categoria/eliminar/**",
                        "/usuario/nuevo","/usuario/guardar",
                        "/usuario/modificar/**","/usuario/eliminar/**",
                        "/reportes/**"
                ).hasRole("ADMIN")
                .requestMatchers(
                        "/Celulares/listado",
                        "/producto/listado",
                        "/categoria/listado",
                        "/usuario/listado"
                ).hasAnyRole("ADMIN", "VENDEDOR")
                .requestMatchers("/facturar/carrito")
                .hasRole("USER")
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build)
            throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(
                new BCryptPasswordEncoder());
    }
    
}
