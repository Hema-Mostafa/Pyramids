/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;

import doa.PyramidDoaImpl;
import java.util.List;
import java.util.stream.Collector;
import static java.util.stream.Collectors.toList;
import models.Pyramid;

/**
 *
 * @author Ibrahim
 */
public class Pyramids {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         PyramidDoaImpl pyramidDoaImpl = new PyramidDoaImpl();
         List<Pyramid> list = pyramidDoaImpl.getAllPyramids("pyramids.csv");
         double midean;
         int firstQurtileIndex , thirdQurtileIndex;
         
         
       // First Do Some Processing on pyramids list
        PyramidAllOperations.setMissingHieght(list);
        PyramidAllOperations.sortByHeight(list);
        
        List<Pyramid> newPyramids = list.stream().limit(50).collect(toList());
        for(Pyramid p :newPyramids)
            System.out.println("Height =  "+Math.round(p.getHeight()));
        
        
        // Get Midean of pyramids list
        midean=PyramidAllOperations.getMedian(newPyramids);
        System.out.println("The Midean of all Pyramids By Thier Hight = " + midean );
        // Get FirstQurtile 
        firstQurtileIndex = PyramidAllOperations.getFirstQuartile(newPyramids);
        System.out.println("The First Quartile Index = " + firstQurtileIndex + " Withe Value = " + list.get(firstQurtileIndex));
        
        // Get Third Qurtile
        thirdQurtileIndex = PyramidAllOperations.getThirdQuartile(newPyramids);
       
        System.out.println("The Third Quartile Index = " + thirdQurtileIndex + " With Value = " + list.get(thirdQurtileIndex));
        
           
    }
    
}
