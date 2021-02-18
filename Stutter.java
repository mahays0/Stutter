// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 2, section 2.5, page 80

import java.io.*;

/**
* The (@code Stutter) class identifies repeated words in a text file. 
* Then, it will print out the repeated words it finds. (@code Stutter) will 
* accept standard input or a list of file names. 
*
* @author Paul Ammann
* @author Jeff Offutt
*/

public class Stutter
{
  // Class variables used in multiple methods.
  private static int repeat = 0;
  private static boolean lastdelimit = true;
  private static String curWord = "", prevWord = "";
  private static char delimits [] =
          {'	', ' ', ',', '.', '!', '-', '+', '=', ';', ':', '?',
           '&', '{', '}', '\\'}; // First char in list is a tab

/**
*  Parses the arguments, decides if stdin or a file name, and calls 
*  (@code Stut())
*
*  @param args  command line arguments
*/
public static void main (String[] args) throws IOException
{
   String fileName;
   FileReader myFile;
   BufferedReader inFile = null;

   if (args.length == 0)
   {  // no file, use stdin
      inFile = new BufferedReader (new InputStreamReader (System.in));
   }
   else
   {
      fileName = args [0];
      if (fileName == null)
      {  // no file name, use stdin
         inFile = new BufferedReader (new InputStreamReader (System.in));
      }
      else
      {  // file name, open the file.
         myFile = new FileReader (fileName);
         inFile = new BufferedReader (myFile);
      }
   }

   stut (inFile);
}

/**
* Reads in the characters one by one from the input stream, identifying
* 	the words in the stream, being delimiated by those defined in 
*	(@code delimits[]) array. This will call checkDupes() when it does 
*	find a word
*
* @param inFile  a buffer of input to be read in
*
*/
private static void stut (BufferedReader inFile) throws IOException
{
   String inLine;
   char c;
   int linecnt = 1;
   while ((inLine = inFile.readLine()) != null)
   {  // For each line

      for (int i=0; i<inLine.length(); i++)
      {  // for each character
         c = inLine.charAt(i);

         if (isDelimit (c))
         {  // Found an end of a word.
            checkDupes (linecnt);
         }
         else
         {
           lastdelimit = false;
           curWord = curWord + c;
         }
      }
      checkDupes (linecnt);
      linecnt++;

   }
}  // end Stut

/**
* Checks to see if the globally define curWord is the same as prevWord and 
* prints a message if they are the same. 
* 
* @param line  line number that the stream is currently on
*
*/
private static void checkDupes (int line)
{
   if (lastdelimit)
   return; // already checked, keep skipping
 
   lastdelimit = true;
   if (curWord.equals(prevWord))
   {
	repeat++;
      System.out.println ("Repeated word on line " + line + ": " +
<<<<<<< HEAD
                        prevWord+ " " + curWord);
   }
  else 
{
prevWord= curWord;
}
   curWord = "";
=======
                        prevWord+ " " + curWord + ". Number of repetitions: "
			+ repeat);
   } // end if
   else{
	prevWord = curWord;
	repeat = 0;
   } // end else
   curWord = ""; // set curWord
>>>>>>> c1b3076211ad17e3349e577a5b0a46b617255d92
}  // end checkDupes

/**
*  Checks to see if a character is a delimiter
*
*  @param C  the current character
*
*  @return True if chracter is a delimiter. False otherwise
*/
private static boolean isDelimit (char C)
{
   for (int i = 0; i < delimits.length; i++)
   if (C == delimits [i])
      return (true);
   return (false);
}

} // end class Stutter
