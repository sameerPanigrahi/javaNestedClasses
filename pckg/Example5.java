package pckg;

import java.util.List;
import java.util.function.Predicate;

import pckg_commons.Person;

//compare this Example5 with Example4
//no need to have a separate functional interface CheckPerson
//make use of Predicate<T> function provided by java.util.functions

public class Example5 {

	// interface CheckPerson {
	// boolean test(Person p);
	// }

	public static void printPersons(List<Person> roster, Predicate<Person> tester) {
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
