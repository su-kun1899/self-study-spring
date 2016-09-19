package red.sukun1899.sss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class CacheConfigration {
  public static class CacheStoreMap<K, V> extends ConcurrentHashMap<K, V> {
  }

  @Bean
  public CacheStoreMap<String, Object> cacheStoreMap() {
    return new CacheStoreMap<>();
  }

}
