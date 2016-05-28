/*
 * Names: Jessica Lu, Peyton Walters, Kevin Duong
 * Block 7
 *
 * PurpAm Method: This method scans in a designated file which containts
 * the coordinates of the area. It uses those points and draws in onto a 
 * dynamically sized jFrame. It also colors in the area of a map
 *
 * Hashmap Method: This method is used to create a colored version of the desired 
 * area. Using hashmaps and a designated file, the program reads in the color
 * values in the file and uses the formulas given to create an RGB color
 * representation onto the jFrame, thus showing the political heat of an area.
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

    /**
     * Uses a read in file to scale a jFrame and plot the given coordinates
     * onto the screen to display an image of the desired area
     * 
     * @param place
     * @param date
     * @throws Exception
     */
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
        ArrayList<String> states = new ArrayList<>();
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
            
            //Extra Functionality
            //Writes the name of the states
            if(!states.contains(county)){
                double sum = 0;               
                for(int k = 0; k < numPoints; k++){//finds average of the x coordinates
                    sum = sum + x[k];
                }
                double averagex = sum / x.length;               
                sum = 0;
                for(int m = 0; m < numPoints; m++){//finds average of the y coordinates
                    sum = sum + y[m];
                }
                double averagey =  sum / y.length;
               
                //Manually adjusted "centers" of the state based off of the average
                //coordinate found above
                if(county.equals("Virginia")){
                    d.text(averagex += 1.5, averagey, county);
                }
                if(county.equals("Kentucky")){
                    d.text(averagex += 0.75, averagey, county);
                }  
                if(county.equals("New Hampshire")){
                    d.text(averagex += 3, averagey -= 1, county);
                } 
                if(county.equals("North Dakota")){
                    d.text(averagex -= 3, averagey, county);
                } 
                if(county.equals("South Dakota")){
                    d.text(averagex -= 3, averagey += 1, county);
                } 
                if(county.equals("Nebraska")){
                    d.text(averagex -= 3, averagey, county);
                }  
                if(county.equals("Kansas")){
                    d.text(averagex -= 3, averagey -= 1, county);
                }
                if(county.equals("Oklahoma")){
                    d.text(averagex, averagey += 2, county);
                }
                if(county.equals("Texas")){
                    d.text(averagex, averagey += 2, county);
                }
                if(county.equals("New Mexico")){
                    d.text(averagex, averagey += 1, county);
                }
                if(county.equals("Montana")){
                    d.text(averagex += 3, averagey += 1, county);
                }    
                if(county.equals("Idaho")){
                    d.text(averagex, averagey -= 2, county);
                }
                if(county.equals("Oregon")){
                    d.text(averagex, averagey -= 1, county);
                }
                if(county.equals("Nevada")){
                    d.text(averagex -= 2, averagey += 3, county);
                }
                if(county.equals("Arizona")){
                    d.text(averagex += 2, averagey, county);
                }
                if(county.equals("Missouri")){
                    d.text(averagex -= 1, averagey, county);
                }
                if(county.equals("Arkansas")){
                    d.text(averagex -= 1, averagey, county);
                }
                if(county.equals("Mississippi")){
                    d.text(averagex += 1, averagey, county);
                }
                if(county.equals("Georgia")){
                    d.text(averagex -= 1, averagey, county);
                }
                if(county.equals("Florida")){
                    d.text(averagex -= 1, averagey, county);
                }
                if(county.equals("South Carolina")){
                    d.text(averagex += 2, averagey, county);
                }
                if(county.equals("North Carolina")){
                    d.text(averagex += 1, averagey, county);
                } 
                if(county.equals("Illinois")){
                    d.text(averagex, averagey += 2, county);
                }
                if(county.equals("Indiana")){
                    d.text(averagex += 1, averagey += 2, county);
                }
                if(county.equals("Pennsylvania")){
                    d.text(averagex -= 2, averagey, county);
                }
                if(county.equals("Maryland")){
                    d.text(averagex += 3, averagey -= 1, county);
                }
                if(county.equals("New Jersey")){
                    d.text(averagex += 3, averagey, county);
                }
                if(county.equals("Massachusetts")){
                    d.text(averagex += 1, averagey += 0.5, county);
                }  
                if(county.equals("Connecticut")){
                    d.text(averagex += 3, averagey -= 0.5, county);
                }       
                if(county.equals("Delaware")){
                    d.text(averagex += 4, averagey, county);
                }  
                if(county.equals("Michigan")){
                    d.text(averagex += 4, averagey -= 1, county);
                }
                if(county.equals("Washington")){
                    d.text(averagex += 3, averagey -= 3, county);
                } 
                if(county.equals("Wisconsin")){
                    d.text(averagex, averagey -= 2, county);
                }                   
                if(county.equals("District of Columbia")){
                    d.text(0, 0, "");
                }               
                else{
                    d.text(averagex, averagey, county);
                }
                //WriteStateName(d, averagex, averagey, county);
            }
            states.add(county);
        }
        
        
    }
    
    /*public static void WriteStateName(Draw d, double averagex, double averagey, String county){
        d.setPenColor(Draw.BLACK);
        if(county.equals("Washington")){
                    d.text(averagex += 2, averagey -= 2, county);
        }
            d.text(averagex, averagey, county);

    }*/
    
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
