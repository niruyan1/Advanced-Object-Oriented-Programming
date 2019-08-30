package eecs2030.lab7;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * A utility class containing methods to compute Fibonacci numbers.
 * 
 * @author EECS2030 Fall 2016-17
 *
 */
public class Fibonacci {
    
    private Fibonacci() {
        // empty by design
    }
    
  private static Map<Integer, BigInteger> cache = new HashMap<Integer, BigInteger>();
  
  /**
   * Memoized recursive implementation for computing Fibonacci numbers.
   * This method will fail for modest values of n because of limits
   * on the size of the call stack memory.
   * 
   * @param n which Fibonacci number to compute 
   * @return the value of F(n)
   */
  public static BigInteger fib(int n) {
    BigInteger sum = null;
    if (n == 0) {
      sum = BigInteger.ZERO;
    }
    else if (n == 1) {
      sum = BigInteger.ONE;
    }
    else if (cache.containsKey(n)) {
      sum = cache.get(n); 
    }
    else {
      BigInteger fMinus1 = Fibonacci.fib(n - 1);
      BigInteger fMinus2 = Fibonacci.fib(n - 2);
      sum = fMinus1.add(fMinus2);
      cache.put(n, sum);
    }
    return sum;
  }
  
  
  /**
   * Memoized iterative implementation for computing Fibonacci numbers
   * using an explicit call stack and simulated stack frames.
   * 
   * @param n which Fibonacci number to compute 
   * @return the value of F(n)
   */
  public static BigInteger fib2(int n) {
    Stack<FibonacciStackFrame> callStack = new Stack<FibonacciStackFrame>();
    
    FibonacciStackFrame f = new FibonacciStackFrame(n, null);
    callStack.push(f);
    while (!callStack.isEmpty()) {
      f = callStack.peek();
      f.execute(callStack);
    }
    return f.getReturnValue();
  }
  
  public static void main(String[] args) {
      System.out.println("F(10000) = " + Fibonacci.fib2(10000));
  }

}