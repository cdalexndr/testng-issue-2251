package example;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class TestClass extends AbstractTestNGSpringContextTests {
    static class NullExObj {
        @Override public String toString() {
            throw new NullPointerException( "expected" );
        }
    }

    @Test(timeOut = 1000000) //removing timeout fixes error output
    public void testError() throws Exception {
        new NullExObj().toString();
    }
}
