package ru.skillbench.tasks.text;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

public class ContactCardImpl implements ContactCard {
    private String FN = new String();
    private String ORG = new String();
    private String GENDER = new String();
    private String BDAY = new String();
    private HashMap <String,String> TEL = new HashMap<>();

    public ContactCardImpl(){
        this.FN = FN;
        this.ORG = ORG;
        this.GENDER = GENDER;
        this.BDAY = BDAY;
        this.TEL = TEL;
    }


    @Override
    public ContactCard getInstance(Scanner scanner) throws InputMismatchException, NoSuchElementException {

        String str0 = scanner.nextLine();
        if (str0.equals("BEGIN:VCARD")== false) {
            throw new NoSuchElementException();
        }

        String str1 = scanner.nextLine();
        if (str1.startsWith("FN")) {
            if (str1.startsWith("FN:")){
                FN = str1.substring(3);
            }
            else throw new InputMismatchException();
        }
        else throw new NoSuchElementException();

        String str2 = scanner.nextLine();
        if (str2.startsWith("ORG")){
            if (str2.startsWith("ORG:") && str2.substring(4).isEmpty()==false){
                ORG = str2.substring(4);
            }
            else throw new InputMismatchException();
        }
        else throw new NoSuchElementException();

        while (true) {
            String str = scanner.nextLine();

            if (str.startsWith("GENDER")){
                if ((str.startsWith("GENDER:")) && (str.substring(7)).length()==1 && (str.substring(7).indexOf("F")==0 || (str.substring(7).indexOf("M")==0)) ) {
                    GENDER = str.substring(7);
                }
                else throw new InputMismatchException();
            }

            if (str.startsWith("BDAY")){
                if (str.startsWith("BDAY:")) {
                    Pattern bday_pattern = Pattern.compile("[0-9]{2}+[-][0-9]{2}+[-][0-9]{4}");
                    if (bday_pattern.matcher(str.substring(5)).find())
                        BDAY = str.substring(5);
                    else throw new InputMismatchException();
                }
                else throw new InputMismatchException();
            }


            if (str.startsWith("TEL")){
                Pattern num_phone = Pattern.compile("[0-9]{10}");
                if (str.startsWith("TEL;TYPE=") && str.substring(str.indexOf(":")+1).length() == 10 && num_phone.matcher(str.substring(str.indexOf(":")+1)).find() ){
                    TEL.put(str.substring(9, str.indexOf(":")),str.substring(str.indexOf(":")+1));
                }
                else throw new InputMismatchException();
            }

            if (str.equals("END:VCARD")){
                break;
            }
        }
        return this;
    }

    @Override
    public ContactCard getInstance(String data) throws InputMismatchException, NoSuchElementException{

        String[] row = data.split("\r\n");


        if (row[0].equals("BEGIN:VCARD")== false) {
            throw new NoSuchElementException();
        }

        if (row[1].startsWith("FN")) {
            if (row[1].startsWith("FN:")){
                FN = row[1].substring(3);
            }
            else throw new InputMismatchException();
        }
        else throw new NoSuchElementException();

        if (row[2].startsWith("ORG")){
            if (row[2].startsWith("ORG:") && row[2].substring(4).isEmpty()==false){
                ORG = row[2].substring(4);
            }
            else throw new InputMismatchException();
        }
        else throw new NoSuchElementException();


        if (row[row.length-1].equals("END:VCARD")) {
            for (int i = 3; i < row.length-1; i++) {

                if (row[i].startsWith("GENDER")) {
                    if ((row[i].startsWith("GENDER:")) && (row[i].substring(7)).length() == 1 && (row[i].substring(7).indexOf("F") == 0 || (row[i].substring(7).indexOf("M") == 0))) {
                        GENDER = row[i].substring(7);
                    } else throw new InputMismatchException();
                }

                if (row[i].startsWith("BDAY")) {
                    if (row[i].startsWith("BDAY:")) {
                        Pattern bday_pattern = Pattern.compile("[0-9]{2}+[-][0-9]{2}+[-][0-9]{4}");
                        if (bday_pattern.matcher(row[i].substring(5)).find())
                            BDAY = row[i].substring(5);
                        else throw new InputMismatchException();
                    } else throw new InputMismatchException();
                }

                if (row[i].startsWith("TEL")) {
                    Pattern num_phone = Pattern.compile("[0-9]{10}");
                    if (row[i].startsWith("TEL;TYPE=") && row[i].substring(row[i].indexOf(":") + 1).length() == 10 && num_phone.matcher(row[i].substring(row[i].indexOf(":") + 1)).find()) {
                        TEL.put(row[i].substring(9, row[i].indexOf(":")),row[i].substring(row[i].indexOf(":") + 1));
                    } else throw new InputMismatchException();
                }
            }
        }
        else throw new NoSuchElementException();

        return this;
    }

    @Override
    public String getFullName() {
        return FN;
    }

    @Override
    public String getOrganization() {
        return ORG;
    }

    @Override
    public boolean isWoman() {
        if (GENDER.equals("F")){
            return true;
        }
        else return false;
    }

    @Override
    public Calendar getBirthday() throws NoSuchElementException{
        if (BDAY.isEmpty() == false){
            int day = Integer.parseInt (BDAY.substring(0,2));
            int month = Integer.parseInt (BDAY.substring(3,5));
            int year = Integer.parseInt (BDAY.substring(6,10));
            Calendar calendar = new GregorianCalendar(year,month,day);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.getTimeZone();
            calendar1.set(year,month,day);

            return calendar1;
        }
        else throw new NoSuchElementException();
    }

    @Override
    public Period getAge() throws NoSuchElementException {
        if (BDAY.isEmpty() == false) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate bdate = LocalDate.parse(BDAY, dtf);
            LocalDate today = LocalDate.now();
            return Period.between(bdate, today);
        }
        else throw new NoSuchElementException();
    }

    @Override
    public int getAgeYears() {
        return getAge().getYears();
    }

    @Override
    public String getPhone(String type) throws NoSuchElementException {
        if (TEL.get(type)!=null)
            return "("+TEL.get(type).substring(0,3)+") "+TEL.get(type).substring(3,6)+"-"+TEL.get(type).substring(6,10);
        else throw new NoSuchElementException();
    }
}