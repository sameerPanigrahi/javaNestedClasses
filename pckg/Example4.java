package pckg;

import java.util.List;

import pckg_commons.Person;

//compare this Example4 with Example3
//we recognize CheckPerson is a functional interface so we make use of lambda expressions

public class Example4 {

	interface CheckPerson {
		boolean test(Person p);
	}

	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void main(String[] args) {

		List<Person> roster = Person.createRoster();

		printPersons(roster, (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);

	}
}