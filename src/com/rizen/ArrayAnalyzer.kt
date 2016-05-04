package com.rizen

import java.util.*

/*
Given two arrays of numbers (for example [1,2,3,4,5] and [2,9,-1000,3,1,0,5])
and their sizes, write a single function to find (#1) which numbers are present
in the second array and not the first, (#2) which numbers are present in the first
array but not the second, and (#3) which numbers are present in both arrays.
A single function must return all three pieces of information back to the user that called the function.
Write one version that is O( N ) and one that O( N^2 ).
*/
object ArrayAnalyzer {
    @JvmStatic fun main(args: Array<String>) {
        val array1 = arrayOf(1, 2, 3, 4, 5)
        val array2 = arrayOf(2, 9, -1000, 3, 1, 0, 5)

        println(analyzeArray(array1, array2))
    }

    private fun analyzeArray(array1: Array<Int>, array2: Array<Int>): Result {
        var result = Result()
        var mutableMap = HashMap<String, Int>()
        for (item in array1) {
            mutableMap.put(item.toString(), item)
        }
        for (item in array2) {
            if (mutableMap.containsKey(item.toString())) {
                mutableMap.remove(item.toString())
                result.commonItems.add(item)
            } else {
                result.secondUniqueItems.add(item)
            }
        }
        result.firstUnique.addAll(mutableMap.values)
        return result
    }

    class Result(var firstUnique: ArrayList<Int> = ArrayList<Int>(),
                 var secondUniqueItems: ArrayList<Int> = ArrayList<Int>(),
                 var commonItems: ArrayList<Int> = ArrayList<Int>()) {
        override fun toString(): String {
            return "Result(firstUnique=$firstUnique, secondUniqueItems=$secondUniqueItems, commonItems=$commonItems)"
        }
    }
}
