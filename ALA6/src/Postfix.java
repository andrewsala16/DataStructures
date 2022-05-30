import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public static void main(String[] args) {
        Stack<Integer> postfixStack = new Stack<>();
        Scanner keyboard = new Scanner(System.in);
        String answer;
        do {
            try {
                System.out.println("Enter a postfix expression");
                String postfix = keyboard.nextLine();
                String[] tokens = postfix.split(" ");
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i].matches("\\d{1,}")) {
                        postfixStack.push(Integer.parseInt(tokens[i]));
                    } else {
                        int op1 = postfixStack.pop();
                        int op2 = postfixStack.pop();
                        switch (tokens[i]) {
                            case "+":
                                postfixStack.push(op2 + op1);
                                break;
                            case "-":
                                postfixStack.push(op2 - op1);
                                break;
                            case "*":
                                postfixStack.push(op2 * op1);
                                break;
                            case "/":
                                postfixStack.push(op2 / op1);
                                break;
                            default:
                                System.out.println("Invalid operation");
                        }
                    }
                }
                int result = postfixStack.pop();
                if (postfixStack.isEmpty()) {
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Malformed expression");
                }
            }
            catch (EmptyStackException e){
                System.out.println("Malformed expression");
            }
            System.out.println("Do you want to evaluate another expression (Y/N)");
            answer = keyboard.nextLine();
            postfixStack.clear();
        }while(answer.equalsIgnoreCase("Y"));
    }
}
