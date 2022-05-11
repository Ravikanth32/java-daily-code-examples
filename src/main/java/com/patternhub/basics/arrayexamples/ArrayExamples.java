package com.patternhub.basics.arrayexamples;

public class ArrayExamples {
    public static void main(String[] args) {
        int values[] = new int[]{0,1,2,3,4,5};

        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
        }

        int data[] = values.clone();

    }
}
