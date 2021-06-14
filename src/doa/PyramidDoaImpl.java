/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Pyramid;

/**
 *
 * @author Ibrahim
 */
public class PyramidDoaImpl implements PyramidDoa{

    @Override
    public List<Pyramid> getAllPyramids(String path) {
        List <Pyramid> pyramidsList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(path));
            if(sc.hasNextLine())    
                sc.nextLine();
            while( sc.hasNextLine()){
                
                String line=sc.nextLine();
                String [] parts=line.split(",");
                
                
                double height = parts[7].isEmpty()? 0:Double.parseDouble(parts[7]);
  
                Pyramid p = new Pyramid(parts[0],parts[2],parts[4],height);
                 
                pyramidsList.add(p);
            
            
        }
        }catch (FileNotFoundException ex) {
           ex.getStackTrace();
            System.out.println("Pyramids Doa Impl Error");
        }
        
        return pyramidsList;
        
        
        
    }
    
}
