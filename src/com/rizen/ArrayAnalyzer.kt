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
        var uniqueInFirst = HashSet<Int>(array1.toMutableSet())
        var uniqueInSecond = HashSet<Int>()
        var commonItems = HashSet<Int>()
        for (item in array2) {
            if (uniqueInFirst.contains(item)) {
                commonItems.add(item)
                uniqueInFirst.remove(item)
            } else {
                uniqueInSecond.add(item)
            }
        }
        return Result(uniqueInFirst, uniqueInSecond, commonItems)
    }

    class Result(val uniqueInFirst : Set<Int>, val uniqueInSecond : Set<Int>, val commonItems : Set<Int>) {
        override fun toString(): String{
            return "Result(uniqueInFirst=$uniqueInFirst, uniqueInSecond=$uniqueInSecond, commonItems=$commonItems)"
        }
    }
}
