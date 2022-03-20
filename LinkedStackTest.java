import java.util.EmptyStackException;
import javax.swing.JOptionPane;
/**
    A class of stacks whose entries are stored in a chain of nodes.
    @author Frank M. Carrano and Timothy M. Henry
    @version 5.0
*/
public final class LinkedStackTest
{
   public static void main(String[] args)
   {
      // If you uncomment the below code, then it allows you to have user input to test other equations.
      //  String infix = JOptionPane.showInputDialog("Please input your equation you'd like to convert:");
      //  System.out.println(infixToPostfix(infix));
       String infixExample = ("a*b/(c-a)+d*e");
       System.out.println(infixToPostfix("Here's the infix expression from Task 1 as a postfix " + infixExample));
   }
}