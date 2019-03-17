package inclass5;

/************************************************************
 *                                                          *
 *  CSCI 470/680     In-Class Exercise 5       Summer 2018  *                       
 *                                                          *
 *  Programmer:  Lucas Damler				                *   
 *                                                          *
 *  Date Due:    25 JUL 2018					            *                         
 *                                                          *
 ************************************************************/

import javax.swing.JFrame;

//Event frame main driver class
public class Events
{
   public static void main(String[] args)
   { 
      EventsFrame multipleSelectionFrame =
         new EventsFrame(); 
      multipleSelectionFrame.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE); 
   } 
}