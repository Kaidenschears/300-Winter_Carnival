/////////////////////////////// FrozenStatue////////////////////////////////
//
// Title: Frozen Statue Builder
// Files: P05.jar, FrozenStatue.java, images
// Course: CS 300 Spring 2020
//
// Author: Kaiden Schears
// Email: kgschears@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name:
// Partner Email:
// Partner Lecturer's Name:
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// __ Write-up states that pair programming is allowed for this assignment.
// __ We have both read and understood the course Pair Programming Policy.
// __ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: None
// Online Sources: Apendix(I) in project description,
// http://cs300-www.cs.wisc.edu/wp/wp-content/uploads/2020/02/p05javadoc/allclasses-index.html
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;

/**
 * This class creates an image of Frozen Statue at a specified position
 * 
 * @author Kaiden Schears
 *
 */
public class FrozenStatue {
  protected float x;
  protected float y;
  protected boolean isFacingRight;
  protected String imageName;

  /**
   * Takes a float array and sets indices to the appropriate variable, sets object to initially face
   * right and creates an image path name.
   * 
   * @param arry has 2 indices the 1st index is starting position for x and the 2nd is starting
   *             position for y
   */
  public FrozenStatue(float[] arry) {
    x = arry[0];
    y = arry[1];
    isFacingRight = true;
    imageName = "images" + File.separator + "frozenStatue.png";
  }

  /**
   * This method will draw the current Frozen Statue image and it will be called in the update
   * method of the WinterCarnival.java file so that it updates until program terminates
   * 
   * @param engine an instance of SimulationEngine
   */
  public void update(SimulationEngine engine) {
      engine.draw(imageName, x, y, !(isFacingRight));
  }
}
