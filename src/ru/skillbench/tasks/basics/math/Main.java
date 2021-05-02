package ru.skillbench.tasks.basics.math;

public class Main {
    public static void main(String[] args){
        ArrayVector AV = new ArrayVectorImpl();
        AV.set(11.01,12,33,4,5,6,7.7);
        ArrayVector AV2;
        AV2 = AV.clone();
//      ArrayVector AV2 = new ArrayVectorImpl();
//      AV2.set(1,1,1,1);
//      AV2.sum(AV);
        for (int i=0;i< AV2.getSize();i++){
            System.out.println(AV.get(i));
        }
        //System.out.println();
        //System.out.println(AV.get(12));
        //System.out.println(AV.getMin());
        //System.out.println(AV.getMax());



    }

}
