/////////////////////////////// WinterCarnival ////////////////////////////////
//
// Title: Winter Carnival Driver
// Files: P05.jar, WinterCarnival.java, FrozenStatue.java, DancingBadger.java,
// StarshipRobot.java, images
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
import java.util.ArrayList;

/**
 * This class initializes all of the image objects within the SimulationEngine and executes their
 * update method
 * 
 * @author Kaiden Schears
 *
 */
public class WinterCarnival extends SimulationEngine {
  private ArrayList<FrozenStatue> objects = new ArrayList<FrozenStatue>();

  /**
   * Constructor with no arguments initializes 2 objects of FrozenStatue & StarshipRobot as well as
   * 4 objects of DancingBadger
   */
  public WinterCarnival() {
    float[] arr1 = {600, 100};
    float[] arr2 = {200, 500};
    float[][] arr3 = {{0, 0}, {600, 100}};
    float[][] arr4 = {{800, 300}, {200, 500}};
    float[] arr5 = {304, 268};
    float[] arr6 = {368, 268};
    float[] arr7 = {432, 268};
    float[] arr8 = {496, 268};
    // arr input for objects represents starting positions of the objects except arr 3,4 as they
    // have
    // end points as well
  
    DanceStep[] steps =
        {DanceStep.Left,DanceStep.Right,DanceStep.Right,DanceStep.Left, DanceStep.Down, 
            DanceStep.Left, DanceStep.Right,DanceStep.Right,DanceStep.Left,DanceStep.Up};
    // steps has moves left, right,right, left,down, left,right,right, left, up
    objects.add(new FrozenStatue(arr1));
    objects.add(new FrozenStatue(arr2));
    objects.add(new StarshipRobot(arr3));
    objects.add(new StarshipRobot(arr4));
    objects.add(new DancingBadger(arr5, steps));
    
    objects.add(new DancingBadger(arr6,steps));
    objects.add(new DancingBadger(arr7,steps));
    objects.add(new DancingBadger(arr8, steps));
    
  }

  /**
   * This method will be automatically called repeatedly until the program is terminated all objects
   * created in constructor are called in this method and their specified update method is executed
   */
  public void update() {
   
    for (int i = 0; i < objects.size(); i++) {
      objects.get(i).update(this);
    }
   
   // objects.get(4).update(this);
  }

  public static void main(String[] args) {

    WinterCarnival sim = new WinterCarnival();


  }
}
