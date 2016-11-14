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
        //Only need this to work for primes as all over numbers up to 20 are comprised of these primes.
        
        ArrayList<Integer> primes = getPrimesToNumber(20); //20 for Project Euler
        System.out.println(getLargestNum(primes));
        
        /*if(isMultipleOfAll(primes,9699690) ){
            System.out.println("true");
        } */
        int lowestMultiple = getLowestMultiple(primes);
        System.out.println(lowestMultiple);
    }
    
    public static ArrayList<Integer> getPrimesToNumber(int num){
        /**
        * This function will simply return the list of Prime numbers up
        * to the given parameter 
        * 
        * @param num The max number to which the list of Primes can go.
        */
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        ArrayList<Integer> listOfPrimes = new ArrayList<>();
        for(int i = 2;i<=num;i++){
            listOfNumbers.add(i);
        }
        for(int number : listOfNumbers){
            if(isPrime(number)){
                listOfPrimes.add(number);
            }
        }
        return listOfNumbers;
        //return listOfPrimes;
    }
    
    public static boolean isPrime(int num){
        /**
        * This function will simply return true or false depending on whether
        * the input "num" is a prime or not.
        * 
        * @param num number to be tested as Prime
        */
        
        //This will loop through every
        for(Long i = 1L;i<num;i++){
            if(num % i == 0 && i != 1L && i != num){
                //System.out.println(num + " is not a prime number.");
                return false;
            }
        }
        //System.out.println(num + " is a prime number!");
        return true;
    }
    
    public static int getLowestMultiple(ArrayList<Integer> listInt){
        System.out.println("Entering getLowestMultiple");
        boolean notFound = true;
        int lowestMultiple = 0;
        int i = getLargestNum(listInt);
        System.out.println("gLM: largestInt = " + i);
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
        int curMax = 0;
        for(int num : nums){
            if(num > curMax ){
                curMax = num;
            }
        }
        return curMax;
    }
    
    public static boolean isMultipleOfAll(ArrayList<Integer> listInt,int numToCheck){
        for(int num : listInt){
            //does it divide evenly by each member of listInt?
            if(numToCheck % num != 0){
                return false;
            }
        
        }
        return true;
    }
    
}
