package Test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-11-06-19:15
 */
@Service
public class BookService {
    @Autowired
    private BookDao bd;
    //添加图书
    public void add(Book book){
        bd.addBook(book);
    }
    //删除图书
    public void delete(int id){
        bd.deleteBook(id);
    }
    //修改图书
    public void update(Book book) {
        bd.updateBook(book);
    }
    //查询图书个数
    public int countBook(){
        return bd.countAll();
    }
    //通过id查询图书
    public Book getBook(int id) {
        return bd.findBook(id);
    }
    //查询全部图书
    public List<Book> getAllBook() {
        return bd.findAllBook();
    }
    //批量添加
    public void batchAdd(List<Object[]> args) {
        bd.batchAdd(args);
    }
    //批量修改
    public void batchUpdate(List<Object[]> args){
        bd.batchUpdate(args);
    }
    //批量删除
    public void batchDelete(List<Object[]> args){
        bd.batchDelete(args);
    }
    //修改单价
    @Transactional(propagation = Propagation.REQUIRED)
    public void change(){
        bd.decline();
        int i=12/0;
        bd.increase();
    }
}
