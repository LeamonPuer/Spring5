package aTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Lemon
 * @create 2022-11-05-10:29
 */
@Service
public class UserService {
//    @Autowired
//    @Qualifier(value="userDaoImpl1")
    @Resource
    private UserDao userDao;

    public void add(){
        System.out.println("Service...");
        userDao.add();
    }
}
