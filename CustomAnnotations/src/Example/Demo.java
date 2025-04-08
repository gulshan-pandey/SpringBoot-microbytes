package Example;


@MyAnno(name = "Hello", city = "Noida")
public class Demo {

    @MyAnno(name = "Hello", city = "Noida")
    public void display() {
        System.out.println("Hello");
    }


}
