/**
*@author Alec Urbany
*@author Nasser Alnabulsi
*@version 1.00
*/
public class Calculator
{

    
    
    /** 
     * @param args
     */
    public static void main(String[] args)
    {       
        // This will input a numerical post fix expression into our evaluator. Then, it will print the answer 
        String postfix = "23*42-/56*+";
        System.out.println(evaluatePostfix(postfix));

        // This will input a infix expression that will then be converted to post fix.
        String infixExample = "a*b/(c-a)+d*e";
        System.out.println(convertToPostfix(infixExample));


    }

    
    /** 
     * @param evaluatePostfix takes the postfix and calculates the value and returns it as an answer
     * @return answer to postfix equation
     */
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

    
    /** 
     * @param operands- gives priority to the current operators and what is higher on the list 
     * @return priority numbers and stores them for sorting
     */
    public static int operands(char operators)
    {
        //switch statement to give 'priority' (values) to the different symbols via PEMDAS
        switch (operators)
        {
            //each case represents a different math operation with a priority value to be returned
            case '+':
            case '-':
                return 0;
        
            case '/':
            case '*':
                return 1;
            case '^':
                return 2;
                
        }
        //if no operations are being used, the system will return -1, an integer that should let it know that there's nothing to do. It's a buffer
        return -1;
    }

    
    /** 
     * @param convertToPostFix a code to convert infix to postfix
     * @return the postfix of the infix statement/equation inputted
     */
    public static String convertToPostfix(String expression)
    {
        // creating a blank string that will give you the result
        String result =new String("");
         
        // Create empty stack
        LinkedStack<Character> stack = new LinkedStack<>();

        // This is the character that we will be parsing from the expression
        char character;
         
        // This for loop  will increment as we traverse through the stack
        for (int i = 0; i < expression.length(); ++i)
        {
            character = expression.charAt(i);
             
            // If there is a character in the expression, it is added to the result
            if (Character.isLetter(character))
            {
                result += character;
            }


            else if (character == '(')
            {
                stack.push(character);

            }
            //  If there is a closed parenthesis, the parenthsis is popped and it adds anything between it and the open parenthesis.
            else if (character == ')')
            {
                while (!stack.isEmpty() && stack.peek() != ')')
                { 
                    //This is a nightmare, it took us an hour of trouble shooting to realize that we needed an if and an else if statement
                    //This stupid series of if statements prevents the code from leaving in an extra '('
                    //That's it. And it took us an hour to figure that out.
                    if (stack.peek() != '(')
                    {
                    result += stack.pop();
                    }
                    else if (stack.peek() == '(')
                    {
                    stack.pop();
                    }
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
      
        // delete any stray operators in stack
        while (!stack.isEmpty())
        {
            if (stack.peek() == '(')
                {
                return "You used one too many open parenthesis, dummy";
                }
            result += stack.pop();
        }
        // Will return the statement we've been working so hard to cultivate to the terminal.
        return result;
    }



}