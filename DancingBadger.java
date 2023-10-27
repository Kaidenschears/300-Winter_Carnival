/////////////////////////////// DancingBadger ////////////////////////////////
//
// Title: Dancing Badger Builder
// Files: P05.jar, FrozenStatue.java, DancingBadger.java, StarshipRobot.java, images
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
// Persons: none
// Online Sources: Apendix(I) in project description,
// http://cs300-www.cs.wisc.edu/wp/wp-content/uploads/2020/02/p05javadoc/allclasses-index.html
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;

/**
 * This class creates an animation of a Dancing Badger which moves according to the danceSteps it is
 * passed in the constructor.
 * 
 * @author Kaiden Schears
 */
public class DancingBadger extends StarshipRobot {
  protected DanceStep[] danceSteps;
  protected int stepIndex;

  /**
   * Constructor that sets initial position and destination after the first move of the
   * DancingBadger and the path to the DancingBadger image
   * 
   * @param arr   an array that contains the starting position of DancingBadger
   * @param steps an array of DanceSteps that the DancingBadger will execute
   */
  public DancingBadger(float[] arr, DanceStep[] steps) {
    super(new float[][]{arr,steps[0].getPositionAfter(arr)});
    danceSteps = steps;
    stepIndex = 1;
    imageName = "images" + File.separator + "dancingBadger.png";
    speed = 2;
  }

  /**
   * updates the current destination to the position after a specified danceStep held in the
   * danceStep array is added to the current x and y coordinates
   * 
   * @Override this method in StarshipRobot class
   */
  protected void updateDestination() {
   destination = danceSteps[stepIndex].getPositionAfter(new float[] {x,y});
   stepIndex = (stepIndex + 1) % danceSteps.length;
  }
}
