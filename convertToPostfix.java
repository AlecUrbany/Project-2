import java.util.Stack;
 
public interface convertToPostfix extends StackInterface<T>
{
     
    
    public static int operands(char operators)
    {
        //switch statement to give 'priority' (values) to the different symbols via PEMDAS
        switch (operators)
        {
            //each case represents a different math operation with a priority value to be returned
            case '+':
            case '-':
                return 1;
        
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        //if no operations are being used, the system will return -1, an integer that should let it know that there's nothing to do. It's a buffer
        return -1;
    }
    public static String infixToPostfix(String exp)
    {
        // creating a string that will give you the result
        String result = new String("");
         
        // Create empty stack
        Stack<T> stack = new Stack<>();
         
        for (int i = 0; i < exp.length(); ++i)
        {
            char character = exp.charAt(i);
             
            //If statement to check for whether the input is alphabetical or numerical,returns true if either is the case, false if it isnt
            if (T.isLetterOrDigit(character))
            {
                result += character;
            }
            // If there is an open parenthesis in the equation, we put it in the stack 
            else if (character == '(')
            {
                stack.push(character);
            }
            //  If there is a closed parenthesis, the parenthsis is popped as it looks for another open parenthesis 
            else if (character == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                {
                    result += stack.pop();
                 
                    stack.pop();
                }
            }
            else // else statement to account for anything not specified in the first 3 statements
            {
                while (!stack.isEmpty() && operands(character) <= operands(stack.peek()))
                {   
                   //character operand that remains inside the stack is cycled thruough this until the expression becomes false
                    result += stack.pop();
                }
                //once it is false it puts the character onto the stack and puts it at the end 
                stack.push(character);
            }
      
        }
      
        // delete operators in stack
        while (!stack.isEmpty())
        {
            if(stack.peek() == '(')
                return "Don't use that character, dummy";
            result += stack.pop();
         }
        return result;
    }
   

}