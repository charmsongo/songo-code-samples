package com.songo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created By GS 19:27 2020/4/5
 */
public class Test1 {

    private static final Logger logger = LoggerFactory.getLogger(Test1.class);
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String json1 = "{\"string1\": \"111\",\"string2\": \"22\",\"int\": 1,\"booleen\": true}";

        String html1 = "<html>\n" +
                "<head>\n" +
                "    \n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";

        String json2 = "{\n" +
                "  \"aaa\": 111,\n" +
                "  \"adad\": true\n" +
                "  \n" +
                "}";

        /*List<Person> personList1 =new ArrayList<>();
        List<Person> personList2 =new ArrayList<>();
        List<Person> personList3 =new ArrayList<>();
        List<Person> personList4 =new ArrayList<>();
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        personList1.add(person1);
        personList2.add(person2);
        personList3.add(person3);
        personList4.add(person4);
        System.out.println(personList1);
        System.out.println(personList2);
        System.out.println(personList3);
        System.out.println(personList4);*/

        //List<Person> plist1 =new ArrayList<>();
        //List<Person> plist2 =new ArrayList<>();
        //List<Person> plist3 =new ArrayList<>();
        //List<Person> plist4 =new ArrayList<>();
        //Person person1 = new Person();
        //Person person2 = new Person();
        //Person person3 = new Person();
        //Person person4 = new Person();
        //plist1.add(person1);
        //plist2.add(person2);
        //plist3.add(person3);
        //plist4.add(person4);
        //System.out.println(plist1);
        //System.out.println(plist2);
        //System.out.println(plist4);
        //System.out.println(plist3);

        //Integer a = 1000, b = 1000;
        //System.out.println(a==b);
        //Integer c = 100, d = 100;
        //System.out.println(c==d);

        //Class<?> aClass = Integer.class.getDeclaredClasses()[0];
        //Field cache = aClass.getDeclaredField("cache");
        //cache.setAccessible(true);
        //Integer[] integers = (Integer[]) cache.get(aClass);
        //integers[132] = integers[133];
        //
        //Integer.valueOf(1);
        //int a = 2;
        //int b = a + a;
        //logger.info("%d + %d =%d", a, a, b);

        int a = 7;
        int b = 16;
        System.out.println(a % b);
        System.out.println(a & (b - 1));


    }
}
