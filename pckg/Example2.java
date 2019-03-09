package pckg;

public class Example2 {

	static String regularExpression = "[^0-9]";

	public static void validatePhoneNumbers(String phoneNumber1, String phoneNumber2) {

		final int numberLength = 10;

		// move your logic in local class
		class PhoneNumber {
			String formattedPhoneNumber;

			// constructor
			PhoneNumber(String phoneNumber) {
				
				//local class has access to the members of its enclosing class
				String currentNumber = phoneNumber.replaceAll(regularExpression, "");

				//local class has access to the local variables of your enclosing block, like numberLength
				//such variables have to be final or 'effectively' final
				if (currentNumber.length() == numberLength)
					formattedPhoneNumber = currentNumber;
				else
					formattedPhoneNumber = null;
			}

			public String getNumber() {
				return formattedPhoneNumber;
			}

		}

		PhoneNumber p1 = new PhoneNumber(phoneNumber1);
		PhoneNumber p2 = new PhoneNumber(phoneNumber2);

		if (p1.getNumber() == null)
			System.out.println("First number is invalid");
		else
			System.out.println("First number is " + p1.getNumber());
		if (p2.getNumber() == null)
			System.out.println("Second number is invalid");
		else
			System.out.println("Second number is " + p2.getNumber());

	}

	public static void main(String[] args) {
		
		validatePhoneNumbers("123-456-7890", "456-7890");

	}

}
