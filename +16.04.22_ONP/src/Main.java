/**
 * started April 22, 2016
 * complete April 22, 2016
 * from http://www.spoj.com/problems/ONP
 *
 * Transform the algebraic expression with brackets into RPN form (Reverse Polish Notation).
 * Two-argument operators: +, -, *, /, ^ (priority from the lowest to the highest), brackets ( ).
 * Operands: only letters: a,b,...,z. Assume that there is only one RPN form (no expressions like a*b*c).
 */

import java.util.*;
import java.lang.*;

class Main
{
    static HashSet<Character> operators;

    public static void main (String[] args) throws java.lang.Exception
    {
        operators = new HashSet<>(Arrays.asList('+', '-', '*', '/', '^'));

        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        String expression;
        for(int i=0; i<tests; i++){

            expression = sc.next();

            System.out.println(toRPN(expression));
        }
    }

    private static String toRPN(String expression) {

        StringBuilder outstring = new StringBuilder();
        Stack<Character> operators = new Stack<>();
        ArrayList<Character> output = new ArrayList<>();

        for(char c : expression.toCharArray()){

            if(isOperator(c)) operators.push(c);
            if(c == ')') output.add(operators.pop());
            if(Character.isLetter(c)) output.add(c);
        }

        for(char elt : output) outstring.append(elt);
        return outstring.toString();
    }

    private static boolean isOperator(Character input){

        if(operators.contains(input)) return true;
        return false;
    }
}