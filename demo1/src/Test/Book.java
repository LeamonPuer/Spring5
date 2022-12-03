package Test;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-11-05-13:14
 */
public class Book {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Book{" +
                "list=" + list +
                '}';
    }
}
