package Test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-11-06-19:15
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jt;

    @Override
    public void addBook(Book book) {
        String sql="insert into book values(?,?,?)";
        int update = jt.update(sql,1, book.getName(), book.getPrice());
        System.out.println(update);
    }

    @Override
    public void deleteBook(int id) {
        String sql="delete from book where id=?";
        int update = jt.update(sql, id);
        System.out.println(update);
    }

    @Override
    public void updateBook(Book book) {
        String sql="update book set name=?,price=? where id=?";
        int update = jt.update(sql, book.getName(), book.getPrice(),book.getId());
        System.out.println(update);
    }

    @Override
    public int countAll() {
        String sql="select count(*) from book";
        Integer count = jt.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public Book findBook(int id) {
        String sql="select * from book where id=?";
        return jt.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }

    @Override
    public List<Book> findAllBook() {
        String sql="select * from book";
        return jt.query(sql,new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public void batchAdd(List<Object[]> args) {
        String sql="insert into book(name,price) values(?,?)";
        jt.batchUpdate(sql, args);
    }

    @Override
    public void batchUpdate(List<Object[]> args) {
        String sql="update book set name=?,price=? where id=?";
        jt.batchUpdate(sql, args);
    }

    @Override
    public void batchDelete(List<Object[]> args) {
        String sql="delete from book where id=?";
        jt.batchUpdate(sql,args);
    }

    @Override
    public void increase() {
        String sql="update book set price=price+10 where name='java'";
        jt.update(sql);
    }

    @Override
    public void decline() {
        String sql="update book set price=price-10 where name='c'";
        jt.update(sql);
    }
}
