package aTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author Lemon
 * @create 2022-11-06-9:39
 */
public class Test1 {
    @Test
    public void test(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean1.xml");
        UserDao di = ac.getBean("userDaoImpl", UserDao.class);
        di.add();
    }
    @Test
    public void test1(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean1.xml");
        UserService us = ac.getBean("userService", UserService.class);
        us.add();
    }
    @Test
    public void test2(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("bean1.xml");
        Book book = ac.getBean("book", Book.class);
        book.buy();
    }
}
