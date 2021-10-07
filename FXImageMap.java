/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcardgame;

import java.lang.Double;

/**
 *
 * @author RMEYSSO
 */
public class FXImageMap {
    
    private static String numimap[] = new String[]
    {
        "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"
    };
    
    /*private String flushimap[] = new String[]
    {
        "coeur", "trefle", "pique", "carreau"
    };*/
   
    
    public FXImageMap(){
        
        
        
    }
    
    public static String GetCardPath(int num){
        
        String cp=null;
        
        double n = (double)num / 13.0;
         
        //System.out.println("\nn : " + n + " " + Double.compare(n, 1.0) );
        if(Double.compare(n, 1.0) <= 0)
        {
            //System.out.println("1.0");
           //Ajouter chemin dossier     
            cp = new String("Coeur/carte" + numimap[num-1] + "coeur.png");
                        
        }
        else if(Double.compare(n, 2.0) <= 0)
        {
           // System.out.println("2.0");
            cp = new String("Trefle/carte" + numimap[num-14] + "trefle.png");
            
        }
        else if(Double.compare(n, 3.0) <= 0)
        {
            //System.out.println("3.0");
            cp = new String("Pique/carte" + numimap[num-27] + "pique.png");
        }
        else if(Double.compare(n, 4.0) <= 0)
        {
            //System.out.println("4.0");
            cp = new String("Carreau/carte" + numimap[num-40] + "carreau.png");
        }
        //System.out.println("\ncp : " + cp );
                
        return cp;
        
    }
    
    
    public static void ListingPath(){
        
        String path ;
        
        System.out.println("");
        
        int i;
        for(i = 1;i < 53;i++)
        {
            path = FXImageMap.GetCardPath(i);
            System.out.println("path : " + path);
            
        }
        
    }
    
    
}
