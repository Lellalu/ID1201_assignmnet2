package se.kth.id1201;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MainTest extends TestCase
{
    public void testSearchUnsorted()
    {   
        int[] unsorted = {1,24,3,8,5,9};
        assertTrue(Main.search_unsorted(unsorted, 1));
        assertFalse(Main.search_unsorted(unsorted, 0));
    }

    public void testBinarySearch()
    {   
        int[] sorted = {1,2,3,4,5,6,7,8,9,10};
        assertTrue(Main.binary_search(sorted, 4));
        assertTrue(Main.binary_search(sorted, 10));
        assertFalse(Main.binary_search(sorted, 11));
    }

    public void testDuplicateSearchBinary()
    {   
        int[] sorted1 = {1,2,3,4,5,6,7,8,9,10};
        int[] sorted2 = {1,11,12,13,14,15,16};
        int[] sorted3 = {11,12,13,14,15,16,17};
        assertTrue(Main.duplicateSearchBinary(sorted1,sorted2));
        assertFalse(Main.duplicateSearchBinary(sorted1,sorted3));
    }

     public void testDuplicateSearchLinear()
    {   
        int[] unsorted1 = {1,5,3,10,6,24,8,10,9};
        int[] unsorted2 = {11,1,12,13,14,15,16};
        int[] unsorted3 = {11,12,18,14,15,16,17};
        assertTrue(Main.duplicateSearchLinear(unsorted1,unsorted2));
        assertFalse(Main.duplicateSearchLinear(unsorted1,unsorted3));
    }

    public void testDuplicateSearchBetter()
    {   
        int[] sorted1 = {1,3,5,7,9,11,13,15};
        int[] sorted2 = {2,4,5,6,8,10,12,14,16,18};
        int[] sorted3 = {2,4,6,8,10,12,14,16,18,20,22};
        assertTrue(Main.duplicateSearchBinary(sorted1,sorted2));
        assertFalse(Main.duplicateSearchBinary(sorted1,sorted3));
    }
    
}
