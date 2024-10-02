package edu.grinnell.csc207.experiments;

import edu.grinnell.csc207.util.AssociativeArray;

import java.io.PrintWriter;

/**
 * Experiments with Associative Arrays.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class AAExperiments {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+
  
  /**
   * Log and conduct a call to `set`.
   *
   * @param pen
   *   Where to log the message.
   * @param aa
   *   The associative array we're using.
   * @param key
   *   The key to set.
   * @param val
   *   The value to set.
   */
  public static void set(PrintWriter pen, AssociativeArray<String, String> aa, 
      String key, String val) {
    pen.printf("set(\"%s\", \"%s\") -> ", key, val);
    try {
      aa.set(key, val);
      pen.println("OK");
    } catch (Exception e) {
      pen.println("FAILED because " + e.toString());
    } // try/catch
  } // set(PrintWriter, AssociativeArray<String, String>, String, String)

  /**
   * Log and conduct a call to `get`.
   *
   * @param pen
   *   Where to log the message.
   * @param aa
   *   The associative array.
   * @param key
   *   The key.
   */
  public static void get(PrintWriter pen, AssociativeArray<String, String> aa,
      String key) {
    pen.printf("get(\"%s\") -> ", key);
    try {
      pen.println(aa.get(key));
    } catch (Exception e) {
      pen.println("[FAILED because " + e.toString() + "]");
    } // try/catch
  } // get(PrintWriter, AssociativeArray<String, String>, STring)

  /**
   * Log and conduct a call to `hasKey`.
   *
   * @param pen
   *   Where to log the message.
   * @param aa
   *   The associative array.
   * @param key
   *   The key.
   */
  public static void hasKey(PrintWriter pen, 
      AssociativeArray<String, String> aa, String key) {
    pen.printf("hasKey(\"%s\") -> ", key);
    try {
      pen.println(aa.hasKey(key));
    } catch (Exception e) {
      pen.println("[FAILED because " + e.toString() + "]");
    } // try/catch
  } // hasKey(PrintWriter, AssociativeArray<String, String>, STring)

  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run our expereiments.
   *
   * @param args
   *   Command-line parameters. (Ignored.)
   *
   * @throws Exception
   *   When something goes wrong. Usually an I/O issue or an unexpected
   *   Associative Array hiccup.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    AssociativeArray strings2strings = new AssociativeArray<String,String>();

    // The empty array should not have any key. We'll try one.
    hasKey(pen, strings2strings, "k");

    // However, after setting that key, we should be able to get it.
    set(pen, strings2strings, "k", "key");
    hasKey(pen, strings2strings, "k");
    get(pen, strings2strings, "k");

    // What happens if we try a different key?
    hasKey(pen, strings2strings, "q");
    get(pen, strings2strings, "q");

    // What happens if we try the null key?
    set(pen, strings2strings, null, "nothing");
    hasKey(pen, strings2strings, null);
    get(pen, strings2strings, null);

    // What happens when we print the AA?
    pen.println(strings2strings.toString());

    // Trash
    // AssociativeArray<String[], String> arr = new AssociativeArray<String[], String>();
    // String[] strA1 = new String[] {"1", "2"};
    // String[] strA2 = new String[] {"1", "2"};
    // pen.println(strA1.equals(strA2));
    // arr.set(strA1, "worked");
    // pen.println(arr.get(strA2));

    // More trash
    // AssociativeArray<StringBuilder, Integer> array = new AssociativeArray<StringBuilder, Integer>();
    // StringBuilder a = new StringBuilder();
    // StringBuilder b = new StringBuilder("1");
    // array.set(a, 1);
    // array.set(b, 2);
    // a = b;
    // pen.println(array.get());
    // pen.println(array.toString());


    
    
    // And we're done.
    pen.close();
  } // main(String[])
} // class AAExperiments
