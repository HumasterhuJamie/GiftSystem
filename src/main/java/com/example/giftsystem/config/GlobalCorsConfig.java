package com.example.giftsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfig {
	
	@Bean
    public CorsFilter corsFilter() {
        //1.添加CORS配置
        CorsConfiguration config = new CorsConfiguration();
          config.addAllowedOrigin("*");
          config.setAllowCredentials(true);
          config.addAllowedMethod("*");
          config.addAllowedHeader("*");
          // config.addExposedHeader("*");
          config.addExposedHeader("Content-Type");
          config.addExposedHeader( "X-Requested-With");
          config.addExposedHeader("accept");
          config.addExposedHeader("Origin");
          config.addExposedHeader( "Access-Control-Request-Method");
          config.addExposedHeader("Access-Control-Request-Headers");

        //2.添加映射路径
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }
	
	

}
