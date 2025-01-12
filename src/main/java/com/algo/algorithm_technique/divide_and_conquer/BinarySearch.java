package com.algo.algorithm_technique.divide_and_conquer;

/******************************************************************************
 * Compilation: javac BinarySearch.java Execution: java BinarySearch whitelist.txt < input.txt
 * Dependencies: In.java StdIn.java StdOut.java Data files:
 * http://algs4.cs.princeton.edu/11model/tinyW.txt http://algs4.cs.princeton.edu/11model/tinyT.txt
 * http://algs4.cs.princeton.edu/11model/largeW.txt http://algs4.cs.princeton.edu/11model/largeT.txt
 *
 * % java BinarySearch tinyW.txt < tinyT.txt 50 99 13
 *
 * % java BinarySearch largeW.txt < largeT.txt | more 499569 984875 295754 207807 140925 161828
 * [367,966 total values]
 *
 ******************************************************************************/

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.algo.algorithm.util.In;
import com.algo.algorithm.util.StdOut;

/**
 * The <tt>BinarySearch</tt> class provides a static method for binary searching for an integer in a
 * sorted array of integers.
 * <p>
 * The <em>rank</em> operations takes logarithmic time in the worst case.
 * <p>
 * For additional documentation, see <a href="http://algs4.cs.princeton.edu/11model">Section 1.1</a>
 * of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class BinarySearch {

    /**
     * This class should not be instantiated.
     */
    private BinarySearch() {
    }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param a   the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of key in array <tt>a</tt> if present; <tt>-1</tt> otherwise
     */
    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * Returns the index of the specified key in the specified array. This function is poorly named
     * because it does not give the <em>rank</em> if the array has duplicate keys or if the key is not
     * in the array.
     *
     * @param key the search key
     * @param a   the array of integers, must be sorted in ascending order
     * @return index of key in array <tt>a</tt> if present; <tt>-1</tt> otherwise
     * @deprecated Replaced by {@link #indexOf(int[], int)}.
     */
    public static int rank(int key, int[] a) {
        return indexOf(a, key);
    }

    /**
     * Reads in a sequence of integers from the whitelist file, specified as a command-line argument;
     * reads in integers from standard input; prints to standard output those integers that do
     * <em>not</em> appear in the file.
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String currentPath = new File(".").getCanonicalPath();
        String fileName = currentPath + "/src/cs/tinyW.txt";
        // read the integers from a file
        In in = new In(fileName);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        int key = 3;
        if (BinarySearch.indexOf(whitelist, key) == -1) {
            StdOut.println(key);
        }
    }
}