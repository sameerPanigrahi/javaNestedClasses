package pckg;

import java.util.List;

import pckg_commons.Person;

//compare this _4_LambdaExpression with _3_AnonymousClassExpressions
//we recognize CheckPerson is a functional interface so we make use of lambda expressions

public class _4_LambdaExpression {

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