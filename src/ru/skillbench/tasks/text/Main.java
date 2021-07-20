package ru.skillbench.tasks.text;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactCardImpl CC = new ContactCardImpl();
        ContactCardTests TC = new ContactCardTests();
       // TC.getFullName1();
        Scanner sc = new Scanner( "BEGIN:VCARD\r\n" +
                "FN:Forrest Gump\r\n" +
                "ORG:Bubba Gump Shrimp Co.\r\n"+
                "TEL;TYPE=WORK,VOICE:4951234567\r\n" +
                "GENDER:F\r\n" +
                "BDAY:06-07-1944\r\n" +
                "TEL;TYPE=CELL,VOICE:1234567890\r\n" +
                "TEL;TYPE=HOME,VOICE:1234567891\r\n" +
                "END:VCARD");
        String test = new String("BEGIN:VCARD\r\n"+
                "FN:Анастасия Иванова\r\n" +
                "ORG:Подружка\r\n" +
                "GENDER:F\r\n"+
                "END:VCARD");
        String strstr = new String("BEGIN:VCARD\r\n"+
                "FN:Forrest Gump\r\n" +
                "ORG:Рога и копыта\r\n"+
                "TEL;TYPE=WORK,VOICE:4951234567\r\n" +
                "GENDER:F\r\n" +
                "BDAY:06-07-1944\r\n"+
                "TEL;TYPE=CELL,VOICE:1234567890\r\n" +
                "TEL;TYPE=HOME,VOICE:1234567891\r\n" +
                "END:VCARD");
        //CC.getInstance(strstr);
        CC.getInstance(sc);
        /*System.out.println(CC);
        System.out.println(CC.getFullName());
        System.out.println(CC.getOrganization());
        System.out.println(CC.isWoman());
        CC.getBirthday();
        System.out.println(CC.getAge().getYears());
        System.out.println(CC.getAgeYears());
        System.out.println(CC.getPhone("CELL,VOICE"));*/
        System.out.println(CC.getBirthday());


    }
}
