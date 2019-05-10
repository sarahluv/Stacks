/*******************************************************************************
Name: Sarah Redmon
Date: 4/30/19
Instructor: Ms. Tucker
Class: CanineApp
Purpose: To let the user put in directions into stack and do certain actions to present the directions
*******************************************************************************
*/

/*------------------------------------------------------------------------------
       FEEDBACK FROM INSTRUCTOR:
       Overall, very good.  The user interface could be better.  The user needs 
       to know what to type in for the directions (North, N, north, 1 for 
       north, etc.).  We want to be very clear to the user.  Also would be 
       good to be able to do options 2 and 3 without running the program again.  
       Still good work.
------------------------------------------------------------------------------*/

import jsjf.ArrayStack;
import java.util.Scanner;

public class CanineApp
{
    public static void main (String[] args)
    {
        /*------------------------------------------------------------------------------
        Initializes scanner, variables, & stack
        ------------------------------------------------------------------------------
        */
        Scanner scnr = new Scanner(System.in);
        String direction, direction2 = "", nextDirection = "";
        int westValue = 0, eastValue = 0, southValue = 0, northValue = 0;
        boolean mathOperation1, mathOperation2, mathOperation3, mathOperation4;
        ArrayStack<String> stack = new ArrayStack<String>();
        
        /*------------------------------------------------------------------------------
        -Allows user to put in as many directions as they want
        -Pushes the direction to the stack
        -Adds 1 to direction value
        -Does all of this while input is yes
        ------------------------------------------------------------------------------
        */
        do {
            System.out.println("Please put in a direction: ");
            direction = scnr.nextLine();
            System.out.println();
            
            stack.push(direction);
            
            if (direction.equalsIgnoreCase("West")) {
                westValue += 1;
            } if (direction.equalsIgnoreCase("East")) {
                eastValue += 1;
            } if (direction.equalsIgnoreCase("South")) {
                southValue += 1;
            } if (direction.equalsIgnoreCase("North")) {
                northValue += 1;
            }
            
            System.out.println("Put in another direction?");
            nextDirection = scnr.nextLine();
            System.out.println();
        } while (nextDirection.equalsIgnoreCase("Yes"));
        
        /*------------------------------------------------------------------------------
        If input is no, user is prompted to type 1, 2, or 3 for options
        ------------------------------------------------------------------------------
        */
        if (nextDirection.equalsIgnoreCase("No")) {
            System.out.println("Type 1 to see directions, type 2 to see directions reversed, or type 3 to see shortest route possible.");
            String choice = scnr.nextLine();
            System.out.println();
            
            /*------------------------------------------------------------------------------
            If 1, pop the directions & display them
            ------------------------------------------------------------------------------
            */
            if (choice.equals("1")) {
                while (!stack.isEmpty()) {
                    System.out.println("* " + stack.pop());
                }
            }
            
            /*------------------------------------------------------------------------------
            If 2, pop the directions, switch them, assign to direction2, & display
            ------------------------------------------------------------------------------
            */
            if (choice.equals("2")) {
                while (!stack.isEmpty()) {
                    direction = stack.pop();
                    switch (direction.toUpperCase()) {
                        case "WEST":
                        direction2 = "East";
                        break;
                        
                        case "EAST":
                        direction2 = "West";
                        break;
                        
                        case "SOUTH":
                        direction2 = "North";
                        break;
                        
                        default:
                        direction2 = "South";
                        break;
                    }
                    direction = direction2;
                    System.out.println("* " + direction);
                }
            }
                
            if (choice.equals("3")) {
                /*------------------------------------------------------------------------------
                If 3, compare northValue to southValue & eastValue to westValue, 
                use boolean values to move to showing the shortest route possible, & 
                display it
                ------------------------------------------------------------------------------
                */
                if (northValue > southValue) {
                    System.out.println("* North count was " + northValue + ". South count was " + southValue + ". The difference is " + (northValue - southValue) + " blocks North.");
                    mathOperation1 = true;
                } else if (northValue < southValue) {
                    System.out.println("* North count was " + northValue + ". South count was " + southValue + ". The difference is " + (southValue - northValue) + " blocks South.");
                    mathOperation2 = true;
                } 
                if (eastValue > westValue) {
                    System.out.println("* East count was " + eastValue + ". West count was " + westValue + ". The difference is " + (eastValue - westValue) + " blocks East.");
                    mathOperation3 = true;
                } else if (eastValue < westValue) {
                    System.out.println("* East count was " + eastValue + ". West count was " + westValue + ". The difference is " + (westValue - eastValue) + " blocks West.");
                    mathOperation4 = true;
                }
                System.out.println();
                if (mathOperation1 = true) {
                    System.out.println("* The quickest way to find the owner is to travel " + (northValue - southValue) + " blocks North");
                } else if (mathOperation2 = true) {
                    System.out.println("* The quickest way to find the owner is to travel " + (southValue - northValue) + " blocks South");
                }
                if (mathOperation3 = true) {
                    System.out.print(" and " + (eastValue - westValue) + " blocks East.");
                } else if (mathOperation4 = true) {
                    System.out.print(" and " + (westValue - eastValue) + " blocks West.");
                }
            }
        }
    }
}
