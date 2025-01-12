package com.algo.data_structure.stack;

/******************************************************************************
 * Compilation: javac Evaluate.java Execution: java Evaluate Dependencies: Stack.java
 *
 * Evaluates (fully parenthesized) arithmetic expressions using Dijkstra's two-stack algorithm.
 *
 * % java Evaluate ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) 101.0
 *
 * % java Evaulate ( ( 1 + sqrt ( 5 ) ) / 2.0 ) 1.618033988749895
 *
 *
 *
 * Remarkably, Dijkstra's algorithm computes the same answer if we put each operator *after* its two
 * operands instead of *between* them.
 *
 * % java Evaluate ( 1 ( ( 2 3 + ) ( 4 5 * ) * ) + ) 101.0
 *
 * Moreover, in such expressions, all parentheses are redundant! Removing them yields an expression
 * known as a postfix expression. 1 2 3 + 4 5 * * +
 *
 *
 ******************************************************************************/

import com.algo.algorithm.util.Stack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Evaluate_DijkstraTwoStack {

    public static void main(String[] args) throws IOException {
        String currentPath = new File(".").getCanonicalPath();
        String fileName = currentPath + "/src/cs/Evaluate";
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        while (sc.hasNext()) { // Read token, push if operator.
            String s = sc.next();
            if (s.equals("("))
                ;
            else if (s.equals("+"))
                ops.push(s);
            else if (s.equals("-"))
                ops.push(s);
            else if (s.equals("*"))
                ops.push(s);
            else if (s.equals("/"))
                ops.push(s);
            else if (s.equals("sqrt"))
                ops.push(s);
            else if (s.equals(")")) { // Pop, evaluate, and push result if token is ")".
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+"))
                    v = vals.pop() + v;
                else if (op.equals("-"))
                    v = vals.pop() - v;
                else if (op.equals("*"))
                    v = vals.pop() * v;
                else if (op.equals("/"))
                    v = vals.pop() / v;
                else if (op.equals("sqrt"))
                    v = Math.sqrt(v);
                vals.push(v);
            } // Token not operator or paren: push double value.
            else
                vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}
