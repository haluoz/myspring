import org.myspring.core.BeanContainer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Test {


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
//        MyThread m1 = new MyThread();
//        m1.run();
//        m1.start();
//        Animal animal = new Animal();
//        Animal animal1 = new Dog();
//        Animal animal2 =new Cat();
//        Dog dog = new Dog();
//        animal.move();
//        animal1.move();
//        animal2.move();
//        dog.bark();
//        animal2.move();
//        System.out.println( animal1 instanceof Animal);
//        System.out.println( animal2 instanceof Animal);
//        String a ="";
//        System.out.println(StarvingSingleton.getInstance());
//        Class<StarvingSingleton> clazz = StarvingSingleton.class;
//        Constructor<StarvingSingleton> constructor = clazz.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        StarvingSingleton starvingSingleton = constructor.newInstance();
//        System.out.println(starvingSingleton.getInstance());
//        HashSet<Integer> set = new HashSet<>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.add(4);
//        for (Integer i : set) {
//            System.out.println(i);
//        }
        System.out.println(BeanContainer.class.getResource("/"));
    }
}
