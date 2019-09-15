package com.senlainc.courses.lecture7;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class JsonTest {
    private static final String json = "{\"age\":30,\"alias\":\"John\"}";

    @Test
    public void obj2JsonTest() throws IOException {
        Teacher teacher = new Teacher("John", 30);

        StringWriter writer = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, teacher);

        assertEquals(json, writer.toString());
    }

    @Test
    public void json2ObjTest() throws IOException {
        StringReader reader = new StringReader(json);

        ObjectMapper mapper = new ObjectMapper();

        Teacher teacher = mapper.readValue(reader, Teacher.class);

        assertEquals(30, teacher.getAge());
    }
}
