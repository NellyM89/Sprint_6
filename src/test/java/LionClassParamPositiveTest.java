import com.example.Feline;
import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionClassParamPositiveTest {

    private final String sex;
    private final boolean expected;
    Feline feline = new Feline();

    public LionClassParamPositiveTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void createLionMaleTest() throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    public void createLionInvalidSexTest() throws Exception {
        String invalidSex = "Неизвестный пол";
        assertThrows(Exception.class, () -> {
            Lion lion = new Lion(invalidSex, feline);
        });
    }
}
