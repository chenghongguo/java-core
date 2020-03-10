package com.hongguo.java8.methodreference;

import java.util.Comparator;

/**
 * StudentComparator
 *
 * @author chenghongguo
 * @date 2020/2/21
 * @since 1.0.0
 */
public class StudentComparator {

    public int compare(Student s1, Student s2) {
        return s1.getScore() - s2.getScore();
    }

    public int compare(Student s1, Student s2, Comparator<Student> comparator) {
        return comparator.compare(s1, s2);
    }
}
