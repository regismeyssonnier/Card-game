/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcardgame;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 *
 * @author RMEYSSO
 */
public class FXcardgame extends Application {
    
    FXCGRules cgr = new FXCGRules();
    /*Card CT[] = new Card[52];
    int nbcard = 0;*/
    
    @Override
    public void start(Stage primaryStage) {
        
        
        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);
        // Create Image and ImageView objects
        Image image = new Image(getClass().getResourceAsStream("sallejeu.png"));
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        
        Text P1Textscore = new Text();
        P1Textscore.setX(10);
        P1Textscore.setY(30);
        P1Textscore.setText("Joueur 1:");
        P1Textscore.setFont(Font.font ("Verdana", 20));
        P1Textscore.setFill(Color.RED);
        
        Text P1Textscorenb = new Text();
        P1Textscorenb.setX(120);
        P1Textscorenb.setY(30);
        P1Textscorenb.setText("0");
        P1Textscorenb.setFont(Font.font ("Verdana", 20));
        P1Textscorenb.setFill(Color.RED);
        
        Text P2Textscore = new Text();
        P2Textscore.setX(400);
        P2Textscore.setY(30);
        P2Textscore.setText("Joueur 2:");
        P2Textscore.setFont(Font.font ("Verdana", 20));
        P2Textscore.setFill(Color.RED);
        
        Text P2Textscorenb = new Text();
        P2Textscorenb.setX(510);
        P2Textscorenb.setY(30);
        P2Textscorenb.setText("0");
        P2Textscorenb.setFont(Font.font ("Verdana", 20));
        P2Textscorenb.setFill(Color.RED);
        
        /*Image imagec = new Image(getClass().getResourceAsStream(FXImageMap.GetCardPath(1)), 75, 100, true, true);
        ImageView imageViewc1 = new ImageView();
        imageViewc1.setImage(imagec);
        imageViewc1.setTranslateX(400);
        imageViewc1.setTranslateY(250);*/
        
        /*Card c1 = new Card(1, 75, 100, true);
        c1.SetX(150);
        c1.SetY(200);
        
        Card c2 = new Card(14, 75, 100, true);
        c2.SetX(230);
        c2.SetY(200);
        
        Card c3 = new Card(27, 75, 100, true);
        c3.SetX(400);
        c3.SetY(200);
        
        Card c4 = new Card(40, 75, 100, true);
        c4.SetX(480);
        c4.SetY(200);*/
        
        
        
        Image inewgame = new Image(getClass().getResourceAsStream("new_game.png"), 200, 100, true, true);
        ImageView iViewnewgame = new ImageView();
        iViewnewgame.setImage(inewgame);
        iViewnewgame.setTranslateX(10);
        iViewnewgame.setTranslateY(360);
        iViewnewgame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                
                cgr = new FXCGRules();
                                
                //delete card on table
                root.getChildren().remove(8, root.getChildren().size());
                primaryStage.show();
                
