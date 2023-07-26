package com.zipcodewilmington.arrayutility;



import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<AnyType> {
    private AnyType[] array;

    public ArrayUtility(AnyType[] inputArray) {
        this.array = inputArray;

    }

    public Integer countDuplicatesInMerge(AnyType[] arrayToMerge, AnyType valueToEvaluate) {
        int count = 0;
        ArrayList<AnyType> mergedList = new ArrayList<>();
        
        for (AnyType type : array){
            mergedList.add(type);
        }
        for (AnyType type : arrayToMerge){
            mergedList.add(type);
        }
        for (AnyType type : mergedList){
            if (type == valueToEvaluate){
                count++;
            }
        }
        return count;
    }

    public AnyType getMostCommonFromMerge(AnyType[] arrayToMerge) {
        AnyType mostCommon = null;
        int count = 0;
        int tempCount = 0;

        
        for (AnyType type : arrayToMerge){
            tempCount = countDuplicatesInMerge(arrayToMerge, type);
            if (tempCount > count){
                count = tempCount;
                mostCommon = type;
            }
        }
        

        return mostCommon;
    }

    public Integer getNumberOfOccurrences(AnyType valueToEvaluate) {
        Integer count = 0;

        for (AnyType anyType : array) {
            if( anyType == valueToEvaluate){
                count++;
            }
        }
        return count;
    }

    public AnyType[] removeValue(AnyType valueToRemove) {
        int sizeModifier = getNumberOfOccurrences(valueToRemove);
        int counter = 0;
        AnyType[] newArray = (AnyType[]) Array.newInstance(valueToRemove.getClass(), array.length - sizeModifier);

        for (AnyType value : this.array){
            if (!value.equals(valueToRemove)){
                newArray[counter] = value;
                counter++;
            }
        }


        return newArray;
    }
}
