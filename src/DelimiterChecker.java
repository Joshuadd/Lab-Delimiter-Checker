import java.util.Scanner;

public class DelimiterChecker {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Delimiter Checker:");
		System.out.println("------------------");
		System.out.println("");
		System.out.print("Enter the string to check: ");
		String userIn = input.next();
		input.close();
		boolean result = check(userIn);
		System.out.println("");
		if(result) {
			System.out.println("Delimiters are valid");
		} else {
			System.out.println("Delimiters are invalid");
		}
	}
	
	public static boolean check(String str) {
		StackX stack = new StackX(100);
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
				stack.push(str.charAt(i));
			} else if(str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}') {
				char curr = stack.pop();
				if(curr == '(' && str.charAt(i) != ')')
					return false;
				else if(curr == '[' && str.charAt(i) != ']')
					return false;
				else if(curr == '{' && str.charAt(i) != '}')
					return false;
			}
		}
		return true;
	}
}
