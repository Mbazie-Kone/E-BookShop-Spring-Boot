package it.ecommerce.bookshop.testfunctions.stream;

import java.util.Arrays;
import java.util.List;

public class StreamExample {

	public void test(String a) {
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		
		StreamExample streamExample = new StreamExample();
		
		List<String> textList = Arrays.asList("Wow", "Wow", "Wow", "Hi", "Hello", "Bye");
		
		textList.stream().filter(b -> b == "Wow").forEach(streamExample::test);
		
	}

}
