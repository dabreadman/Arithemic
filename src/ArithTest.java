import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Arith.java
 *
 *  @author  YI XIANG TAN aka dabreadman
 *  @version 31/01/2020 15:00:26
 */
@RunWith(JUnit4.class)
public class ArithTest {

	//~ Public Methods ........................................................
	 @Test
	    public void validatePrefixOrderTest() {
	        String[] empty = {};
	        String[] oneOperand = {"1"};
	        String[] oneOperator = {"/"};
	        String[] exceptedTrue1 = {"/", "1", "2"};
	        String[] exceptedTrue2 = {"/", "/", "/", "1", "2", "3", "4"};
	        String[] expressionectedFalse1 = {"/", "10", "0"};
	        String[] expressionectedFalse2 = {"+", "2", "3", "-", "4"};

	        assertTrue(Arith.validatePrefixOrder(empty));
	        assertTrue(Arith.validatePrefixOrder(oneOperand));
	        assertFalse(Arith.validatePrefixOrder(oneOperator));

	        assertTrue(Arith.validatePrefixOrder(exceptedTrue1));
	        assertTrue(Arith.validatePrefixOrder(exceptedTrue2));

	        assertFalse(Arith.validatePrefixOrder(expressionectedFalse1));
	        assertFalse(Arith.validatePrefixOrder(expressionectedFalse2));
	    }

	    @Test
	    public void validatePostfixOrderTest() {
	        String[] empty = {};
	        String[] oneOperand = {"1"};
	        String[] oneOperator = {"/"};
	        String[] exceptedTrue1 = {"1", "2", "+"};
	        String[] exceptedTrue2 = {"1", "2", "+", "3", "-", "4", "*"};
	        String[] expressionectedFalse1 = {"-", "*", "/", "1", "2", "3", "4", "-"};
	        String[] expressionectedFalse2 = {"+", "1", "2", "-", "3"};

	        assertTrue(Arith.validatePostfixOrder(empty));
	        assertTrue(Arith.validatePostfixOrder(oneOperand));
	        assertFalse(Arith.validatePostfixOrder(oneOperator));

	        assertTrue(Arith.validatePostfixOrder(exceptedTrue1));
	        assertTrue(Arith.validatePostfixOrder(exceptedTrue2));

	        assertFalse(Arith.validatePostfixOrder(expressionectedFalse1));
	        assertFalse(Arith.validatePostfixOrder(expressionectedFalse2));
	    }

	    @Test
	    public void evaluatePrefixOrderTest() {
	        String[] oneOperand = {"1"};
	        String[] exceptedTrue1 = {"+", "1", "2"};
	        String[] exceptedTrue2 = {"-", "*", "/", "2", "2", "3", "4"};

	        assertTrue(Arith.validatePrefixOrder(oneOperand));
	        assertTrue(Arith.validatePrefixOrder(exceptedTrue1));
	        assertTrue(Arith.validatePrefixOrder(exceptedTrue2));

	        assertEquals(1, Arith.evaluatePrefixOrder(oneOperand));
	        assertEquals(3, Arith.evaluatePrefixOrder(exceptedTrue1));
	        assertEquals(-1, Arith.evaluatePrefixOrder(exceptedTrue2));
	    }

	    @Test
	    public void evaluatePostfixOrderTest() {
	        String[] oneOperand = {"1"};
	        String[] exceptedTrue1 = {"1", "2", "+"};
	        String[] exceptedTrue2 = {"1", "2", "/", "3", "*", "4", "-"};
	        assertTrue(Arith.validatePostfixOrder(oneOperand));
	        assertTrue(Arith.validatePostfixOrder(exceptedTrue1));
	        assertTrue(Arith.validatePostfixOrder(exceptedTrue2));

	        assertEquals(1, Arith.evaluatePostfixOrder(oneOperand));
	        assertEquals(3, Arith.evaluatePostfixOrder(exceptedTrue1));
	        assertEquals(-4, Arith.evaluatePostfixOrder(exceptedTrue2));

	    }

	    @Test
	    public void convertPrefixToInfixTest() {
	        String[] oneOperand = {"1"};
	        String[] expression1 = {"1"};
	        String[] exceptedTrue1 = {"+", "1", "2"};
	        String[] expression2 = {"(", "1", "+", "2", ")"};
	        String[] exceptedTrue2 = {"-", "*", "/", "1", "2", "3", "4"};
	        String[] expression3 = {"(", "(", "(", "1", "/", "2", ")", "*", "3", ")", "-", "4", ")"};

	        assertArrayEquals(expression1, Arith.convertPrefixToInfix(oneOperand));
	        assertArrayEquals(expression2, Arith.convertPrefixToInfix(exceptedTrue1));
	        assertArrayEquals(expression3, Arith.convertPrefixToInfix(exceptedTrue2));
	    }

	    @Test
	    public void convertPostfixToInfixTest() {
	        String[] oneOperand = {"1"};
	        String[] expression1 = {"1"};
	        String[] exceptedTrue1 = {"1", "2", "+"};
	        String[] expression2 = {"(", "1", "+", "2", ")"};
	        String[] exceptedTrue2 = {"1", "2", "/", "3", "*", "4", "-"};
	        String[] expression3 = {"(", "(", "(", "1", "/", "2", ")", "*", "3", ")", "-", "4", ")"};

	        assertArrayEquals(expression1, Arith.convertPostfixToInfix(oneOperand));
	        assertArrayEquals(expression2, Arith.convertPostfixToInfix(exceptedTrue1));
	        assertArrayEquals(expression3, Arith.convertPostfixToInfix(exceptedTrue2));
	    }

	    @Test
	    public void convertPostfixToPrefix(){
	        String[] testExpression1 = {"1"};
	        String[] testExpression2 = {"1", "2", "+"};
	        String[] testExpression3 = {"1", "2", "/", "3", "*", "4", "-"};

	        String[] expression1 = {"1"};
	        String[] expression2 = {"+", "1", "2"};
	        String[] expression3 = {"-", "*", "/", "1", "2", "3", "4"};

	        assertArrayEquals(expression1, Arith.convertPostfixToPrefix(testExpression1));
	        assertArrayEquals(expression2, Arith.convertPostfixToPrefix(testExpression2));
	        assertArrayEquals(expression3, Arith.convertPostfixToPrefix(testExpression3));
	    }

	    @Test
	    public void convertPrefixToPostfix(){
	        String[] expression1 = {"1"};
	        String[] expression2 = {"1", "2", "+"};
	        String[] expression3 = {"1", "2", "/", "3", "*", "4", "-"};

	        String[] testExpression1 = {"1"};
	        String[] testExpression2 = {"+", "1", "2"};
	        String[] testExpression3 = {"-", "*", "/", "1", "2", "3", "4"};

	        assertArrayEquals(expression1, Arith.convertPrefixToPostfix(testExpression1));
	        assertArrayEquals(expression2, Arith.convertPrefixToPostfix(testExpression2));
	        assertArrayEquals(expression3, Arith.convertPrefixToPostfix(testExpression3));
	    }
	


}
