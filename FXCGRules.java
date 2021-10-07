/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxcardgame;

import java.lang.Math;

/**
 *
 * @author RMEYSSO
 */
public class FXCGRules {
    
    
    int num[];
    int numr[];
    private int _numr[];
    int nbcardingame;
    int nums[];
    int nbcardout;
    boolean game_start;
    boolean end_game;
    int num_player;
    boolean player_begin;
    int score_player1;
    int score_player2;
    
    private int card_value[] = new int[]{
        11, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 
        11, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2,
        11, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2,
        11, 10, 10, 10, 10, 9, 8, 7, 6, 5, 4, 3, 2
          
    };
    
    private double pos_card;
    private double posY_card;
    
    public FXCGRules() {
        
        this.game_start = false;
        this.end_game = false;
        this.num_player = 1;
        this.score_player1 = 0;
        this.score_player2 = 0;
        
        num = new int[52];
        numr = new int[52];
        nums = new int[52];
        
        int i;
        for(i = 0;i < 52;i++)
        {
            num[i] = i+1;
            numr[i] = i+1;
            
        }
        
        this.nbcardingame = 52;
        this.nbcardout = 0;
        
    }
    
    public void StartGame()
    {
        this.game_start = true;        
    }
    
    public boolean GetGameStart(){
        
        return this.game_start;
    }
   
    public void EndGame(){
        this.end_game = true;
        
    }
    
    public boolean IsEndGame(){
        return this.end_game;
    }
    
    public void ChangePlayer(){
        this.num_player++;
    }
    
    public int GetNumPlayer(){
        return this.num_player;
    }
    
    public void SetPlayerBegin(boolean b){
        this.player_begin = b;
    }
    
    public boolean GetPlayerBegin(){
        return this.player_begin;        
    }
    
    public void SetScorePlayer(int nump, int sc){
        
        if(nump == 1){
            this.score_player1 += sc;
        }
        else
        {
            this.score_player2 += sc;
        }
        
    }
    
    public int GetScorePlayer(int nump){
        
        if(nump == 1){
            return this.score_player1;
        }
        else
        {
            return this.score_player2;
        }
        
    }
    
    public int GetPlayerWinner(){
        
        if((this.score_player1 <=  21) && (this.score_player2 <=  21)){
        
            if(this.score_player1 > this.score_player2){
                return 1;
            }
            else if(this.score_player1 < this.score_player2){
                return 2;
            }
            else
            {
                return 3;
            }
        
        }
        else
        {
            if((this.score_player1 >  21) && (this.score_player2 >  21))
            {
                return 3;
            }
            else if(this.score_player1 >  21)
                return 2;
            else if(this.score_player2 >  21)
                return 1;
            else
                return 3;
            
        }
        
    }
       
    public void SetPosCard(double pos){
        this.pos_card = pos;
    }
    
    public double GetPosCard(){
        return this.pos_card;
    }
    
    public void SetPosYCard(double pos){
        this.posY_card = pos;
    }
    
    public double GetPosYCard(){
        return this.posY_card;
    }
    
    public void BlendCard()
    {
        int i;
        int nc;
        int m;
        for(i = 0;i < this.nbcardingame;i++)
        {
            nc = this.NewNumberRandom(this.nbcardingame);
            m = numr[i];
            numr[i] = numr[nc-1];
            numr[nc-1] = m;
                        
            
        }
        
        
    }
    
    public int GetCardValue(int num){
        
        return this.card_value[num-1];
    }
    
    public int GetCard()
    {
        int card;
        int nc;
        int sz;
        
        //get num card
        nc = this.NewNumberRandom(this.nbcardingame)-1;
        card = numr[nc];
        sz = this.nbcardingame;
        
        this.nbcardingame--;
        _numr = new int[this.nbcardingame];
        
        int i;
        for(i = 0;i < nc;i++)
        {
            _numr[i] = numr[i];
        }
        for(i = nc+1;i < sz;i++)
        {
            _numr[i-1] = numr[i];
        }
        
        numr = _numr;
        
        nums[this.nbcardout] = card;
        this.nbcardout++;
        
        return card;
        
    }
    
    
    public int NewNumberRandom(int n){
        
        n--;
        int num =  (int)((Math.random() * n) + 1); 
        //System.out.println("new Number : " + num);
        
        return num;
        
    }
    
    
    public void ShowNum()
    {
        int i;
        
        System.out.println("");
        for(i = 0;i < 52;i++)
        {
             System.out.print(" " + num[i]);
        }
        
        
    }
    
    public void ShowNumInGame()
    {
        int i;
        
        System.out.println("");
        for(i = 0;i < this.nbcardingame;i++)
        {
             System.out.print(" " + numr[i]);
        }
        
        
    }
    
    public void ShowNumOut()
    {
        int i;
        
        System.out.println("");
        for(i = 0;i < this.nbcardout;i++)
        {
             System.out.print(" " + nums[i]);
        }
        
        
    }
    
    
}
