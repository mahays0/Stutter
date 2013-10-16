// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 2, section 2.5, page 80

import java.io.*;

/**
 * Stutter checks for repeat words in a text file.
 * It prints a list of repeat words, by line number.
 * Stutter will accept standard input or a list
 * of file names.
 * @author Jeff Offutt, June 1989 (in C), Java version March 2003 
 */
class Stutter
{
  // Class variables used in multiple methods.
  private static boolean lastdelimit = true;
  private static String curWord = "", prevWord = "";
  private static char delimits [] =
          {'	', ' ', ',', '.', '!', '-', '+', '=', ';', ':', '?',
           '&', '{', '}', '\\'}; // First char in list is a tab

/**
 * main parses the arguments, decides if stdin
 * or a file name, and calls Stut().
 * @param args the command line arguments passed to Stutter
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
 * Stut() reads all lines in the input stream, and
 * finds words. Words are defined as being surrounded
 * by delimiters as defined in the delimits[] array.
 * Every time an end of word is found, checkDupes()
 * is called to see if it is the same as the
 * previous word.
 * @param inFile the file being read to look for duplicates
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
 * checkDupes() checks to see if the globally defined
 * curWord is the same as prevWord and prints a message
 * if they are the same.
 * 
 * @param curWord	the current word
 * @param prevWord	the previous word
 */
private static void checkDupes (int line)
{
   if (lastdelimit)
   return; // already checked, keep skipping
   
   lastdelimit = true;
   if (curWord.equals(prevWord))
   {
	// FIXME: only print at end of repeated sequence. print # repetitions in a row.
      System.out.println ("Repeated word on line " + line + ": " +
                        prevWord+ " " + curWord);
   } // end if
   else{
	// TODO: set prevWord
   }
   prevWord = curWord;
   curWord = "";
}  // end checkDupes

/**
* Checks to see if a character is a delimiter.
*
* @param  c is the character being sent into the function to be checked if it is in the delimit array
* @return value of false returns if c is not in the delimits array
*         value of true is returned if it the character is contained in the array
*/
private static boolean isDelimit (char C)
{
   for (int i = 0; i < delimits.length; i++)
   if (C == delimits [i])
      return (true);
   return (false);
}

} // end class Stutter
