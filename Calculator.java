

public class Calculator
{

    public static void main(String[] args)
    {       
        // This will input a numerical post fix expression into our evaluator. Then, it will print the answer 
        String postfix = "23*42-/56*+";
        System.out.println(evaluatePostfix(postfix));

        // This will input a infix expression that will then be converted to post fix.
        String infixExample = ("a*b/(c-a)+d*e");
        System.out.println(convertToPostfix(infixExample));


    }

    public static int evaluatePostfix(String expression)
    {
        // Setting up a new stack via a ResizeableArray. Also setting up the character, current. 
        ResizeableArrayStack<Integer> valueStack = new ResizeableArrayStack<Integer>();
        char current;
        
        // Setting up for loop that will increment the array so long as it's smaller than the length of the expression
        for (int i = 0; i < expression.length(); i++)
        {
            // Setting up the expression to read each character incrementally
            current = expression.charAt(i);
            // if statement checks to see if the current character is a digit.
            // If it is a digit, we will push the character and parse a value
            if (Character.isDigit(current))
            {
                valueStack.push(Character.getNumericValue(current));
            }
            // Other than that, we are looking for special math characters
            else
            {
                // We get operand one and two from what's getting popped out of the value stack
                // popping of course removes the top of the stack. Popping twice will remove two numbers, and give us two operands.
                int operandTwo = valueStack.pop();
                int operandOne = valueStack.pop();
                switch (current)
                {
                    // each case represents a comparison to check for the operator. Once it finds a match, it executes the operator.
                    // After the execution, the switch 'breaks' and the sequence escapes
                    case '+':
                        valueStack.push(operandOne + operandTwo);
                        break;
                    case '-':
                        valueStack.push(operandOne - operandTwo);
                        break;
                    case '*':
                        valueStack.push(operandOne * operandTwo);
                        break;
                    case '/':
                        valueStack.push(operandOne / operandTwo);
                        break;
                    // Accounts for exponents via Math.pow, casts the command with an int so it can actually read.
                    case '^':
                        valueStack.push((int) Math.pow(operandOne, operandTwo));
                        break;
                }
            }
        }
        
        return valueStack.peek();
    }

    public static int operands(char operators)
    {
        //switch statement to give 'priority' (values) to the different symbols via PEMDAS
        switch (operators)
        {
            //each case represents a different math operation with a priority value to be returned
            case '+':
                return 1;
            case '-':
                return 1;
        
            case '*':
                return 2;
            case '/':
                return 2;
            case '^':
                return 3;
        }
        //if no operations are being used, the system will return -1, an integer that should let it know that there's nothing to do. It's a buffer
        return -1;
    }

    public static String convertToPostfix(String exp)
    {
        // creating a string that will give you the result
        String result =new String("");
         
        // Create empty stack
        LinkedStack<Character> stack = new LinkedStack<>();
         
        for (int i = 0; i < exp.length(); ++i)
        {
            char character = exp.charAt(i);
             
            // If there is an open parenthesis in the equation, we put it in the stack 
            if (character == '(')
            {
                stack.push(character);
            }
            //  If there is a closed parenthesis, the parenthsis is popped as it looks for another open parenthesis 
            else if (character == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                {
                    result += stack.pop();
                }
            }
            else // else statement to account for anything not specified in the first 3 statements
            {
                while (!stack.isEmpty() && (operands(character) <= operands(stack.peek())))
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