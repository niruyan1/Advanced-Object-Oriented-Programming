package eecs2030.lab7;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Stack;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FibonacciStackFrameTest {

  @Test
  public void test01_constructor() {
    FibonacciStackFrame f = new FibonacciStackFrame(100, null);
    assertEquals("constructor failed to set this.n correctly", 100, f.getN());
    assertNull("constructor failed to set this.caller correctly", f.getCaller());
    BigInteger fMinus1 = f.getfMinus1();
    if (fMinus1 == null) {
        fail("constructor should set fMinus1 to zero");
    }
    else {
      assertTrue("constructor failed to set this.fMinus1 to zero",
          fMinus1.equals(BigInteger.ZERO));
    }
    BigInteger fMinus2 = f.getfMinus2();
    if (fMinus2 == null) {
        fail("constructor should set fMinus2 to zero");
    }
    else {
      assertTrue("constructor failed to set this.fMinus1 to zero",
          fMinus2.equals(BigInteger.ZERO));
    }
    BigInteger sum = f.getReturnValue();
    if (sum == null) {
        fail("constructor should set sum to zero");
    }
    else {
      assertTrue("constructor failed to set this.sum to zero",
          sum.equals(BigInteger.ZERO));
    }
    assertFalse("constructor failed to set this.fMinus1Computed to false",
            f.getfMinus1Computed());
    assertFalse("constructor failed to set this.fMinus2Computed to false",
            f.getfMinus2Computed());
  }
  
  private void checkState(FibonacciStackFrame f,
          BigInteger f1, BigInteger f2, BigInteger retVal, 
          boolean f1Computed, boolean f2Computed) {
      assertNotNull("this.fMinus1 should not be null", f1);
      assertNotNull("this.fMinus2 should not be null", f2);
      assertNotNull("this.sum should not be null", retVal);
      BigInteger fMinus1 = f.getfMinus1();
      BigInteger fMinus2 = f.getfMinus2();
      BigInteger ret = f.getReturnValue();
      boolean fMinus1Computed = f.getfMinus1Computed();
      boolean fMinus2Computed = f.getfMinus2Computed();
      assertEquals(f1, fMinus1);
      assertEquals(f2, fMinus2);
      assertEquals(ret, retVal);
      assertEquals(fMinus1Computed, f1Computed);
      assertEquals(fMinus2Computed, f2Computed);
  }

  @Test
  public void test02_constructorThrows() {
    try {
      FibonacciStackFrame f = new FibonacciStackFrame(-1, null);
      fail("constructor failed throw an exception");
    }
    catch (IllegalArgumentException x) {
      // ok, this exception is expected
    }
  }
  
  @Test
  public void testReceiveReturnValue() {
    FibonacciStackFrame f = new FibonacciStackFrame(100, null);
    f.receiveReturnValue(BigInteger.TEN);
    
    checkState(f, BigInteger.TEN, BigInteger.ZERO, BigInteger.ZERO, true, false);
    
    f.receiveReturnValue(BigInteger.TEN);
    checkState(f, BigInteger.TEN, BigInteger.TEN, BigInteger.ZERO, true, true);
  }
  
  @Test
  public void test03_receiveReturnValueThrows() {
    FibonacciStackFrame f = new FibonacciStackFrame(100, null);
    f.receiveReturnValue(BigInteger.ONE);
    checkState(f, BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, true, false);
    f.receiveReturnValue(BigInteger.ONE);
    checkState(f, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO, true, true);
    try {
      f.receiveReturnValue(BigInteger.ONE);
      fail("receiveReturnValue should have thrown an exception");
    }
    catch (IllegalStateException ex) {
      // ok, this exception is expected
    }
  }

  @Test
  public void test04_returnValueToCaller() {
    Stack<FibonacciStackFrame> callStack = new Stack<FibonacciStackFrame>();
    FibonacciStackFrame f1 = new FibonacciStackFrame(100, null);
    FibonacciStackFrame f2 = new FibonacciStackFrame(100, f1);
    callStack.push(f1);
    callStack.push(f2);
    f2.setSum(BigInteger.TEN);
    f2.returnValueToCaller(callStack);
    assertTrue("returnValueToCaller failed to call receiveReturnValue on this.caller?", 
        f2.getReturnValue().equals(f1.getfMinus1()));
    assertTrue("returnValueToCaller failed to pop the call stack correctly",
        callStack.peek() == f1);
  }

  @Test
  public void test05_getReturnValue() {
    // compute F(10000);
    BigInteger f[] = new BigInteger[10001];
    f[0] = BigInteger.ZERO;
    f[1] = BigInteger.ONE;
    for (int i = 2; i < f.length; i++) {
      f[i] = f[i - 1].add(f[i - 2]);
    }
    BigInteger got = Fibonacci.fib2(10000);
    assertEquals("", got, Fibonacci.fib2(10000));
  }

  @Test
  public void test06_execute() {
    Stack<FibonacciStackFrame> callStack = new Stack<FibonacciStackFrame>();
    FibonacciStackFrame f0 = new FibonacciStackFrame(0, null);
    callStack.push(f0);
    f0.execute(callStack);
    assertTrue("execute did not set this.sum correctly for F(0)",
        BigInteger.ZERO.equals(f0.getReturnValue()));
    assertTrue("execute did not invoke returnValueToCaller for F(0)", 
        callStack.isEmpty());
    
    FibonacciStackFrame f1 = new FibonacciStackFrame(1, null);
    callStack.push(f1);
    f1.execute(callStack);
    assertTrue("execute did not set this.sum correctly for F(1)",
        BigInteger.ONE.equals(f1.getReturnValue()));
    assertTrue("execute did not invoke returnValueToCaller for F(1)", 
        callStack.isEmpty());
    
    // must clear the cache before testing the next part
    FibonacciStackFrame.getCache().clear();
    
    FibonacciStackFrame f2 = new FibonacciStackFrame(2, null);
    callStack.push(f2);
    f2.execute(callStack);
    assertEquals("execute did not push a new frame for F(1) onto the call stack when executing F(2)",
        2, callStack.size());
    assertEquals("execute did not push a new frame for F(1) onto the call stack when executing F(2)",
        1, callStack.peek().getN());
    callStack.peek().execute(callStack);  // should pop F(1)
    callStack.peek().execute(callStack);  // should resume execution of F(2)
    assertEquals("execute did not push a new frame for F(0) onto the call stack when executing F(2)",
        2, callStack.size());
    assertEquals("execute did not push a new frame for F(0) onto the call stack when executing F(2)",
        0, callStack.peek().getN());
    callStack.peek().execute(callStack);  // should pop F(0)
    callStack.peek().execute(callStack);  // should complete execution of F(2)
    
    assertTrue("execute did not set this.sum correctly for F(2)",
        BigInteger.ONE.equals(f2.getReturnValue()));
    assertTrue("execute did not invoke returnValueToCaller for F(2)", 
        callStack.isEmpty());
    
    FibonacciStackFrame f2again = new FibonacciStackFrame(2, null);  // result should be in cache
    callStack.push(f2again);
    f2again.execute(callStack);
    assertTrue("execute did not set this.sum correctly for F(2)",
        BigInteger.ONE.equals(f2again.getReturnValue()));
    assertTrue("execute did not return the value of F(2) from the cache", 
        callStack.isEmpty());
  }

}