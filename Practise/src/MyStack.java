import java.util.*;

public class MyStack 
{
	public static void main(String[] args)
	{
		Stack<Integer> st = new Stack();
		st.push(100);
		st.push(200);
		st.push(300);
		st.push(400);
		System.out.println(st);
		st.pop();
		System.out.println(st);
		int pos = st.search(200);
		System.out.println(pos);
		boolean res = st.empty();
		System.out.println(res);
		System.out.println(st.peek());
		
	}
}
