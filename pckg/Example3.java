package pckg;

import java.util.List;
import pckg_commons.Person;

public class Example3 {

	interface CheckPerson {
		boolean test(Person p);
	}

	//// stage 2 : Using Inner Classes
	// static class CheckPersonEligibleForSelectiveService implements CheckPerson {
	// public boolean test(Person p) {
	// return p.gender == Person.Sex.MALE &&
	// p.getAge() >= 18 &&
	// p.getAge() <= 25;
	// }
	// }

	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void main(String[] args) {

		List<Person> roster = Person.createRoster();

		//// stage 2 : Using Inner Classes
		// printPersons(roster, new CheckPersonEligibleForSelectiveService());

		// stage 3 : Using Anonymous classes
		printPersons(roster, new CheckPerson() {
			public boolean test(Person p) {
				return p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
			}
		});

	}
}
