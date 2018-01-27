import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by RuiClear on 2018/1/26.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        try {
            Method method = Animal.class.getMethod("doSomething",null);
            Annotation annotation = method.getAnnotation(MyAnnotation.class);
           if(annotation!=null){
               System.out.println(((MyAnnotation)annotation).value());
           }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
