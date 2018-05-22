package web;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import ru.javawebinar.basejava.Config;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.SqlStorage;
import ru.javawebinar.basejava.storage.Storage;
import ru.javawebinar.basejava.storage.serializer.JsonStreamSerializer;
import ru.javawebinar.basejava.util.JsonParser;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ru.javawebinar.basejava.model.ContactType.PHONE;


/**
 * Simple Hello servlet.
 */

public final class Web extends HttpServlet {
    private Storage storage; // = Config.get().getStorage();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = Config.get().getStorage();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        PrintWriter writer = response.getWriter();
        writer.println("Got Connection");
        //  storage.delete("uuid1");

        writer.println(storage.get("1c4b1380-4589-44be-b2fc-468d7c30d92f").getContact(PHONE));
       // storage.getAllSorted();
        writer.println("Got Connection");


    }
}