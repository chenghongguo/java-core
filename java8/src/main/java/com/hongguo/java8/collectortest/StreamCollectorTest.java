package com.hongguo.java8.collectortest;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.*;

/**
 * @author: chenghongguo
 * @date: 2019-05-22
 * @description:
 */
public class StreamCollectorTest {

    private List<Person> persons;

    @Before
    public void before() {
        Person p1 = new Person("zhangsan", 20, 1);
        Person p2 = new Person("lisi", 20, 2);
        Person p3 = new Person("wangwu", 20, 4);
        Person p4 = new Person("zhaoliu", 20, 2);
        Person p5 = new Person("tianqi", 20, 3);
        Person p6 = new Person("tianqi", 50, 4);
        persons = Arrays.asList(p1, p2, p3, p4, p5, p6);
    }

    Set<Collector.Characteristics> characteristics =
            Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.UNORDERED, Collector.Characteristics.IDENTITY_FINISH));

    @Test
    public void testClose() {
        Stream stream1 = persons.stream().onClose(() -> System.out.println("onClose1 invoked"));
        System.out.println(stream1);
        BaseStream baseStream = stream1.onClose(() -> System.out.println("onClose2 invoked"));
        System.out.println(baseStream);
    }

    @Test
    public void testMapReplaceAll() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "hello");
        map.put("hello1", "hello1");
        map.put("hello2", "hello2");
        map.put("hello3", "hello3");
        map.replaceAll((k, v) -> k + v);
        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }

    @Test
    public void testToMap() {
        MyCollectorImpl<Person, ?, List<String>> toMap =
                new MyCollectorImpl<>(ArrayList::new, (s, t) -> s.add(t.getName()), (left, right) -> {
                    left.addAll(right);
                    return left;
                }, characteristics);

        List<String> collect1 = persons.stream().collect(toMap);
        collect1.forEach(System.out::println);
    }

    @Test
    public void testToList() {
        MyCollectorImpl<Person, ?, List<Person>> toList =
                new MyCollectorImpl<>(ArrayList::new, List::add, (left, right) -> {
                    left.addAll(right);
                    return left;
                }, characteristics);
        List<Person> collect = persons.stream().collect(toList);
        collect.forEach(System.out::println);
    }

    @Test
    public void testGroupBy3() {
        // Collectors.mapping(Person::getName, Collectors.toList())):
        // T : String (person.getName())
        // A : ArrayList.add()
        // R : List<String>
        TreeMap<Integer, List<String>> map = persons.stream()
                .collect(Collectors.groupingBy(Person::getDept, () -> new TreeMap<>(), Collectors.mapping(Person::getName, Collectors.toList())));
        System.out.println(map);
    }

    @Test
    public void testGroupBy2() {
        //  groupingBy的downstream =  public static <T, U, A, R> Collector<T, ?, R> mapping(Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream) {
        //        BiConsumer<A, ? super U> downstreamAccumulator = downstream.accumulator();
        //        return new CollectorImpl<>(downstream.supplier(),
        //                                   (r, t) -> downstreamAccumulator.accept(r, mapper.apply(t)),
        //                                   downstream.combiner(),
        //                                   downstream.finisher(),
        //                                   downstream.characteristics());
        //    }
        //

        // mapping()分析:
        // downstream.supplier() = HashSet::new;
        // downstream.accumulator() = Set::add -> (s, t) -> s.add(t);  t 类型为 String
        // downstream.combiner() =  (left, right) -> { left.addAll(right); return left; }
        // downstream.finisher() = i -> (R) i (此处已省略)
        // downstream.characteristics() = Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.UNORDERED, Collector.Characteristics.IDENTITY_FINISH));

        // 所以mapping收集器为：
        // mapping = new CollectorImpl<>(HashSet::new, (s, t) -> s.add(t.getName()), (left, right) -> { left.addAll(right); return left; }, CH_UNORDERED_ID);
        // <T, K, A, D>:
        // T: Person
        // K: Person::getDept (Integer) 返回结果Map中的键类型
        // A: downstream(Collectors.toList()) 的中间结果容器类型：List::add
        // D: downstream(Collectors.toList()) 的最终结果类型：List<Person>
        Map<Integer, Set<String>> map = persons.stream()
                .collect(Collectors.groupingBy(Person::getDept, Collectors.mapping(Person::getName, Collectors.toSet())));
        System.out.println(map);

        Set<String> collect = persons.stream().collect(map(Person::getName, Collectors.toSet()));
        System.out.println(collect);
    }

    private <T, A, S, R> Collector<T, A, R> map(Function<T, S> mapper, Collector<S, A, R> downstream) {
        BiConsumer<A, S> downstreamAccumulator = downstream.accumulator();
        return new MyCollectorImpl<>(downstream.supplier(),
                (r, t) -> downstreamAccumulator.accept(r, mapper.apply(t)),
                downstream.combiner(),
                downstream.finisher(),
                downstream.characteristics());
    }

    @Test
    public void testGroupBy() {
        //  Collectors.toList() === CollectorImpl<>((Supplier<List<T>>) ArrayList::new, List::add,  (left, right) -> { left.addAll(right); return left; },  CH_ID);
        // <T, K, A, D>:
        // T: Person
        // K: Person::getDept (Integer) 返回结果Map中的键类型
        // A: downstream(Collectors.toList()) 的中间结果容器类型：List::add
        // D: downstream(Collectors.toList()) 的最终结果类型：List<Person>
        Map<Integer, List<Person>> map = persons.stream().collect(Collectors.groupingBy(Person::getDept, Collectors.toList()));
        System.out.println(map);
    }

    @Test
    public void test3() {
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            System.out.println(start);
            partition(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println(duration);
        }
    }

    private Map<Boolean, List<Integer>> partition(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("hello", "world", "java", "java", "python");
        for (int i = 0; i < 100; i++) {
            Map<String, String> collect =
                    list.parallelStream().collect(new MySetCollector2<>());
            collect.forEach((k, v) -> System.out.println(k + ", " + v));
        }
    }

    @Test
    public void test1() {
        List<String> list = Arrays.asList("hello", "world", "java", "java", "python");
        Set<String> set = list.stream().collect(new MySetCollector<>());
        set.forEach(System.out::println);
    }
}

class Person {
    private String name;
    private int age;
    private int dept;

    public Person() {
    }

    public Person(String name, int age, int dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dept=" + dept +
                '}';
    }
}