                P1Textscorenb.setText("0");
                P2Textscorenb.setText("0");
                
                
            }
            
        });
        
        
        Image icard = new Image(getClass().getResourceAsStream("card.png"), 150, 150, true, true);
        ImageView iViewcard = new ImageView();
        iViewcard.setImage(icard);
        iViewcard.setTranslateX(250);
        iViewcard.setTranslateY(340);
        iViewcard.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                
                if(cgr.GetGameStart() == false){
                    cgr.StartGame();
                    cgr.BlendCard();
                    cgr.BlendCard();
                    cgr.SetPosCard(150);
                    cgr.SetPosYCard(170);
                    
                }
                
                if(cgr.IsEndGame() == false){
                    
                    int numc = cgr.GetCard();
                    Card c = new Card(numc, 50, 75, true);
                    c.SetX(cgr.GetPosCard());
                    c.SetY(cgr.GetPosYCard());
                    
                    
                    
                    root.getChildren().add(c.GetView());
                    cgr.SetPosCard(cgr.GetPosCard()+55);
                    cgr.SetPlayerBegin(true);
                    
                    cgr.SetScorePlayer(cgr.GetNumPlayer(), cgr.GetCardValue(numc));
                    if(cgr.GetNumPlayer() == 1){
                        P1Textscorenb.setText(String.valueOf(cgr.GetScorePlayer(cgr.GetNumPlayer())));
                    
                    }
                    else
                    {
                        P2Textscorenb.setText(String.valueOf(cgr.GetScorePlayer(cgr.GetNumPlayer())));
                        
                    }
                    
                    if(cgr.GetScorePlayer(cgr.GetNumPlayer()) >= 21)
                    {
                        if(cgr.GetNumPlayer() == 1)
                        {
                            cgr.SetPosCard(170);
                            cgr.SetPosYCard(cgr.GetPosYCard()+78);
                            cgr.ChangePlayer();
                            cgr.SetPlayerBegin(false);
                        }
                        else
                        {
                            if(cgr.GetPlayerBegin() == true){
                                cgr.EndGame();
                                
                                int pw = cgr.GetPlayerWinner();
                                if(pw == 1){
                                    P1Textscorenb.setText(String.valueOf(cgr.GetScorePlayer(1)) + "  Gagné");
                                    P2Textscorenb.setText(String.valueOf(cgr.GetScorePlayer(2)) + "  Perdu");
                                }
                                else if(pw == 2){
                                    P1Textscorenb.setText(String.valueOf(cgr.GetScorePlayer(1)) + "  Perdu");
                                    P2Textscorenb.setText(String.valueOf(cgr.GetScorePlayer(2)) + "  Gagné");
                                                                        
                                }
                                else
                                {
                                    P1Textscorenb.setText(String.valueOf(cgr.GetScorePlayer(1)) + "  Egalité");
                                    P2Textscorenb.setText(String.valueOf(cgr.GetScorePlayer(2)) + "  Egalité");
                                    
                                }
                                
                    
                            }
                            
                        }
                        
                        
                    }
                    
                    
                    
                }
                
            }
            
        });
        
        
        Image istand = new Image(getClass().getResourceAsStream("stand.png"), 150, 150, true, true);
        ImageView iViewstand = new ImageView();
        iViewstand.setImage(istand);
        iViewstand.setTranslateX(420);
        iViewstand.setTranslateY(340);
        iViewstand.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                
                if(cgr.GetNumPlayer() == 1){
                    cgr.SetPosCard(170);
                    cgr.SetPosYCard(cgr.GetPosYCard()+78);
                    cgr.ChangePlayer();
                    cgr.SetPlayerBegin(false);
                    
                }
                else
                {
                    if(cgr.GetPlayerBegin() == true){
                        cgr.EndGame();
                        
                        int pw = cgr.GetPlayerWinner();
                        if(pw == 1){
                            P1Textscorenb.setText(String.valueOf(cgr.GetScorePlayer(1)) + "  Gagné");
                            P2Textscorenb.setText(String.valueOf(cgr.GetScorePlayer(2)) + "  Perdu");
                        }
                        else if(pw == 2){
                            P1Textscorenb.setText(String.valueOf(cgr.GetScorePlayer(1)) + "  Perdu");
                            P2Textscorenb.setText(String.valueOf(cgr.GetScorePlayer(2)) + "  Gagné");

                        }
                        else
                        {
                            P1Textscorenb.setText(String.valueOf(cgr.GetScorePlayer(1)) + "  Egalité");
                            P2Textscorenb.setText(String.valueOf(cgr.GetScorePlayer(2)) + "  Egalité");

                        }
                                
                    
                    }
                }
                
                
            }
            
        });
                
        
        root.getChildren().add(imageView);
        root.getChildren().add(P1Textscore);
        root.getChildren().add(P1Textscorenb);
        
        root.getChildren().add(P2Textscore);
        root.getChildren().add(P2Textscorenb);
        
        /*root.getChildren().add(c1.GetView());
        root.getChildren().add(c2.GetView());
        root.getChildren().add(c3.GetView());
        root.getChildren().add(c4.GetView());*/
        
        root.getChildren().add(iViewnewgame);
        root.getChildren().add(iViewcard);
        root.getChildren().add(iViewstand);
        
        primaryStage.setTitle("FXcard Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        
       /* FXCGRules cgr = new FXCGRules();
        cgr.NewNumberRandom(52);
        cgr.ShowNum();
        cgr.BlendCard();
        cgr.ShowNumInGame();
        //cgr.BlendCard();
        //cgr.ShowNum();
        
        int c = cgr.GetCard();
        System.out.println("\nget " + c);
        c = cgr.GetCard();
        System.out.println("\nget " + c);
        c = cgr.GetCard();
        System.out.println("\nget " + c);
        cgr.ShowNumOut();
        
        cgr.ShowNumInGame();
        
        cgr.BlendCard();
        cgr.ShowNumInGame();
        
        c = cgr.GetCard();
        System.out.println("\nget " + c);
        c = cgr.GetCard();
        System.out.println("\nget " + c);
        c = cgr.GetCard();
        System.out.println("\nget " + c);
        cgr.ShowNumOut();
        
        cgr.ShowNumInGame();
        
        FXImageMap.ListingPath();*/
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
