package red.sukun1899.sss.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class RepositoryPointCut {
  @Pointcut("execution(* red.sukun1899.sss.repository..MemoRepository+.save(..))")
  public void save() {

  }
}
