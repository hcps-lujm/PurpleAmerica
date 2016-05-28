/*
 * Political Map Project
 * Names: Jessica Lu, Peyton Walters, Kevin Duong
 * Block: 7
 * 
 * Program Purpose: The purpose of this program is to display the states and 
 * counties in America and determine their political status. Using the colors
 * blue (representing democrats) and red (representing republicans), the program
 * displays the respected county or state with a shade of purple that 
 * demonstrates the political preference of an area with a more red shade of 
 * purple showing a more republican area and so on. As for the extra functionality,
 * the program also creates a pie graph for the different statistics (Kevin),
 * writes the name of the state on the corresponding state (Jessica), and
 * displays statistics (Peyton). 
 *
 *
 * Algorithm: The program creates a dynamically sized jFrame based on the file
 * selected and reads in points from the file given to create an image of the
 * desired area. Then, using hash maps, the program reads in the file that
 * shows the coloring of that area. Using the place as a key, it uses the 
 * formulas given by the program creator to determine the RGB value of an area.
 * 
 * Future/possible improvements: As far as possible improvements, our group could
 * have had less procrastination on the extra functionality while working on the
 * project. We could have also done more with our extra functionality as far as
 * improving their quality and the run time. 
 *
 */
package map;

/**
 *
 * @author 
 */
public class PoliticalMap {

    /**
     * Calls the PurpAm class and makes an instance to run the program
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        //calls a\]n instance of the PurpAm class
        PurpAm map = new PurpAm("USA", 1960); 
    }  
}
