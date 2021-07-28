package ru.skillbench.tasks.javaapi.collections;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        StringFilterImpl SF = new StringFilterImpl();
       /* SF.add(null);
        SF.add("these");
        SF.add("that");
        SF.add("there");
        SF.add("them");
        System.out.println(SF.getCollection());
        SF.remove("март");
        System.out.println(SF.getCollection());
        System.out.println(SF.getStringsStartingWith("Th").hasNext());
        Iterator ii = SF.getStringsStartingWith("TH");
        while (ii.hasNext()){
            System.out.println(ii.next());
        }
        System.out.println(SF.check(null));
        SF.add("z");
        SF.add("(123)324-1233");
        SF.add("(123)324-12-34");*/
        SF.add("-3");
        SF.add("-(123)324-12-3z");
     //   System.out.println(SF.getCollection());
        Iterator i  = SF.getStringsByNumberFormat("-(###)###-##-##");
        while (i.hasNext()){
            System.out.println(i.next());
        }


    }
}
