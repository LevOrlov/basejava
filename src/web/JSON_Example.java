package web;

import com.google.gson.Gson;

import com.google.gson.JsonElement;
import org.apache.log4j.Logger;
import ru.javawebinar.basejava.model.*;
import ru.javawebinar.basejava.storage.Storage;
import ru.javawebinar.basejava.storage.serializer.JsonStreamSerializer;
import ru.javawebinar.basejava.util.JsonParser;

import java.io.*;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


import static ru.javawebinar.basejava.model.ContactType.PHONE;

public class JSON_Example  {
  /*  public static class User {
        String name;
        String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }
    }*/
  protected static final File STORAGE_DIR = new File("C:\\Users\\Lev\\basejava\\Storage_Resume");

    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume R1;
     static final Resume R2;
    private static final Resume R3;
    private static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");

        R1.addContact(ContactType.MAIL, "mail1@ya.ru");
        R1.addContact(PHONE, "11111");
        R1.addSection(SectionType.OBJECTIVE, new TextSection("Objective1"));
        R1.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        R1.addSection(SectionType.ACHIEVEMENT, new ListSection("Achivment11", "Achivment12", "Achivment13"));
        R1.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "JavaScript"));
        R1.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization11", "http://Organization11.ru",
                                new Organization.Position(2005, Month.JANUARY, "position1", "content1"),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        R1.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", null,
                                new Organization.Position(1996, Month.JANUARY, 2000, Month.DECEMBER, "aspirant", null),
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT facultet")),
                        new Organization("Organization12", "http://Organization12.ru")));
        R2.addContact(ContactType.SKYPE, "skype2");
        R2.addContact(PHONE, "22222");
        R1.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization2", "http://Organization2.ru",
                                new Organization.Position(2015, Month.JANUARY, "position1", "content1"))));
    }

    static Logger log = Logger.getLogger(JSON_Example.class.getName());

    public static void main(String[] args) throws IOException {
        //PropertyConfigurator.configure(args[0]);

        JsonStreamSerializer jsonStreamSerializer = new JsonStreamSerializer();
        Gson gson = new Gson();
        List<Resume> listOfStates=new ArrayList<Resume>();
        listOfStates.add(R2);
       
       // listOfStates.add(R2);

        try (Writer writer = new FileWriter("C:\\Users\\Lev\\basejava\\Storage_Resume\\uuid1")) {

            JsonParser.write(listOfStates.get(0), writer);
            log.info("JsonParser.write");
        }
        JsonElement json = gson.fromJson(new FileReader("C:\\Users\\Lev\\basejava\\Storage_Resume\\uuid1"), JsonElement.class);
        System.out.println();
        Resume res = JsonParser.read(new FileReader("C:\\Users\\Lev\\basejava\\Storage_Resume\\uuid1"), Resume.class);

        System.out.println(res.getContacts().get(PHONE));
        res.addContact(PHONE,"89111925650");
        System.out.println(res.getContacts().get(PHONE));
        try (Writer writer = new FileWriter("C:\\Users\\Lev\\basejava\\Storage_Resume\\uuid1")) {

            JsonParser.write(res, writer);
            log.info("JsonParser.write");
        }
        {

       /* User user1 = new User("1","2");
        User user2 = new User("1","2");
        User user3 = new User("1","2");

        List<User> listOfStates=new ArrayList<User>();
        listOfStates.add(user1);
        listOfStates.add(user2);
        listOfStates.add(user3);*/




        try (Writer writer = new FileWriter("C:\\Users\\Lev\\basejava\\temp.out")) {

            gson.toJson(listOfStates, writer);
        }

        }
    }
}