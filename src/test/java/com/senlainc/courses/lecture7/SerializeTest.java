package com.senlainc.courses.lecture7;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SerializeTest {
    @Test
    public void serializeTest() throws IOException, ClassNotFoundException {
        Course course = new Course();

        course.setLectures(Arrays.asList(
                new Lecture("Serialization", 2),
                new Lecture("Spring Framework", 5)));

        course.setPractices(Arrays.asList(
                new Practice("java.io", 10, 5),
                new Practice("java.nio", 5, 5)
        ));

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Externals.out"));
        out.writeObject(course);
        out.close();

        Course courseAfter = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("Externals.out"))) {
            courseAfter = (Course) in.readObject();
        }

        assertEquals(course.getLectures().size(), courseAfter.getLectures().size());
        assertEquals(course.getPractices().size(), courseAfter.getPractices().size());

        assertNotEquals(course.getPractices().stream().findFirst().get().getTestCount(),
                courseAfter.getPractices().stream().findFirst().get().getTestCount());
    }

    @Test
    public void externalizableTest() throws IOException, ClassNotFoundException {
        Offer offer = new Offer();
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Externals.out"))){
            out.writeObject(offer);
        }

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Externals.out"));
        Offer newOffer = (Offer) in.readObject();

        assertEquals(offer.getName(), newOffer.getName());
    }
}
