import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;

public class CalculatorTest
{
    @Test
    public void convertToPostfixTest()
    {
        String actual = Calculator.convertToPostfix("a*b/(c-a)+d*e");
        String expected = "ab*ca-/de*+";
        assertEquals(expected, actual);
    }

    @Test
    public void evaluatePostfix()
    {
        int actual = Calculator.evaluatePostfix("23*42-/56*+");
        int expected = 33;
        assertEquals(expected, actual);
    }

}