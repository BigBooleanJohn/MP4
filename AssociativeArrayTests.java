import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

/**
 * Tests of the AssociativeArray class.
 *
 * @author CSC-207 2023Fa
 */
public class AssociativeArrayTests {

  // +---------------------+-----------------------------------------
  // | Tests by Sam Bigham |
  // +---------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Micah Cantor |
  // +-----------------------+

  // +------------------------+--------------------------------------
  // | Tests by Reed Colloton |
  // +------------------------+

  // +------------------+--------------------------------------------
  // | Tests by Pom Dao |
  // +------------------+

  // +--------------------------+------------------------------------
  // | Tests by Joshua Delarosa |
  // +--------------------------+

  // +-------------------+-------------------------------------------
  // | Tests by Jinny Eo |
  // +-------------------+

  // +---------------------------+-----------------------------------
  // | Tests by Kevin Fitzgerald |
  // +---------------------------+

  // +---------------------+-----------------------------------------
  // | Tests by Joyce Gill |
  // +---------------------+

  // +--------------------+------------------------------------------
  // | Tests by Che Glenn |
  // +--------------------+

  // +-------------------------+-------------------------------------
  // | Tests by Kevin Johanson |
  // +-------------------------+

  // +----------------------+----------------------------------------
  // | Tests by Chloe Kelly |
  // +----------------------+

  // +--------------------+------------------------------------------
  // | Tests by Hyeon Kim |
  // +--------------------+

  // +---------------------+-----------------------------------------
  // | Tests by Julian Kim |
  // +---------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Jason Kunkel |
  // +-----------------------+

  // +---------------------+-----------------------------------------
  // | Tests by Wenfei Lin |
  // +---------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Noah Mendola |
  // +-----------------------+

  // +----------------------+----------------------------------------
  // | Tests by John Miller |
  // +----------------------+

  /* this tests the clone method */
  @Test
  public void johnMillerTest01() {
    // Build an array
    AssociativeArray<String, String> array = new AssociativeArray<String, String>();
    array.set("p", "platypus");// set a key/value pair in the AssociativeArray
    AssociativeArray<String, String> aClone = array.clone();
    try {
      assertEquals("platypus", aClone.get("p"));// checking that the new array contains the value from the initial array
    } catch (Exception e) {
      fail("Clone was not properly copied");
    }
  }

  /* this tests the remove method */
  @Test
  public void johnMillerTest02() {
    // Build an array
    AssociativeArray<String, String> array = new AssociativeArray<String, String>();
    array.set("p", "platypus");// set a key/value pair in the AssociativeArray
    array.set("g", "Giraffe");
    array.remove("p");// remove platypus from the array
    try {
      assertEquals(false, array.hasKey("p"));// checking that the p key was removed
    } catch (Exception e) {
      fail("The 'p' key was not properly removed\n");
    }
  }

  /* this tests the ability of get to find and overwrite values */
  @Test
  public void johnMillerTest03() {
    // Build an array
    AssociativeArray<BigInteger, String> array = new AssociativeArray<BigInteger, String>();
    array.set(BigInteger.valueOf(8), "platypus");// set a key/value pair in the AssociativeArray
    array.set(BigInteger.valueOf(15), "Giraffe");// set a key/value pair in the AssociativeArray
    array.set(BigInteger.valueOf(8), "dog");// set a key/value pair in the AssociativeArray
    try {
      assertEquals("dog", array.get(BigInteger.valueOf(8)));// checking that the key was overwritten
    } catch (Exception e) {
      fail("The value at key BigInt 8 wasn't properly overwritten\n");
    }
  }

  /*
   * this is an edge case for getting the size of an empty array. it should be
   * zero
   */
  @Test
  public void johnMillerEdge01() {
    AssociativeArray<String, String> array = new AssociativeArray<String, String>();
    assertEquals(array.size(), 0);
  }

  /*
   * this is an edge case for setting a null value. it should return the null
   * value at the key
   */
  @Test
  public void johnMillerEdge02() {
    AssociativeArray<BigInteger, String> array = new AssociativeArray<BigInteger, String>();
    array.set(BigInteger.valueOf(8), null);// setting the 8,null pair
    try {
      assertEquals(null, array.get(BigInteger.valueOf(8)));// asserting we get null at 8
    } catch (KeyNotFoundException e) {
      e.printStackTrace();
    }
  }

