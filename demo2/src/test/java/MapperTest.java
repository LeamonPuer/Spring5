import com.github.pagehelper.PageHelper;
import com.mapper.DeptMapper;
import com.mapper.EmpMapper;
import com.pojo.Emp;
import com.pojo.EmpExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-11-24-14:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Spring.xml"})
public class MapperTest {
    @Autowired
    EmpMapper empMapper;
    @Test
    public void test(){
        PageHelper.startPage(1,5);
        EmpExample ee=new EmpExample();
        ee.createCriteria().andIdLessThan(150);
        List<Emp> emps = empMapper.selectByExample(ee);
        emps.forEach(System.out::println);
    }
}
