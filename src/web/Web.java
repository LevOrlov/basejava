package web;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import ru.javawebinar.basejava.Config;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.SqlStorage;
import ru.javawebinar.basejava.storage.serializer.JsonStreamSerializer;
import ru.javawebinar.basejava.util.JsonParser;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ru.javawebinar.basejava.model.ContactType.PHONE;


/**
 * Simple Hello servlet.
 */

public final class Web extends HttpServlet {
//    protected static final File STORAGE_DIR = Config.get().getStorageDir();



    //private static final SqlStorage sql;



         //   sql.save( new Resume(UUID_1, "Name1"));


    /**
     * Respond to a GET request for the content produced by
     * this servlet.
     *
     * @param request  The servlet request we are processing
     * @param response The servlet response we are producing
     * @throws IOException      if an input/output error occurs
     * @throws ServletException if a servlet error occurs
     */
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter writer = response.getWriter();


          try{
              Class.forName("org.postgresql.Driver");
        SqlStorage sql = new SqlStorage("jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "qazxswedc123");
              writer.println("Got Connection");
          writer.println(sql.get("uuid1"));
          sql.update(new Resume("uuid1","Fuck You"));
              writer.println(sql.get("uuid1"));
          }
                catch (Exception e){
                    writer.println("DB not connection");
                }



    }
} 