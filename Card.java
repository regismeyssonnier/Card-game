/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcardgame;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author RMEYSSO
 */
public class Card {
    
    Image imagec;
    ImageView imageViewc;
    
    public Card(int num, int width, int height, boolean ratio){
        
        imagec = new Image(getClass().getResourceAsStream(FXImageMap.GetCardPath(num)), width, height, ratio, true);
        imageViewc = new ImageView();
        imageViewc.setImage(imagec);
        
               
    }
    
    public ImageView GetView(){
        
        return this.imageViewc;
        
    }
    
    public void SetX(double x){
        
        this.imageViewc.setTranslateX(x);
        
    }
    
    public void SetY(double y){
        
        this.imageViewc.setTranslateY(y);
        
    }
    
    
}
