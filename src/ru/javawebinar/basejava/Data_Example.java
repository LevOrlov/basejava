package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Organization;
import ru.javawebinar.basejava.model.OrganizationSection;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.serializer.DataStreamSerializer;

import java.io.*;
import java.time.Month;
import java.util.Map;

import static ru.javawebinar.basejava.model.SectionType.PERSONAL;

public class Data_Example {
    private static final String UUID_1 = "uuid1";
    private static final Resume R1;
    static{R1 = new Resume(UUID_1, "Name1");
    R1.addSection(PERSONAL,new OrganizationSection(
            new Organization("Organization2", "http://Organization2.ru",
                    new Organization.Position(2015, Month.JANUARY, "position1", "content1"))));}

    public static void main(String[] args) throws IOException {
        DataStreamSerializer dataStreamSerializer  =new DataStreamSerializer();

        OutputStream output = new FileOutputStream("C:\\Users\\Lev\\basejava\\file.txt");
        InputStream input = new FileInputStream("C:\\Users\\Lev\\basejava\\file.txt");
        dataStreamSerializer.doWrite(R1,output);
        System.out.println(dataStreamSerializer.doRead(input).toString());


        //почему то после первого вывода закрывается поток??? ВАЙ?
     /*   Map map=dataStreamSerializer.doRead(input).getAllSection();
        map.forEach((key, value) -> System.out.println(key + ", " + value));*/

    }
}
