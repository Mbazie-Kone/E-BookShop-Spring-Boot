package it.ecommerce.bookshop.testexercises;


public class FirstExample {
	
	static int modifyValue(int num) {
		num++;
		return num;
	}

	public static void main(String[] args) {
		
		int num = 15;
		modifyValue(num);
		System.out.println(num);
		System.out.println(modifyValue(num));
		
	}
}