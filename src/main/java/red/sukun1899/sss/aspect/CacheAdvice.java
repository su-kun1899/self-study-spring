package red.sukun1899.sss.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import red.sukun1899.sss.config.CacheConfigration;

@Aspect
@Component
public class CacheAdvice {
  private static final Logger LOGGER = LoggerFactory.getLogger(CacheAdvice.class);

  private CacheConfigration.CacheStoreMap<String, Object> cacheStoreMap;

  @Autowired
  public CacheAdvice(CacheConfigration.CacheStoreMap<String, Object> cacheStoreMap) {
    this.cacheStoreMap = cacheStoreMap;
  }

  @Around(value = "red.sukun1899.sss.aspect.RepositoryPointCut.findByAuthor(author)")
  public Object cacheFind(ProceedingJoinPoint proceedingJoinPoint, String author) throws Throwable {
    LOGGER.info("getSignature().toLongString()  "+proceedingJoinPoint.getSignature().toLongString());
    if (getCacheStoreMap().containsKey(author)) {
      LOGGER.info("Cache hit");
      return getCacheStoreMap().get(author);
    }

    LOGGER.info("Cache miss");
    Object returnValue = proceedingJoinPoint.proceed();
    getCacheStoreMap().put(author, returnValue);

    return returnValue;
  }

  public CacheConfigration.CacheStoreMap<String, Object> getCacheStoreMap() {
    return cacheStoreMap;
  }
}
