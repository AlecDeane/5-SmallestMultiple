/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5.smallestmultiple;

import java.util.ArrayList;

/**
 *
 * @author Alec
 * For Project Euler
 */
public class SmallestMultiple {

    /**
     * @param args the command line arguments
     * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
     * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
     */
    public static void main(String[] args) {
        ArrayList<Integer> listNums = getListToNumber(20); //20 for Project Euler
        System.out.println(getLargestNum(listNums));
        int lowestMultiple = getLowestMultiple(listNums);
        System.out.println(lowestMultiple);
    }
    
    public static ArrayList<Integer> getListToNumber(int num){
        /**
        * This function will simply return the list of numbers up
        * to the given parameter 
        * 
        * @param num The max number to which the list of numbers can go.
        */
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        for(int i = 2;i<=num;i++){
            listOfNumbers.add(i);
        }
        return listOfNumbers;
    }
    
    
    public static int getLowestMultiple(ArrayList<Integer> listInt){
        /**
        * This function will get the lowest common multiple of every integer in
        * the supplied parameter list. 
        * 
        * @param listInt The supplied list.
        */
        boolean notFound = true;
        int lowestMultiple = 0;
        int i = getLargestNum(listInt);
        int j = i;
        while(notFound){
                if(isMultipleOfAll(listInt,i)){
                   notFound = false;
                   lowestMultiple = i;
                   break;
                }
            i+=j;
        }
        return lowestMultiple;
    }
    
    public static int getLargestNum(ArrayList<Integer> nums){
        /**
        * This function will get the largest integer from the ArrayList
        * of integers
        * 
        * @param nums The supplied list.
        */
        int curMax = 0;
        for(int num : nums){
            if(num > curMax ){
                curMax = num;
            }
        }
        return curMax;
    }
    
    public static boolean isMultipleOfAll(ArrayList<Integer> listInt,int numToCheck){
        /**
        * This function will check to see if numToCheck, the second parameter, is evenly
        * divisible by every variable in ListInt.
        * 
        * @param ListInt The supplied ArrayList.
        * @param numToCheck Number to be divided by each entry in ListInt.
        */
        for(int num : listInt){
            if(numToCheck % num != 0){
                return false;
            }
        }
        return true;
    }
    
}
