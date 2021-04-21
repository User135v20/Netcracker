package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("please enter the factors of the equation a b c in line: ");
        Scanner console = new Scanner(System.in);
        double a = console.nextDouble();
        double b = console.nextDouble();
        double c = console.nextDouble();

        class Discriminant{
            public double value_search(){
                return  (Math.pow(b,2) - 4*a*c);
            }
        }
        Discriminant dd = new Discriminant();
        double d = dd.value_search();

        if (d > 0) {
            double root1;
            double root2;
            root1 = (-b+Math.pow(d,0.5))/(2*a);
            root2 = (-b-Math.pow(d,0.5))/(2*a);
            System.out.println("root1 is " + root1 + ", root2 is "+ root2);
        }else if (d == 0) {
            System.out.println("root is " + (-b/(2*a)));
        }
        else if (d<0){
            System.out.println("roots not found");
        }
    }
}
