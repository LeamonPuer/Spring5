package aTest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Lemon
 * @create 2022-11-06-14:17
 */
@Component
@Aspect
public class BookProxy {
    @Pointcut(value = "execution(* aTest.Book.buy(..))")
    public void demo() {
    }

    @Before(value = "demo()")
    public void beforeBuy() {
        System.out.println("beforeBuy...");
    }

    @Around(value = "execution(* aTest.Book.buy(..))")
    public void aroundBuy(ProceedingJoinPoint pj) throws Throwable {
        System.out.println("环绕之前.........");
        //被增强的方法执行
        pj.proceed();
        System.out.println("环绕之后.........");

    }

    @AfterReturning(value = "execution(* aTest.Book.buy(..))")
    public void arBuy() {
        System.out.println("arBuy...");
    }

}
