package com.senlainc.courses.lecture5;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class StreamTest {

    private Collection<String> collection = Arrays.asList("1", "2", "3", "4");

    @Test
    public void test02(){
        System.out.println(collection.stream().findAny().orElse("1"));
    }

    @Test
    public void test03(){
        System.out.println(collection.stream().filter((s) -> s.contains("1")).collect(Collectors.toList()));
    }

    @Test
    public void test04(){
        System.out.println(collection.stream().anyMatch("1"::equals));
    }

    @Test
    public void test05(){
        System.out.println(collection.stream().findFirst().orElse("1"));
    }

    @Test
    public void test06(){
        System.out.println(collection.stream().noneMatch("1"::equals));
    }

    @Test
    public void test07(){
        System.out.println(collection.stream().min(String::compareTo).get());
    }

    @Test
    public void test08(){
        System.out.println(collection.stream().mapToInt((s) -> Integer.parseInt(s)).sum());
    }

    @Test
    public void test09(){
        System.out.println(collection.stream().mapToInt((s) -> Integer.parseInt(s)).average());
    }
}
