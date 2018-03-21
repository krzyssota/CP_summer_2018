package pl.waw.sgh;

public class Strings {

    public static void main (String[] args) {
        char c ='a';
        char d = 68;
        char e = 35625;

        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

       String s1 = "abc";
       // System.out.println(s1);

       String s2 = s1;
       s2 = s2;
       // System.out.println(s2);

      //  String s3 = s1.concat(s2); //s1+s2
       // String s4 = s1.replace('b', 'B');
      //  System.out.println(s4);

      //  char c1 = s1.charAt(2);
       // System.out.println(c1);*/


        int i = "Hello World".indexOf("lo");
        System.out.println(i);
        int j = "Hello World".lastIndexOf("l");
        System.out.println(j);
        boolean sw = "Hello World".startsWith("Hell");
        System.out.println(sw);
      //  System.out.println("lenght of s1 is " + s1.length());

       // s1.equals();
        //comparing string


        System.out.println(s1);
        //String s2 = s1;
       // String s2 = new String ("abc");
        s2 = new String("abc");
        System.out.println(s2);

        if (s2 == s1){
            System.out.println("s2==s1"); //comparison by pointer
        }
        if (s2.equals(s1)){
            System.out.println("s2 equals s1"); //comparison by value USE THIS FOR COMPARING OBJECTS
        }
        String s6 = "Hello World";
        String s7 = s6.substring(7);
        System.out.println(s7);
        String s8 = s6.substring(0, 5);
        System.out.println(s8);
    }
}
