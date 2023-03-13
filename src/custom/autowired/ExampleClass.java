package custom.autowired;

public class ExampleClass {
    @Autowired
    Dependency dependency;

    public void dependencyTest() {
        dependency.print();
    }

    public static void main(String[] args) throws Exception {
        ExampleClass exampleClass = new ExampleClass();
        AutowiredInjector.inject(exampleClass);
        exampleClass.dependencyTest();
    }
}
