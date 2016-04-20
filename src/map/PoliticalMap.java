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
        File f = new File("C:\\Users\\hcps-walterspa\\Documents\\NetBeansProjects\\PurpleAmerica\\src\\data\\USA.txt");
        Scanner scan = new Scanner(f);
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
}
