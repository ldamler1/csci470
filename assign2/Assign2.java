/************************************************************
 *                                                          *
 *  CSCI 470/680          Assignment 2         Summer 2018  *                                             
 *                                                          *
 *  Programmer: Damler, Lucas                               *
 *              z1761739                                    *
 *                                                          *
 *  Date Due:   28 JUN 2018                                 *                          
 *                                                          *
 *  Purpose:    Executes basic arithmatic and displays      *
 *  			output							            *
 *                                                          * 
 ***********************************************************/
public class Assign2
{
  public static void main(String[] args)
  {
	//declared integers
    int numA = 42,
        numB = 21,
        numC;
    
    //declared double
    double numD;
    
    //output header
    System.out.println("**** CSCI 470/680-E Assignment 2 Output ****");
    
    //divides integers numA and numB, and stores in numC
    numC = numA/numB;
    System.out.printf("the result of integer %d divided by integer %d and stored in an integer is %d\n", numA, numB, numC);
    
    //divides integers numA and numB, and stores in double numD
    numD = numA/numB;
    System.out.printf("the result of integer %d divided by integer %d and stored in a double is %f\n", numA, numB, numD);
    
    //divides integers numA cast as a double and numB, and stores in numD
    numD = (double)(numA)/numB;
    System.out.printf("The result of integer %d (cast as a double) divided by integer %d and stored in a double is %f\n", numA, numB, numD);
  
    //output footer
    System.out.println("**** CSCI 470/680-E Output Complete ****");
  }
}