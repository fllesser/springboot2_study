package com.chowyijiu.redis.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.io.Serializable;


@Configuration
public class RedisConfig {

    @Resource
    private RedisTemplate<Serializable, Object> redisTemplate;

    //编写我们自己的RedisTemplate, 解决中文乱码问题
    @Bean
    public RedisTemplate<Serializable, Object> redisTemplateInit() {
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);

        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
        return redisTemplate;

//        RedisTemplate<Serializable, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(factory);
//        //json序列化
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//
//        //template.setDefaultSerializer(stringRedisSerializer);
//        //String 的序列化
//
//        template.setKeySerializer(stringRedisSerializer);
//        //hash的key也采用String的方式序列化
//        template.setHashKeySerializer(stringRedisSerializer);
//        //value序列化方式采用jackson
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        //hash 的 value序列化方式使用jackson
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
    }
}
