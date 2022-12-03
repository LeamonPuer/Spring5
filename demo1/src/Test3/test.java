package Test3;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author Lemon
 * @create 2022-11-06-19:57
 */
public class test {

    @Test
    public void test1(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bs = ac.getBean("bookService", BookService.class);
        bs.add(new Book(1,"java",new BigDecimal(25)));
//        System.out.println(bs.countBook());
        System.out.println(bs.getBook(1));
        bs.update(new Book(1,"12",new BigDecimal(15)));
        System.out.println(bs.getAllBook());
        bs.delete(1);
    }
    @Test
    public void test2(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean1.xml");
        BookService bs = ac.getBean("bookService", BookService.class);
        List<Object[]> list=new ArrayList<>();
        Object[] obj=null;
        for(int i=0;i<100;i++){
            obj=new Object[]{i+504};
            list.add(obj);
        }
//        bs.batchAdd(list);
//        bs.batchUpdate(list);
        bs.batchDelete(list);
    }
    @Test
    public void test3(){
        int[] ints=new int[]{1,1,2,1,2,1};
        String[] s=new String[]{"1","2","3"};
        System.out.println(Arrays.asList(s));
        System.out.println(Arrays.stream(ints).boxed().collect(Collectors.toList()));
    }
    @Test
    public void test4(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(Config.class);
        BookService bs = ac.getBean("bookService", BookService.class);
//        bs.change();
        List<Book> allBook = bs.getAllBook();
        allBook.forEach(System.out::println);
    }
    //函数式风格创建对象，交给 spring 进行管理
    @Test
    public void testGenericApplicationContext() {
        //1 创建 GenericApplicationContext 对象
        GenericApplicationContext context = new GenericApplicationContext();
        //2 调用 context 的方法对象注册
        context.refresh();
//        context.registerBean("book1",Book.class, Book::new);
        context.registerBean(Book.class);
        //3 获取在 spring 注册的对象
         Book book = (Book)context.getBean("Test3.Book");
//        Book book = (Book)context.getBean("book1");
        System.out.println(book);
    }
}
