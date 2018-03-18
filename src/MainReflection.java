import model.Resume;
import storage.ArrayStorage;

import java.lang.reflect.Field;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException {
        ArrayStorage r = new ArrayStorage();
       // Field field = r.getClass().get;
       // field.setAccessible(true);
        System.out.println(r.getClass().getDeclaredMethods()[0].getDefaultValue());
       // System.out.println(field.get(r));

    }
}
