package com.hongguo.java.base.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * PhantomReferenceTest
 *
 * @author chenghongguo
 * @date 2020/4/28
 * @since 1.0.0
 */
public class PhantomReferenceTest {

    public static void main(String[] args) throws Exception {
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference<Person> phantomReference = new PhantomReference<>(new Person("zhangsan"), queue);

        System.out.println(phantomReference.get());
        System.gc();

        TimeUnit.SECONDS.sleep(1);
        System.out.println(phantomReference.get());
    }

}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Person: " + this + ", is gc");
    }
}
