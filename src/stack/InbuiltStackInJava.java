package stack;

import java.util.Scanner;
import java.util.Stack;

public class InbuiltStackInJava {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Scanner scan = new Scanner(System.in);
		Integer data = scan.nextInt();
		
		while (data != -1) {
			stack.push(data);
			data = scan.nextInt();
		}
		while (stack.size() > 0) {
			System.out.print(stack.pop() + "\t");
		}
		scan.close();
	}
}
