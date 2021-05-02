package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class ArrayVectorImpl implements ArrayVector {
    private double[] array;


    public void set (double... elements){
        array = new double[elements.length];
        array = elements;
    }
    public double[] get(){
        return array;
    }
    public ArrayVector clone(){
        double[] array_2 = new double[array.length];
        System.arraycopy(array, 0, array_2, 0, array.length);
        ArrayVectorImpl array2 = new ArrayVectorImpl();
        array2.set(array_2);
        return array2;
    }
    public int getSize(){
        return array.length;
    }
    public void set(int index, double value){
            if (index<0){return;}
            else if (index < array.length){
                array[index]=value;
            }
            else {
                array = Arrays.copyOf(array,index+1);
                array[index] = value;
            }
        }

    public double get(int index) throws ArrayIndexOutOfBoundsException{
        if (index > array.length){
            throw new ArrayIndexOutOfBoundsException();
        }
        else return array[index];
    }
    public double getMax(){
        int max_index=0;
        for (int i=1;i<array.length;i++){
            if (array[max_index]<array[i]){
                max_index=i;
            }
        }
        return array[max_index];
    }
    public double getMin(){
        int min_index=0;
        for (int i=1;i<array.length;i++){
            if (array[min_index]>array[i]){
                min_index=i;
            }
        }
        return array[min_index];
    }
    public void sortAscending(){
        double swap;

        for (int i = 0; i < array.length; i++) {
            for (int j = 1;j < array.length-i;j++){
                if (array[j] < array[j - 1]){
                    swap=array[j];
                    array[j]=array[j-1];
                    array[j-1]=swap;
                }
            }
        }
    }
    public void mult(double factor){
        for (int i=0;i<array.length;i++){
            array[i]=array[i]*factor;
        }
    }

    public ArrayVector sum(ArrayVector anotherVector){
        for(int i=0; i< array.length || i<anotherVector.getSize(); i++){
            array[i] = array[i]+anotherVector.get(i);
        }
        return this;
    }
    public double scalarMult(ArrayVector anotherVector){
        double result_ = 0;
        for(int i=0; i< array.length || i<anotherVector.getSize(); i++){
            result_ += array[i]*anotherVector.get(i);
        }
        return result_;
    }
    public double getNorm(){
        double result_=0;
        for(int i=0; i< array.length; i++){
            result_ += array[i]*array[i];
        }
        return Math.pow(result_,0.5);
    }
}
