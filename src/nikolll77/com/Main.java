package nikolll77.com;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, IOException, InstantiationException {
        ClassForSave cfs = new ClassForSave(435,"str1","str2");
        String fileName="e:\\serial.txt";

	    Serialisator ser = new Serialisator();
        //----------
        ser.serialise(cfs);
        ser.save(fileName);
        //-----------
        ser.load(fileName);
        cfs=ser.deserialise(ClassForSave.class);

        System.out.print(cfs);
    }
}
