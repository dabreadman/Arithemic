// -------------------------------------------------------------------------
/**
 *  Utility class containing validation/evaluation/conversion operations
 *  for prefix and postfix arithmetic expressions.
 *
 *  @author  YI XIANG TAN aka dabreadman
 *  @version 31/01/2020 15:00:26
 */

public class Arith 
{


	//~ Validation methods ..........................................................


	/**
	 * Validation method for prefix notation.
	 *
	 * @param prefixLiterals : an array containing the string literals hopefully in prefix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return true if the parameter is indeed in prefix notation, and false otherwise.
	 **/
	public static boolean validatePrefixOrder(String prefixLiterals[])
	{
		int operators = 0;
		int operands = 0;
		int divide = 0;

		for(int i = 0 ; i < prefixLiterals.length ; i++) {
			//check if only matches digit
			if(prefixLiterals[i].matches("[0-9]+")) {
				if(operators<1) return false;
				if(divide == 1 && Integer.parseInt(prefixLiterals[i])==0) return false; 
				//division by 0
				else if(divide != 0) divide--;

				operands++;
				//two operands consume one operators
				if (operands >= 2) {
					//produce one operand
					operands -= (2-1);
					operators -= 1;
				}
			}

			//test if it is operator
			else if(prefixLiterals[i].matches("[*+-/]")) {
				operators++;

				//set flag for division
				if(prefixLiterals[i].charAt(0)=='/') divide = 2;

				//add one step for each other operators
				else if(divide != 0) divide ++;
			}
			//invalid input
			else return false;
		}

		return (operators == 0 && operands == 1);
	}


	/**
	 * Validation method for postfix notation.
	 *
	 * @param postfixLiterals : an array containing the string literals hopefully in postfix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return true if the parameter is indeed in postfix notation, and false otherwise.
	 **/
	public static boolean validatePostfixOrder(String postfixLiterals[])
	{
		int operators = 0;
		int operands = 0;
		int zero = 0;
		
		for(int i = 0 ; i < postfixLiterals.length ; i++) {
			//test if it is operator
			if(postfixLiterals[i].matches("[*+-/]")) {
				if(operands<2) return false;
				operators++;
				
				if(postfixLiterals[i].charAt(0)== '/' && zero == 1) {
					return false;
				}
				else if(zero!=0) zero++;
			
				//two operands consume one operators
				if (operands >= 2) {
					//produce one operand
					operands -= (2-1);
					operators -= 1;
				}
			}

			//check if only matches digit
			else if(postfixLiterals[i].matches("[0-9]+")) {
				operands++;
				if(Integer.parseInt(postfixLiterals[i]) == 0)	zero = 2;
				else zero--;
			}
			
			else return false;
		}
		
		return (operators == 0 && operands == 1);
	}


	//~ Evaluation  methods ..........................................................


	/**
	 * Evaluation method for prefix notation.
	 *
	 * @param prefixLiterals : an array containing the string literals in prefix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the integer result of evaluating the expression
	 **/
	public static int evaluatePrefixOrder(String prefixLiterals[])
	{
		//TODO
	}


	/**
	 * Evaluation method for postfix notation.
	 *
	 * @param postfixLiterals : an array containing the string literals in postfix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the integer result of evaluating the expression
	 **/
	public static int evaluatePostfixOrder(String postfixLiterals[])
	{
		//TODO
	}


	//~ Conversion  methods ..........................................................


	/**
	 * Converts prefix to postfix.
	 *
	 * @param prefixLiterals : an array containing the string literals in prefix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the expression in postfix order.
	 **/
	public static String[] convertPrefixToPostfix(String prefixLiterals[])
	{
		//TODO
	}


	/**
	 * Converts postfix to prefix.
	 *
	 * @param prefixLiterals : an array containing the string literals in postfix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the expression in prefix order.
	 **/
	public static String[] convertPostfixToPrefix(String postfixLiterals[])
	{
		//TODO
	}

	/**
	 * Converts prefix to infix.
	 *
	 * @param infixLiterals : an array containing the string literals in prefix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the expression in infix order.
	 **/
	public static String[] convertPrefixToInfix(String prefixLiterals[])
	{
		//TODO
	}

	/**
	 * Converts postfix to infix.
	 *
	 * @param infixLiterals : an array containing the string literals in postfix order.
	 * The method assumes that each of these literals can be one of:
	 * - "+", "-", "*", or "/"
	 * - or a valid string representation of an integer.
	 *
	 * @return the expression in infix order.
	 **/
	public static String[] convertPostfixToInfix(String postfixLiterals[])
	{
		//TODO
	}

	public static void main(String[]args) {
		int [] test = new int[] {1,2,3};
		String[] str = new String[]{ "0","6","/"};
		System.out.println(validatePostfixOrder(str));
	}

}