package Test3;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-11-06-19:15
 */
public interface BookDao {
    //添加图书
    public void addBook(Book book);
    //删除图书
    public void deleteBook(int id);
    //修改图书
    public void updateBook(Book book);
    //查询图书个数
    public int countAll();
    //通过id查询图书
    public Book findBook(int id);
    //查询全部图书
    public List<Book> findAllBook();
    //批量添加
    public void batchAdd(List<Object[]> args);
    //批量修改
    public void batchUpdate(List<Object[]> args);
    //批量删除
    public void batchDelete(List<Object[]> args);
    //增加单价
    void increase();
    //减少单价
    void decline();
}
