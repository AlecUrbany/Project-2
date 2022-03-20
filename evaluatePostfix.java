public class evaluatePostfix 
{
    Algorithm evaluatePostfix(postfix)
// Evaluates a postfix expression.
valueStack = a new empty stack
while (postfix has characters left to parse)
{
nextCharacter = next nonblank character of postfix
switch (nextCharacter)
{
case variable:
valueStack.push(value of the variable nextCharacter)
break
case '+' : case '-' : case '*' : case '/' : case '^' :
operandTwo = valueStack.pop()
operandOne = valueStack.pop()
result = the result of the operation in nextCharacter and its operands
operandOne and operandTwo
valueStack.push(result)
break
default: break // Ignore unexpected characters
}
}
return valueStack.peek()
    
}
