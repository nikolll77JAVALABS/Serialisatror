package nikolll77.com;


import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Serialisator {

    private String serialisedString;

    public Serialisator(){
        serialisedString="";
    }

    public String serialise(Object o) throws IllegalAccessException {
    String s="";
    Class<?> cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field f:fields){
            if (f.isAnnotationPresent(Save.class)){
                s+=f.get(o)+ "#";
            }
        }
    serialisedString=s;
    return s;
    }

    public <T> T deserialise(Class<T> cls) throws IllegalAccessException, InstantiationException {
        T res = cls.newInstance();
        int i=0;
        String[] sepstr= serialisedString.split("#");
        Field[] fields = cls.getDeclaredFields();
        for (Field f:fields){
            if (f.isAnnotationPresent(Save.class)){
                if (f.getType()==int.class) f.setInt(res,Integer.parseInt(sepstr[i]));
                if (f.getType()==String.class) f.set(res,sepstr[i]);
                i++;
            }
        }

        return res;
    }

    public void save(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        fw.write(serialisedString);
        fw.close();
    }

    public void load(String fileName) throws IOException {
        serialisedString = new String(Files.readAllBytes(Paths.get(fileName)));

    }


}
