package com.senlainc.courses.lecture7;

import org.junit.Test;

import javax.xml.bind.*;
import java.io.*;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class JaxbTest {
    private static final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<student>\n" +
            "    <age>21</age>\n" +
            "    <name>John</name>\n" +
            "</student>";

    @Test
    public void jaxbObj2XmlTest() throws JAXBException {
        Student student = new Student("John", 21);

        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(Student.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(student, writer);

        assertEquals(xml, writer.toString());
    }

    @Test
    public void jaxbXml2ObjTest() throws JAXBException {
        StringReader reader = new StringReader(xml);

        JAXBContext context = JAXBContext.newInstance(Student.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Student student = (Student) unmarshaller.unmarshal(reader);

        assertEquals(21, student.getAge());
    }
}
