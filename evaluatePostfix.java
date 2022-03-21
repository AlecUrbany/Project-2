public interface evaluatePostfix<T> extends StackInterface<T>
{

    public static int evalPost(String exp)
    {
        LinkedStack<character> stack = new LinkedStack<>();
        for (int i = 0; i< exp.length();i++)

            if (character == int)
            valueStack.push(operators - '0');
            
            else
            {
                int operandTwo = valueStack.pop();
                int operandOne = valueStack.pop();
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
    }





//     Algorithm evaluatePostfix(postfix) // Evaluates a postfix expression.
//     {
// valueStack = a new empty stack
// while (postfix has characters left to parse)
// {
// nextCharacter = next nonblank character of postfix
// switch (nextCharacter)
// {
// case variable:
// valueStack.push(value of the variable nextCharacter)
// break
// case '+' : case '-' : case '*' : case '/' : case '^' :
// operandTwo = valueStack.pop()
// operandOne = valueStack.pop()
// result = the result of the operation in nextCharacter and its operands
// operandOne and operandTwo
// valueStack.push(result)
// break
// default: break // Ignore unexpected characters
// }
// }
// return valueStack.peek()
//     }
// break
// default: break // Ignore unexpected characters
// }
// }
// return valueStack.peek()
//     }
// break
// default: break // Ignore unexpected characters
// }
// }
// return valueStack.peek()
//     }
}
