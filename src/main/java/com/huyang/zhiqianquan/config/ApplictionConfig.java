//package com.huyang.zhiqianquan.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.nio.charset.Charset;
//import java.util.List;
//
//@Configuration
//public class ApplictionConfig implements WebMvcConfigurer {
//
//    @Bean
//    public  RedisTemplate<String,Object>  redisTemplate(RedisConnectionFactory connectionFactory){
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
//        redisTemplate.setConnectionFactory(connectionFactory);
//        StringRedisSerializer stringRedisSerializer =new StringRedisSerializer();
//        JdkSerializationRedisSerializer jdkSerializer =new JdkSerializationRedisSerializer();
//        redisTemplate.setKeySerializer(stringRedisSerializer);
//        redisTemplate.setValueSerializer(jdkSerializer);
//        redisTemplate.setHashKeySerializer(stringRedisSerializer);
//        redisTemplate.setHashValueSerializer(jdkSerializer);
//        return  redisTemplate;
//    }
//
//    @Bean
//    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(factory);
//        return stringRedisTemplate;
//    }
//
////    @Bean
////    public AtuchInterceptor atuchInterceptor(){
////        return new AtuchInterceptor();
////    }
////
////    @Override
////    public  void addInterceptors(InterceptorRegistry  registry){
////        registry.addInterceptor(atuchInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/login","/api/logout");
////    }
//    @Bean
//    public HttpMessageConverter<String> responseBodyConverter() {
//        StringHttpMessageConverter converter = new StringHttpMessageConverter(
//                Charset.forName("UTF-8"));
//        return converter;
//    }
//
//    @Override
//    public void configureMessageConverters(
//            List<HttpMessageConverter<?>> converters) {
//        WebMvcConfigurer.super.configureMessageConverters(converters);
//        converters.add(responseBodyConverter());
//    }
//
//    @Override
//    public void configureContentNegotiation(
//            ContentNegotiationConfigurer configurer) {
//        configurer.favorPathExtension(false);
//    }
//
//}
