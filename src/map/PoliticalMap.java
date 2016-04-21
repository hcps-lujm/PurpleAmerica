/*
 * Political Map Project
 * Name: 
 * Block:
 * 
 * Program Purpose:
 *
 * Algorithm:
 * 
 * Future/possible improvements:
 *
 */
package map;
import edu.princeton.cs.introcs.*;
import java.awt.Color;
import java.io.*;
import java.util.*;

/**
 *
 * @author 
 */
public class PoliticalMap {
    public static void main(String[] args) throws Exception{
        Draw d = new Draw("Purple America");
        d.setCanvasSize(1000, 500);
        File f = new File("C:\\Users\\hcps-duongth\\Documents\\Junior Year Classes\\Programming\\PurpleAmerica\\PurpleAmerica\\src\\data\\USA-county.txt");
        Scanner scan = new Scanner(f); //takes data from the USA-country.txt doc
        double[] bounds = new double[4];
        bounds[0] = scan.nextDouble();
        bounds[2] = scan.nextDouble();
        bounds[1] = scan.nextDouble();
        bounds[3] = scan.nextDouble();
        d.setXscale(bounds[0], bounds[1]);
        d.setYscale(bounds[2], bounds[3]);
        int times = scan.nextInt();
        for (int i = 0; i < times; i++) {
            scan.nextLine();
            scan.nextLine();
            scan.nextLine();
            scan.nextLine();
            int numPoints = scan.nextInt();
            double[] x = new double[numPoints];
            double[] y = new double[numPoints];
            for (int j = 0; j < numPoints; j++) {
                x[j] = scan.nextDouble();
                y[j] = scan.nextDouble();
            }
            d.setPenColor(Draw.BLUE);
            d.filledPolygon(x, y);
            d.setPenColor(Draw.WHITE);
            d.polygon(x, y);
        }
        
        
        
    }
    
    static ArrayList<Color> colors(String f) throws FileNotFoundException{
        File AK= new File("C:\\Users\\hcps-duongth\\Documents\\Junior Year Classes\\Programming\\PurpleAmerica\\PurpleAmerica\\src\\data\\" + f + ".txt");
        Scanner scanAK = new Scanner(AK); 
        String s = scanAK.nextLine(); //this is used to get rid of the first line which just has the president names and other parties
        ArrayList<Color> colors = new ArrayList(); //this array list inserts all the color values which are the the colors for each party
        //this is used to go through the whole file and stop when the next line is empty
        while (!s.equals("")) {
            String[] values = s.split(","); //split the string on each line when it scans a ,
            int rep = Integer.parseInt(values[1]); //changed the second, third, and forth to ints since they are the RGB values
            int dem = Integer.parseInt(values[2]); //
            int ind = Integer.parseInt(values[3]); //
            
            int rgbRep = (rep / (rep + dem + ind));//these three forumlas are the forumlas given from the purple america pdf
            int rgbDem = (dem / (rep + dem + ind));
            int rgbInd = (ind / (rep + dem + ind));
            colors.add(new Color(rgbRep, rgbInd, rgbDem)); //combine the colors for rgb
            
            s = scanAK.nextLine(); //if the next line has nothing, then end the while loop
        }
        return colors;
    }
}
