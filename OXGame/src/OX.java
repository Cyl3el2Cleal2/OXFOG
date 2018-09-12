import java.util.Scanner;

public class OX {
    private static Scanner in =new Scanner(System.in);
    private static int row;
    private static int col;
    private char currentPlayer;
    private char[][] table=new char[3][3];
    private int scoreX;
    private int scoreO;
    private int scoreDraw;
    private int round;
    public OX(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                table[i][j]='-';
            }
        }
        scoreX=0;
        scoreO=0;
        scoreDraw=0;
        currentPlayer='X';
        round=0;
    }
    public char getCurrentPlayer(){

        return currentPlayer;
    }
    public int getScoreDraw(){
            return scoreDraw;
    }
    public int getScoreO(){
            return scoreO;
    }
    public int getScoreX(){
            return scoreX;
    }
    public int getRound(){
        return round;
    }
    public String get(int col,int row){
        return ""+table[row][col];
    }
    public String getTable(){
        String result="  0 1 2\n";
        for(int i=0;i<3;i++){
            result=result+i;
            for(int j=0;j<3;j++){
                result=result+" "+(char)table[i][j];
            }
            if(i<2) {
                result = result + "\n";
            }
        }
        return result;
    }
    public void switchPlayer(){
        round++;
        if(currentPlayer=='X'){
            currentPlayer='O';
        }else{
            currentPlayer='X';
        }
    }
    public void reset(){
        round=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                table[i][j]='-';
            }
        }
    }
    public boolean put(int col,int row){
        try {
            if (table[row][col] == '-') {
                set(col, row);
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }
    public void set(int col,int row){
        table[row][col]=getCurrentPlayer();
    }

    public boolean checkWin(){
        if(table[0][0]==currentPlayer&&table[0][1]==currentPlayer&&table[0][2]==currentPlayer){
            return true;
        }else if(table[1][0]==currentPlayer&&table[1][1]==currentPlayer&&table[1][2]==currentPlayer){
            return true;
        }else if(table[2][0]==currentPlayer&&table[2][1]==currentPlayer&&table[2][2]==currentPlayer){
            return true;
        }else if(table[0][0]==currentPlayer&&table[1][0]==currentPlayer&&table[2][0]==currentPlayer){
            return true;
        }else if(table[0][1]==currentPlayer&&table[1][1]==currentPlayer&&table[2][1]==currentPlayer){
            return true;
        }else if(table[0][2]==currentPlayer&&table[1][2]==currentPlayer&&table[2][2]==currentPlayer){
            return true;
        }else if(table[0][0]==currentPlayer&&table[1][1]==currentPlayer&&table[2][2]==currentPlayer){
            return true;
        }else if(table[2][0]==currentPlayer&&table[1][1]==currentPlayer&&table[0][2]==currentPlayer) {
            return true;
        }
        return false;
    }
    public void printTable(){
        System.out.println(getTable());
    }
    public void printAllScore(){
        addScore();
        System.out.println("X win "+getScoreX());
        System.out.println("O win "+getScoreO());
        System.out.println("Draw "+getScoreDraw());
    }
    public void input(){
        System.out.print(getCurrentPlayer() + " (col): ");
        col=in.nextInt();
        System.out.print(getCurrentPlayer() + " (row): ");
        row=in.nextInt();
    }
    public void addScore(){
        if(getRound()==8){
            scoreDraw++;
        }
        else if(getCurrentPlayer()=='X'){
           scoreX++;
        }
        else if(getCurrentPlayer()=='O'){
           scoreO++;
        }
    }
    public void addScoreOfForm(){
        if(getCurrentPlayer()=='X'){
            scoreX++;
        }
        else if(getCurrentPlayer()=='O'){
            scoreO++;
        }
    }
    public boolean isDraw(){
        if(getRound()==8){
            scoreDraw++;
            return true;
        }
       return false;
    }

    public static void main(String[] arg){
        OX ox=new OX();
        while(ox.getRound()<=9){
            ox.printTable();
            ox.input();
            if(ox.put(col,row)){
                if(ox.checkWin()||ox.getRound()==8){
                    ox.printTable();
                    ox.printAllScore();
                    break;
                }else{
                    ox.switchPlayer();
                }
            }else{
                System.out.println("This Blank");
            }
        }
    }
}
