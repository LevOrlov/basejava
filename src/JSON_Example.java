import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSON_Example  {
    public static class User {
        String name;
        String age;

        public User(String name, String age) {
            this.name = name;
            this.age = age;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        User user1 = new User("1","2");
        User user2 = new User("1","2");
        User user3 = new User("1","2");

        List<User> listOfStates=new ArrayList<User>();
        listOfStates.add(user1);
        listOfStates.add(user2);
        listOfStates.add(user3);




        try (Writer writer = new FileWriter("C:\\Users\\Lev\\basejava\\temp.out")) {

            gson.toJson(listOfStates, writer);
        }
    }
}