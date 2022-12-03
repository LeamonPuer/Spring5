package Test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Lemon
 * @create 2022-11-04-10:46
 */
public class test {
    @Test
    public void test1() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        Person person = ac.getBean("person", Person.class);
        System.out.println(person);
    }
//    @Test
//    public void test2(){
//        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
//        UserService userService = ac.getBean("userService", UserService.class);
//        userService.add();
//    }
    @Test
    public void test3(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        Stu stu = ac.getBean("stu", Stu.class);
        System.out.println(stu);
    }
    @Test
    public void test4(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        Book book = ac.getBean("book", Book.class);
        System.out.println(book);
    }
}
