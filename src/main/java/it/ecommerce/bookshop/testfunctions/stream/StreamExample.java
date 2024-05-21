package it.ecommerce.bookshop.testfunctions.stream;


public class StreamExample {
	
	public static void main(String[] args) {
		
		String value = "red";
		switch (value) {
		case "red": {
			System.out.println("FAIL");
		}
		case "green":
			System.out.println("OK");
		}
	}

}
