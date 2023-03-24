import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionClassParamNegativeTest {

    private final String sex;
    Feline feline = new Feline();

    public LionClassParamNegativeTest(String sex) {

        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[] getSexData() {
        return new Object[]{
                "Оно"
        };
    }

    @Test(expected = Exception.class)
    public void createLionInvalidSexTest() throws Exception {
        Lion lion = new Lion(sex, feline);
    }
}
