package aTest;

import org.springframework.stereotype.Component;

/**
 * @author Lemon
 * @create 2022-11-05-10:31
 */
@Component  //<bean id="userDaoImpl" class=".."/>
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("add...");
    }
}
