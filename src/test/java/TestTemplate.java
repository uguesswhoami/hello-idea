import com.xiaoke.pattern.study.template.Template;
import com.xiaoke.pattern.study.template.TemplateImpl;
import org.junit.Test;

public class TestTemplate{

    @Test
    public void testTemplate(){
        Template t = new TemplateImpl();
        t.template();

//        new Template(){
//
//            @Override
//            public void before(){
//                System.out.println("before2.");
//            }
//
//            @Override
//            public void execute(){
//                System.out.println("exe2.");
//            }
//
//            @Override
//            public void after(){
//                System.out.println("after2.");
//            }
//        }.template();
   }
}