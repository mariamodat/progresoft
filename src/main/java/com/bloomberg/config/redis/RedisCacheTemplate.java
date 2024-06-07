package com.bloomberg.config.redis;

import com.bloomberg.entity.FXDeal;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisCacheTemplate extends CacheTemplate<String, FXDeal> {

    private final RedisTemplate<String, FXDeal> redisTemplate;

    @Override
    public FXDeal get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void put(String key, FXDeal value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void evict(String key) {
        redisTemplate.delete(key);
    }
}
