package pl.waw.sgh;

import java.util.Map;

public class FileOps {
    public static void main(String[] args) {

        String curDir = System.getProperty("user.dir");
        String tmpDir = System.getProperty("java.io.tmpdir");
        System.out.println("TMP: "+tmpDir);

        // run->edit_configuration -> VM options: -Dksota.myProp=Hello

        String mySysProp = System.getProperty("ksota.myProp");
        System.out.println("myProp: " +mySysProp);

        String user = System.getenv("USERNAME");
        Map<String, String> env = System.getenv();
        System.out.println(user);

        System.out.println();
    }
}
