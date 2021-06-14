/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramids;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import models.Pyramid;

/**
 *
 * @author Ibrahim
 */
public class PyramidAllOperations {
    
    private  static double getMean(List<Pyramid> pyramidsList){
    
        double sum = 0;
        for(int i=0 ; i < pyramidsList.size() ; i++){
            
            sum+= pyramidsList.get(i).getHeight();
            
        }
        
        return sum / pyramidsList.size();
    
    }
    
    public  static void setMissingHieght(List<Pyramid> pyramids){
    
    double mean = getMean(pyramids);
    
    for(Pyramid p : pyramids){
        if(p.getHeight() == 0)
            p.setHeight(mean);
    }
    
    }
    
    public static List<Pyramid> sortByHeight(List <Pyramid> pyramids){
    
       pyramids.sort(Comparator.comparing(p-> p.getHeight()));
       return pyramids;
       
    }
    
    
    public static double getMedian(List <Pyramid> list){
    
        // By Default list is sorted
//        List<Pyramid> list = sortByHeight(pyramids);
        
        List<Pyramid> medianList = new ArrayList<>();
        double mideanVal;
        
        if(list.size() % 2 == 0 ){
            medianList.add(list.get(list.size() / 2  - 1));
            medianList.add(list.get(list.size() / 2));
            
            mideanVal = getMean(medianList);  // get mean of list contain two object
            return mideanVal;
        }
            
            
        else{
            mideanVal =list.get(list.size() / 2 ).getHeight();
        }
            return mideanVal;
    
    }
    
    // this function retrun index of first quartile
    public static int getFirstQuartile(List pyramids){
     
       return (int) (.25 * pyramids.size());
    
    } 
    
    public static int getThirdQuartile(List pyramids){
     
     return  (int) (.5 * pyramids.size());
     
    } 
    
}
