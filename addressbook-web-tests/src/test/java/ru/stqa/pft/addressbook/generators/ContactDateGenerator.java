package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import org.jetbrains.annotations.NotNull;
import ru.stqa.pft.addressbook.model.ContactDate;
import ru.stqa.pft.addressbook.model.GroupDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDateGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;


    public static void main(String[] args) throws IOException {
        ContactDateGenerator generator = new ContactDateGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactDate> contacts = generateContact(count);
        if (format.equals("csv")) {
            saveSCV(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveXML(contacts, new File(file));
        } else if (format.equals("json")) {
            saveJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized Format" + format);
        }

    }

    private void saveJson(List<ContactDate> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file);) {
            writer.write(json);
        }
    }

    private void saveXML(List<ContactDate> contacts, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.processAnnotations(ContactDate.class);
        String xml = xStream.toXML(contacts);
        try (Writer writer = new FileWriter(file);) {
            writer.write(xml);
        }
    }

    private void saveSCV(List<ContactDate> contacts, File file) throws IOException {
        try (Writer writer = new FileWriter(file);) {
            for (ContactDate contact : contacts) {
                writer.write(String.format("%s,%s,%s\n", contact.getLastname(), contact.getMiddlename(), contact.getFistname()));
            }
        }
        }
        private List<ContactDate> generateContact ( int count){
            List<ContactDate> contacts = new ArrayList<ContactDate>();
            for (int i = 0; i < count; i++) {
                contacts.add(new ContactDate().withLastname(String.format("last %s", i)).
                        withMiddlename(String.format("middle %s", i)).withFistname(String.format("first %s", i)
                ));
            }
            return contacts;
        }
    }


