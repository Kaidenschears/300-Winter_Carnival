/////////////////////////////// StarshipRobot ////////////////////////////////
//
// Title: Starship Robot Builder
// Files: P05.jar, FrozenStatue.java, StarshipRobot.java, images
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
 * Creates a animation of a Starship Robot starting at a specified position and ending at a
 * specified location.
 *
 * @author Kaiden Schears
 */
public class StarshipRobot extends FrozenStatue {
  protected float[][] beginAndEnd;
  protected float[] destination;
  protected float speed;


  /**
   * gets initial position and end position from beginAndEnd array and respectively assigns them to
   * x,y(starting position) and destination and makes a image pathname to starshipRobot.
   * 
   * @param beginAndEnd a two dimensional array that contains the starting coordinates and ending
   *                    coordinates of the StarshipRobot
   */
  public StarshipRobot(float[][] beginAndEnd) {
    super(beginAndEnd[0]);
    this.beginAndEnd = beginAndEnd;
    this.destination = beginAndEnd[1];
    speed = 6;
    imageName = "images" + File.separator + "starshipRobot.png";
  }

  /**
   * Calculates the distance between (a,destination[0]) and (b,destination[1]) 
   * utilizing the distance formula.
   * @param a variable of type float
   * @param b variable of type float
   * @return float r (distance between a and b)
   */
  protected float distance(float a, float b) {
    float r;
    r = (float) Math.sqrt((Math.pow((a - destination[0]), 2.0) + Math.pow((b - destination[1]), 2.0)));
    return r;

  }

  /**
   * Method moves Robot toward destination by a adding or subtracting speed to the current position.
   * 
   * @return true if the distance between the Robot and destination is less than 2 times speed.
   */
  protected boolean moveTowardDestination() {
    float distance;
    distance = distance(x, y);
    x = x + (speed * (destination[0] - x)) / distance;
    y = y + (speed * (destination[1] - y)) / distance;
      isFacingRight = x < destination[0];
    if (distance <(2* speed)) {
      return true;
    }
    return false;
  }

  /**
   * updates destination to the position that the Robot is not currently at by changing destination 
   * to either beginning position or ending position in beginAndEnd array.
   */
  protected void updateDestination() {
    if (destination == beginAndEnd[1])
      destination =beginAndEnd[0];
    else
      destination = beginAndEnd[1];
  }

  /**
   * when moveTowardDestination() is true the destination updates so the Robot goes back and forth
   * between the two points. Then it calls the super method which will print out the image.
   * @Override method in FrozenStatue
   */
  public void update(SimulationEngine update) {
    if (moveTowardDestination()) {
     updateDestination();
    }
    super.update(update);
  }
}
