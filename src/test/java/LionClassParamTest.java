import com.example.Feline;
import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionClassParamTest {

    private final String sex;
    private final boolean expected;
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    Feline feline = new Feline();

    public LionClassParamTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Оно", false}
        };
    }

    @Test
    public void createLionMaleTest() throws Exception {
        try {
            Lion lion = new Lion(sex, feline);
            assertEquals(expected, lion.doesHaveMane());
        } catch (Exception error) {
            thrown.expect(Exception.class);
            thrown.expectMessage((equalTo("Используйте допустимые значения пола животного - самец или самка")));
            Lion lion = new Lion("Оно", feline);
            thrown = ExpectedException.none();
        }
    }
}