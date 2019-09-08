package com.senlainc.courses.lecture5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class BoxTest {

    interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(a);
        }
    }

    class Animal { void feed() { } }
    class Pet extends Animal { void call() { } }
    class Kitty extends Pet { void mew() { } }
    class Doge extends Pet { void bark() { } }

    @Test
    public void GenericInvariantsTest() {
        Box<Integer> intBox = new Box<Integer>();
        //Box<Number> numBox = intBox;
    }

    @Test
    public void WildcardTest01() {

        List<Number> nums = Arrays.<Number>asList(4.1F, 0.2F);
        List<Integer> ints = Arrays.<Integer>asList(1, 2);
        Collections.copy(nums, ints);

        //Collections.copy(ints, nums);
    }

    @Test
    public void WildcardTestPE1() {
        List<Pet> src = Arrays.asList();
        List<Pet> dest = new ArrayList<Pet>();
        Collections.copy(dest, src);
        for (Pet p : dest) {
            p.call();
        }
    }

    @Test
    public void WildcardTestPE2() {
        List<Kitty> src = Arrays.asList();
        List<Pet> dest = new ArrayList<Pet>();
        Collections.copy(dest, src);
        for (Pet p : dest) {
            p.call();
        }
    }

    @Test
    public void WildcardTestPE3() {
        List<Kitty> src = Arrays.asList();
        List<Doge> dest = new ArrayList<Doge>();
        //Collections.copy(dest, src);
        for (Doge doge : dest) {
            doge.bark();
        }
    }

    @Test
    public void WildcardTestCS1() {
        List<Animal> dest = new ArrayList<Animal>();
        List<Kitty> src = Arrays.asList();
        Collections.<Pet>copy(dest, src);
        for (Animal a : dest) {
            a.feed();
        }
    }

    @Test
    public void lambdaExamplesTest() throws Exception {
        Runnable runnable = () -> {
            System.out.println("Hello world");
        };
        runnable.run();

        Callable<Integer> callable = () -> 40 + 2;
        int val = callable.call();

        Predicate<Integer> predicate = (x) -> x !=0;
        predicate.negate();
    }

    @Test
    public void streamExamplesTest() throws Exception {
        Stream.of(1,2,3,4).filter(e -> e <=2)
                .forEach(System.out::println);
    }
}
