/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package map;

import edu.princeton.cs.introcs.*;
import java.awt.Color;
import java.io.*;
import java.util.*;


/**
 *
 * @author hcps-lujm
 */
public class PurpAm{
    public PurpAm(String place, int date) throws Exception{
        Draw d = new Draw("Purple America");
        place = "USA";
        File f = new File("src\\data\\" + place + ".txt");
        Scanner scan = new Scanner(f); //takes data from the USA-country.txt doc
        double[] bounds = new double[4]; // getting bounds for max/min lat/long
        bounds[0] = scan.nextDouble();
        bounds[2] = scan.nextDouble();
        bounds[1] = scan.nextDouble();
        bounds[3] = scan.nextDouble();
       
        double xVal = Math.abs((bounds[0]-bounds[1])/(bounds[2]-bounds[3])); // Setting the Y so it is always 500 and dynamically scaling the X
        d.setCanvasSize((int) (xVal*500), 500);
        d.setXscale(bounds[0], bounds[1]);
        d.setYscale(bounds[2], bounds[3]);
        
        //EXTRA FUNCTIONALITY
        //d.text();
        HashMap<String, Color> colors = colors(place, 2000); // Getting all the colors for the map
        
        int times = scan.nextInt(); // number of counties/states
        for (int i = 0; i < times; i++) {
            scan.nextLine(); // skipping unimportant stuff
            scan.nextLine();
            String county = scan.nextLine();
            scan.nextLine();
            int numPoints = scan.nextInt(); // number of points in the polygon
            double[] x = new double[numPoints];
            double[] y = new double[numPoints];
            for (int j = 0; j < numPoints; j++) { // getting all the points and putting them in the array
                x[j] = scan.nextDouble();
                y[j] = scan.nextDouble();
            }
            // Getting the color for each county
            // If the database doesn't have the 
            Color c;
            try{
                c = colors.get(county);
            }
            catch(Exception e){
                c = Draw.BLACK;
            }
            
            d.setPenColor(c); // fill area coloring
            d.filledPolygon(x, y);
            d.setPenColor(Draw.BLACK); // border drawing
            d.polygon(x, y);
        }
        
    }
    
    static HashMap<String, Color> colors(String f, int d) throws FileNotFoundException{
        int date = d;
        File AK= new File("src\\data\\" + f + date + ".txt");
        Scanner scanAK = new Scanner(AK); 
        scanAK.nextLine();  //this is used to get rid of the first line which just has the president names and other parties
        HashMap<String, Color> colors = new HashMap(); //this array list inserts all the color values which are the the colors for each party
        //this is used to go through the whole file and stop when the next line is empty
        while (scanAK.hasNext()) {
            String s = scanAK.nextLine(); // Getting next line of input
            String[] values = s.split(","); //split the string on each line when it scans a ,
            float rep = Integer.parseInt(values[1]); //changed the second, third, and forth to ints since they are the RGB values
            float dem = Integer.parseInt(values[2]); //
            float ind = Integer.parseInt(values[3]); //
            
            float rgbRep = (rep / (rep + dem + ind));//these three forumlas are the forumlas given from the purple america pdf
            float rgbDem = (dem / (rep + dem + ind));
            float rgbInd = (ind / (rep + dem + ind));
            
            colors.put(values[0], new Color(rgbRep, rgbInd, rgbDem)); //combine the colors for rgb
        }
        return colors;
    }
    
}