  // +-----------------------+---------------------------------------
  // | Tests by Albert Okine |
  // +-----------------------+

  // +---------------------+-----------------------------------------
  // | Tests by Alma Ordaz |
  // +---------------------+

  // +-----------------------------+---------------------------------
  // | Tests by Samuel A. Rebelsky |
  // +-----------------------------+

  /**
   * A test of cloning.
   */
  @Test
  public void samuelRebelskyTest01() {
    // Build an array
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    arr.set("A", "Apple");
    try {
      assertEquals("Apple", arr.get("A"));
    } catch (Exception e) {
      fail("Original array does not contain expected value");
    }
    // Make a copy
    AssociativeArray<String, String> arr2 = arr.clone();
    // Make sure it contains the appropriate value
    try {
      assertEquals("Apple", arr2.get("A"));
    } catch (Exception e) {
      fail("Clone does not contain original value");
    } // try/catch
    // Change the original array
    arr.set("A", "aardvark");
    // Make sure we haven't changed the clone.
    try {
      assertEquals("Apple", arr2.get("A"));
    } catch (Exception e) {
      fail("Change to original changes clone.");
    }
    // Change the clone
    arr2.set("A", "Ant");
    // And look for values
    try {
      assertEquals("Ant", arr2.get("A"));
    } catch (Exception e) {
      fail("Cannot change clone");
    }
    try {
      assertEquals("aardvark", arr.get("A"));
    } catch (Exception e) {
      fail("Change to clone changes original");
    }
  } // samuelRebelskyTest01()

  /**
   * Can we successfully add a bunch of values? (Checks array expansion.)
   */
  @Test
  public void samuelRebelskyTest02() {
    AssociativeArray<Integer, Integer> arr = new AssociativeArray<Integer, Integer>();
    // Add a bunch of values
    for (int i = 10; i < 50; i++) {
      arr.set(i, i * i);
    } // for
    try {
      for (int i = 49; i >= 10; i--) {
        assertEquals(i * i, arr.get(i));
      }
    } catch (Exception e) {
      fail("Exception in call to get");
    }
  } // samuelRebelskyTest02()

  /**
   * Do we get exceptions when grabbing a deleted value from the array?
   */
  @Test
  public void samuelRebelskyTest03() {
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    // Add an element to the array
    arr.set("A", "Apple");
    // Make sure that it's there.
    try {
      assertEquals("Apple", arr.get("A"));
    } catch (KeyNotFoundException e) {
      fail("Could not set A to Apple");
    }
    // Remove it.
    arr.remove("A");
    // Make sure it's no longer there.
    try {
      // The following line should throw an exception
      arr.get("A");
      fail("Did not throw an exception");
    } catch (KeyNotFoundException e) {
      // Do nothing
    }
  } // samuelRebelskyTest03

  /**
   * Do we get exceptions when grabbing a value from the empty array.
   */
  @Test
  public void samuelRebelskyEdge01() {
    AssociativeArray<String, String> arr = new AssociativeArray<String, String>();
    try {
      // The following line should throw an exception
      arr.get("A");
      fail("Did not throw an exception");
    } catch (KeyNotFoundException e) {
      // Do nothing
    }
  } // samuelRebelskyEdge01

  // +--------------------------+------------------------------------
  // | Tests by Maria Rodriguez |
  // +--------------------------+

  // +-----------------------------+---------------------------------
  // | Tests by Gabriela Roznawska |
  // +-----------------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Shuta Shibue |
  // +-----------------------+

  // +----------------------+----------------------------------------
  // | Tests by Madel Sibal |
  // +----------------------+

  // +------------------------------+--------------------------------
  // | Tests by Livia Stein Freitas |
  // +------------------------------+

  // +------------------------+--------------------------------------
  // | Tests by Tyrell Taylor |
  // +------------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Audrey Trinh |
  // +-----------------------+

  // +---------------------+-----------------------------------------
  // | Tests by Rene Urias |
  // +---------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Christina Vu |
  // +-----------------------+

  // +-----------------------+---------------------------------------
  // | Tests by Luke Walters |
  // +-----------------------+

  // +------------------------+--------------------------------------
  // | Tests by Jonathan Wang |
  // +------------------------+

  // +-------------------+-------------------------------------------
  // | Tests by Lydia Ye |
  // +-------------------+

} // class AssociativeArrayTests
