import com.maven.hello.Hello;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


public class TestHello extends TestCase{

    @Test
    public void test(){

        Assert.assertEquals("add error", 4, Hello.add(1, 2));
    }
}