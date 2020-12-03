package com.wind.framework.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：激活spring boot自带的缓存功能
 * 如果使用 shiro 的缓存功能, 可以将其功能关闭
 *
 * @auther: zjf
 * @sine: 1.0
 */
//@Configuration
@EnableCaching
public class CacheConfig {
}
