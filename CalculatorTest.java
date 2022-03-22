//import org.junit.Test;
import java.util.EmptyStackException;

public class CalculatorTest
{
    
    /** 
     * @param args
     */
    public static void main(String[] args)
    {       
        // This are will test our code's ability to convert a infix to a postfix equation
        String anotherTestString = "a*b/(c-a)+d*e";
        String answer = Calculator.convertToPostfix(anotherTestString);
        String actualAnswer = "ab*ca-/de*+";
        System.out.println("The answer we should have gotten is: " + actualAnswer + "\nThe answer we actually got is: " + answer + "\n");
        
        // This area will test our code's ability to evaluate a postfix equation.
        String testString = "23*42-/56*+";
        int result = Calculator.evaluatePostfix(testString);
        int realResult = 33;
        System.out.println("The answer we should have gotten is: " + realResult + "\nThe answer we actually got is: " + result + "\n");
    }
}