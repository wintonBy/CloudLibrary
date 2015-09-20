package test;

import java.util.Scanner;
import java.util.Stack;

public class BaiduTest {

	private static Stack<Character> opeStack = new Stack<Character>();
	private static Stack<Integer> numStack = new Stack<Integer>();

	private static StringBuilder in = new StringBuilder();
	private static StringBuilder number = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			System.out.println(cal(sc.nextLine()));
		}
		sc.close();
	}

	public static int cal(String input) {
		in.append(input);
		while (in.length() > 0) {
			char temp = in.charAt(0);
			in.delete(0, 1);//读一位，删除一位，从左至右
			if (temp > '0' && temp < '9') {
				number.append(temp);//如果temp是数字，则追加到number上
			} else {
				if (!"".equals(number.toString())) {
					//如果number不为空，则将number加入到数字堆栈
					int num = Integer.parseInt(number.toString());
					numStack.push(num);
					number.delete(0, number.length());//清空number
				}
				while (!opeStack.isEmpty() && !compare(temp)) {//如果操作栈不为空并且compare返回为false，则进行计算
					int num2 = numStack.pop();
					int num1 = numStack.pop();
					char ope = opeStack.pop();
					cal0(ope, num1, num2);//计算
				}
				if (temp != '#' && compare(temp)) {//如果是
					opeStack.push(temp);//如果栈空或者上一个操作符是+、-，并且temp是*、/时，将temp入栈
				}
			}
		}
		//算式读完了，将最后一个数入栈
		if (number.length() > 0) {
			int num = Integer.parseInt(number.toString());
			numStack.push(num);
		}
		//按入栈顺序计算算式
		while (!opeStack.isEmpty()) {
			int num2 = numStack.pop();
			int num1 = numStack.pop();
			cal0(opeStack.pop(), num1, num2);
		}

		return numStack.pop();//将最后的计算结果返回
	}

	public static void cal0(char ope, int num1, int num2) {
		//进行两个数的计算。并将计算结果作为下一个次的操作数
		switch (ope) {
		case '+':
			numStack.push(num1 + num2);
			break;
		case '-':
			numStack.push(num1 - num2);
			break;
		case '*':
			numStack.push(num1 * num2);
			break;
		case '/':
			numStack.push(num1 / num2);
			break;
		}
	}

	public static boolean compare(char operation) {
		if (opeStack.isEmpty())
			return true;
		char last = opeStack.peek();//获取操作栈栈顶元素，未出栈

		switch (operation) {
		//如果是下一个计算是+、-计算，则返回false，并计算上一个操作
		//如：读到1+2+3，当读到第二个+时，可先计算出1+2的值了
		case '+':
			return false;
		case '-':
			return false;
		case '*':
			//如果下一个计算是*、/，并且上一个计算不是+、-，则可以进行上一个计算，如：读到：1*2/9，当读到/时，则可以先计算1*2
			//如果下一个计算是*、/时，并且上一个计算是+、-，则不进行计算，继续向前读，如读到1+2*3，当读到*时，则不进行1+2的计算，继续读算式
			if (last == '+' || last == '-')
				return true;
			return false;
		case '/':
			if (last == '+' || last == '-')
				return true;
			return false;
		}
		return true;
	}

}