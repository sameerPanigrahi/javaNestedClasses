package pckg;

import java.util.function.Consumer;

public class _6_LambdaScopeTest {
	public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            
            // The following statement causes the compiler to generate
            // the error "local variables referenced from a lambda expression
            // must be final or effectively final" in statement A:
            //
            // x = 99;
            
            Consumer<Integer> myConsumer = (y) -> 
            {
            	
            	//Error: Lambda expression's local variable x cannot redeclare another local variable defined in an enclosing scope.
            	//int x;
                
            	System.out.println("x = " + x); // Statement A
                System.out.println("y = " + y);
                System.out.println("this.x = " + this.x);
                System.out.println("_6_LambdaScopeTest.this.x = " +
                    _6_LambdaScopeTest.this.x);
            };

            myConsumer.accept(x);//so this will go to 'y' above where you define the lambda function of Consumer<Integer>

        }
    }

    public static void main(String... args) {
        _6_LambdaScopeTest st = new _6_LambdaScopeTest();
        _6_LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
