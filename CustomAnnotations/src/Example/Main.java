package Example;

public class Main {
    public static void main(String[] args) {

        Demo d = new Demo();
        Class<? extends Demo> anno = d.getClass();
        System.out.println(anno.getName());

        // try to get the properties of the Annotation
        MyAnno annotation = anno.getAnnotation(MyAnno.class);
        System.out.println(  annotation.age() + annotation.name() + annotation.city());
    }
}