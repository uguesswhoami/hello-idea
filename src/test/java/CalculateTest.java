import com.junit.calc.Calculate;
import junit.framework.Assert;
import org.junit.Test;

public class CalculateTest{


    Calculate calc = new Calculate();
    int sum = calc.sum(2, 8);
    int testSum = 7;

    @Test
    public  void testSum(){
        System.out.println("@test sum" + sum + "=" +testSum);

        Assert.assertEquals(testSum, sum);
    }

}