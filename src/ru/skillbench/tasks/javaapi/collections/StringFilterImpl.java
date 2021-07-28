package ru.skillbench.tasks.javaapi.collections;

import java.util.*;


public class StringFilterImpl implements StringFilter {

    private Set<String> newset  = new HashSet<String>();

    public boolean check (String str){
        if (str == null || str.length()==0) {
            return false;
        }
        else return true;
    }

    @Override
    public void add(String s) {
        newset.add(s);
    }

    @Override
    public boolean remove(String s) {
        return newset.remove(s.toLowerCase());
    }

    @Override
    public void removeAll() {
        newset.clear();
    }

    @Override
    public Collection<String> getCollection() {
        return newset;
    }

    @Override
    public Iterator<String> getStringsContaining(String chars) {
        if (check(chars)) {
            Set<String> it_set = new HashSet<String>();
            for (String str : newset){
                if (check(str) && str.contains(chars)){
                    it_set.add(str);
                }
            }
            return it_set.iterator();
        }
        else return newset.iterator();
    }

    @Override
    public Iterator<String> getStringsStartingWith(String begin) {
        if (check(begin)){
            Set<String> it_set = new HashSet<String>();
            for (String str : newset){
                if (check(str) && str.startsWith(begin.toLowerCase()))
                    it_set.add(str);
            }
            return it_set.iterator();
        }
        else return newset.iterator();
    }

    @Override
    public Iterator<String> getStringsByNumberFormat(String format) {

        if (check(format)){
            Set<String> it_set = new HashSet<String>();
            for (String str : newset) {

                if (check(str) && str.length() == format.length()) {
                    boolean err = false;

                    for (int i = 0; i < format.length()+1; i++) {

                        if (err == true)
                            break;

                        if (i == format.length()) {
                            it_set.add(str);
                            break;
                        }

                        if (format.charAt(i) == '#'){
                            if (Character.isDigit(str.charAt(i)) == false)
                                err = true;
                        }
                        else
                            if (format.charAt(i) !=str.charAt(i))
                                err = true;
                    }
                }
            }
            return it_set.iterator();
        }
        else return newset.iterator();
    }

    @Override
    public Iterator<String> getStringsByPattern(String pattern) {
        if (check(pattern)){
            int position = 0;
            List<Integer> index = new ArrayList<Integer>();
            Set<String> it_set = new HashSet<String>();

            while (position < pattern.length()){
                position=pattern.substring(position).indexOf('*');
                index.add(position);
            }
            for (String str : newset) {

                if (index.isEmpty() == false) {

                    if (index.get(0) == 0) {
                        str.indexOf(pattern.substring(index.get(0)+1,index.get(1)));

                    }
                    else {
                        if (str.startsWith(pattern.substring(0, index.get(0)))) {
                            System.out.println("");
                        } else {
                            break;
                        }

                    }
                }
                else
                    if (str.equals(pattern)) it_set.add(str);
            }
            return newset.iterator();

        }
        else return newset.iterator();

    }
}
