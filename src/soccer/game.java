package soccer;
import java.io.IOException;
import java.util.Scanner;

public class game {
    private Team team1;
    private final String ESC="\033[";

    private Team team2;
    private Ball ball;
    private table table;
    private char[][] ground;
    public boolean flag=false,flag2=false;
    public game(Team team1,Team team2,table table,Ball ball){
        this.team1=team1;
        this.team2=team2;
        this.table=table;
        this.ball=ball;
        ground=new char[table.getLength()][table.getWidth()];
        for(int i=0;i<table.getWidth();i++) {
            for (int j = 0; j < table.getLength(); j++)
                ground[j][i]=' ';
        }
        for(int i=0;i<table.getLength();i++)
            ground[i][0]='_';
        for(int i=0;i<table.getLength();i++)
            ground[i][table.getWidth()-1]='_';
        for(int i=0;i<table.getWidth();i++)
            ground[0][i]='|';
        for(int i=0;i<table.getWidth();i++)
            ground[table.getLength()-1][i]='|';
        ground[1][(table.getWidth()-table.getGateLength())/2-1]='_';
        ground[1][(table.getWidth()-table.getGateLength())/2-1+table.getGateLength()]='_';
        ground[table.getLength()-2][(table.getWidth()-table.getGateLength())/2-1]='_';
        ground[table.getLength()-2][(table.getWidth()-table.getGateLength())/2-1+table.getGateLength()]='_';
    }
    public void freeTable(){
        for(int i=0;i<team1.getPlayercounter();i++){
            ground[team1.getPlayers().get(i).getLocationX()][team1.getPlayers().get(i).getLocationY()]=' ';
        }
        for(int i=0;i<team2.getPlayercounter();i++){
            ground[team2.getPlayers().get(i).getLocationX()][team2.getPlayers().get(i).getLocationY()]=' ';
        }
        ground[ball.getLocationX()][ball.getLocationX()]=' ';
    }
    public void firstFormation(){
        freeTable();
        for(int i=0;i<team1.getPlayercounter();i++){
            if(i<2){
                team1.getPlayers().get(i).setLocationX(table.getLength()/4);
                team1.getPlayers().get(i).setLocationY(table.getWidth()/3+(i*table.getWidth()/3));
                ground[team1.getPlayers().get(i).getLocationX()][team1.getPlayers().get(i).getLocationY()]=(char)(i+97);
                team1.getPlayers().get(i).setShow((char)(i+97));
            }
            else if(i==2){
                team1.getPlayers().get(i).setLocationX(table.getLength()/2-2);
                team1.getPlayers().get(i).setLocationY(table.getWidth()/2);
                ground[team1.getPlayers().get(i).getLocationX()][team1.getPlayers().get(i).getLocationY()]=(char)(i+97);
                team1.getPlayers().get(i).setShow((char)(i+97));
            }
            else if(i==4 || i==3){
                team1.getPlayers().get(i).setLocationX(3*table.getLength()/5);
                team1.getPlayers().get(i).setLocationY(table.getWidth()/3+(i*table.getWidth()/3));
                ground[team1.getPlayers().get(i).getLocationX()][team1.getPlayers().get(i).getLocationY()]=(char)(i+97);
                team1.getPlayers().get(i).setShow((char)(i+97));
            }
        }
        for(int i=0;i<team2.getPlayercounter();i++){
            if(i<2){
                team2.getPlayers().get(i).setLocationX(3*table.getLength()/4);
                team2.getPlayers().get(i).setLocationY(table.getWidth()/3+(i*table.getWidth()/3));
                ground[team2.getPlayers().get(i).getLocationX()][team2.getPlayers().get(i).getLocationY()]=(char)(i+65);
                team2.getPlayers().get(i).setShow((char)(i+65));
            }
            else if(i==2){
                team2.getPlayers().get(i).setLocationX(table.getLength()/2+2);
                team2.getPlayers().get(i).setLocationY(table.getWidth()/2);
                ground[team2.getPlayers().get(i).getLocationX()][team2.getPlayers().get(i).getLocationY()]=(char)(i+65);
                team2.getPlayers().get(i).setShow((char)(i+65));
            }
            else if(i==4 || i==3){
                team2.getPlayers().get(i).setLocationX(2*table.getLength()/5);
                team2.getPlayers().get(i).setLocationY(table.getWidth()/3+(i*table.getWidth()/3));
                ground[team2.getPlayers().get(i).getLocationX()][team2.getPlayers().get(i).getLocationY()]=(char)(i+65);
                team2.getPlayers().get(i).setShow((char)(i+65));
            }
        }
        ball.setLocationX(table.getLength()/2);
        ball.setLocationY(table.getWidth()/2);
        ground[ball.getLocationX()][ball.getLocationY()]='0';
    }
    public void printTable(){
        for(int i=0;i<table.getWidth();i++) {
            for (int j = 0; j < table.getLength(); j++)
                System.out.print(ground[j][table.getWidth() - 1 - i]);
            System.out.println();
        }
    }
    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void play(Team team)  {
        Scanner scanner=new Scanner(System.in);
         flag=false;flag2=false;
        String ask="yourteam: 1)"+team1.getName()+"  2)"+team2.getName()+" 3)finish";
        while(!flag) {
            System.out.println(ask);
            int T = scanner.nextInt();
            if(T==3){
                flag2=true;
                break;
            }
            if (T == 1) {
                if (team1.equals(team))
                    flag = true;
            }
            else if (T == 2) {
                if (team2.equals(team))
                    flag = true;
            }
            if (!flag)
                System.out.println("its not your turn");
        }
        if(!flag2) {
           // System.out.print("("+ground[ball.getLocationX()-1][ball.getLocationY()-1]+")");
            System.out.print("player:");
            char p = scanner.next().charAt(0);
            Player movePlayer = new Player("temp", 9);
            for (int i = 0; i < team.getPlayercounter(); i++)
                if (team.getPlayers().get(i).getShow() == p)
                    movePlayer = team.getPlayers().get(i);
            System.out.print("degree: 1)0 2)90 3)180 4)270");
            int degree = scanner.nextInt();
            System.out.print("speed: ");
            int speed = scanner.nextInt();
            int d = (speed * speed) / (2 * table.getFriction() * 10);
            for (int i = 0; i < d; i++) {
                if (degree == 1) {
                    if ( ground[movePlayer.getLocationX() + 1][movePlayer.getLocationY()] == ' ') {
                        ground[movePlayer.getLocationX()][movePlayer.getLocationY()]=' ';
                        movePlayer.setLocationX(movePlayer.getLocationX() + 1);
                        ground[movePlayer.getLocationX()][movePlayer.getLocationY()]= movePlayer.getShow();
                        //System.out.println("null");
                        ClearConsole();
                        printTable();

                    } else if (ground[movePlayer.getLocationX() + 1][movePlayer.getLocationY()] == '0') {
                        if(ballMove(1, (d - i + 1) * 2, movePlayer)){
                            System.out.println("GOAL!");
                            System.out.println(team1.getName()+" : "+team1.getGoals()+"  "+team2.getName()+" : "+team2.getGoals());
                            firstFormation();
                            ClearConsole();
                            printTable();
                            break;
                        }
                        //System.out.println("ball");
                    } else if (ground[movePlayer.getLocationX() + 1][movePlayer.getLocationY()] == '|' || ground[movePlayer.getLocationX() + 1][movePlayer.getLocationY()] == '_') {
                        //hit wall
                       // System.out.println("wall");
                        degree = 3;
                    } else {
                        //System.out.println("player"+movePlayer.getShow());
                        for (int j = 0; j < team1.getPlayercounter(); j++)
                            if (team1.getPlayers().get(j).getShow() == ground[movePlayer.getLocationX() + 1][movePlayer.getLocationY()])
                                movePlayer = team1.getPlayers().get(j);
                        for (int j = 0; j < team2.getPlayercounter(); j++)
                            if (team2.getPlayers().get(j).getShow() == ground[movePlayer.getLocationX() + 1][movePlayer.getLocationY()])
                                movePlayer = team2.getPlayers().get(j);
                     //   System.out.println("endplayer"+movePlayer.getShow());
                    }
                } else if (degree == 2) {
                    if ( ground[movePlayer.getLocationX()][movePlayer.getLocationY() + 1] == ' ') {
                       // System.out.print("me"+ground[movePlayer.getLocationX()][movePlayer.getLocationY()]+"me");
                        ground[movePlayer.getLocationX()][movePlayer.getLocationY()]=' ';
                        movePlayer.setLocationY(movePlayer.getLocationY() + 1);
                        ground[movePlayer.getLocationX()][movePlayer.getLocationY()]= movePlayer.getShow();
                      //  System.out.println("null");
                        ClearConsole();
                        printTable();

                    } else if (ground[movePlayer.getLocationX()][movePlayer.getLocationY() + 1] == '0') {
                      //  System.out.println("ball");
                        if(ballMove(2, (d - i + 1) * 2, movePlayer)){
                            System.out.println("GOAL!");
                            System.out.println(team1.getName()+" : "+team1.getGoals()+"  "+team2.getName()+" : "+team2.getGoals());
                            firstFormation();
                            ClearConsole();
                            printTable();
                            break;
                        }
                    } else if (ground[movePlayer.getLocationX()][movePlayer.getLocationY() + 1] == '|' || ground[movePlayer.getLocationX()][movePlayer.getLocationY() + 1] == '_') {
                        //hit wall
                        degree = 4;
                      //  System.out.println("wall");
                    } else {
                      //  System.out.println("player"+movePlayer.getShow());
                        for (int j = 0; j < team1.getPlayercounter(); j++)
                            if (team1.getPlayers().get(j).getShow() == ground[movePlayer.getLocationX()][movePlayer.getLocationY() + 1])
                                movePlayer = team1.getPlayers().get(j);
                        for (int j = 0; j < team2.getPlayercounter(); j++)
                            if (team2.getPlayers().get(j).getShow() == ground[movePlayer.getLocationX()][movePlayer.getLocationY() + 1])
                                movePlayer = team2.getPlayers().get(j);
                      //  System.out.println("endplayer"+movePlayer.getShow());
                    }
                } else if (degree == 3) {
                    if (ground[movePlayer.getLocationX() - 1][movePlayer.getLocationY()] == ' ') {
                        ground[movePlayer.getLocationX()][movePlayer.getLocationY()]=' ';
                        movePlayer.setLocationX(movePlayer.getLocationX() - 1);
                        ground[movePlayer.getLocationX()][movePlayer.getLocationY()]= movePlayer.getShow();
                    //    System.out.println("null");
                        ClearConsole();
                        printTable();

                    } else if (ground[movePlayer.getLocationX() - 1][movePlayer.getLocationY()] == '0') {
                       // System.out.println("ball");
                        if(ballMove(3, (d - i + 1) * 2, movePlayer)){
                            System.out.println("GOAL!");
                            System.out.println(team1.getName()+" : "+team1.getGoals()+"  "+team2.getName()+" : "+team2.getGoals());
                            firstFormation();
                            ClearConsole();
                            printTable();
                            break;
                        }
                    } else if (ground[movePlayer.getLocationX() - 1][movePlayer.getLocationY()] == '|' || ground[movePlayer.getLocationX() - 1][movePlayer.getLocationY()] == '_') {
                       // System.out.println("wall");
                        degree = 1;
                    } else {

                       // System.out.println("player"+movePlayer.getShow());
                        for (int j = 0; j < team1.getPlayercounter(); j++)
                            if (team1.getPlayers().get(j).getShow() == ground[movePlayer.getLocationX() - 1][movePlayer.getLocationY()])
                                movePlayer = team1.getPlayers().get(j);
                        for (int j = 0; j < team2.getPlayercounter(); j++)
                            if (team2.getPlayers().get(j).getShow() == ground[movePlayer.getLocationX() - 1][movePlayer.getLocationY()])
                                movePlayer = team2.getPlayers().get(j);
                     //   System.out.println("end player"+movePlayer.getShow());
                    }

                } else if (degree == 4) {
                    if (ground[movePlayer.getLocationX()][movePlayer.getLocationY() - 1] == ' ') {
                        ground[movePlayer.getLocationX()][movePlayer.getLocationY()]=' ';
                        movePlayer.setLocationY(movePlayer.getLocationY() - 1);
                        ground[movePlayer.getLocationX()][movePlayer.getLocationY()]= movePlayer.getShow();
                      //  System.out.println("null");
                        ClearConsole();
                        printTable();

                    } else if (ground[movePlayer.getLocationX()][movePlayer.getLocationY() - 1] == '0') {
                        if(ballMove(4, (d - i + 1) * 2, movePlayer)){
                            System.out.println("GOAL!");
                            System.out.println(team1.getName()+" : "+team1.getGoals()+"  "+team2.getName()+" : "+team2.getGoals());
                            firstFormation();
                            ClearConsole();
                            printTable();
                            break;
                        }
                       // System.out.println("ball");
                    } else if ( ground[movePlayer.getLocationX()][movePlayer.getLocationY() - 1] == '|' || ground[movePlayer.getLocationX()][movePlayer.getLocationY() - 1] == '_') {
                        //hit wall
                      //  System.out.println("wall");
                        degree = 2;
                    } else {
                        Player temp = movePlayer;
                       // System.out.println("player"+movePlayer.getShow());
                        for (int j = 0; j < team1.getPlayercounter(); j++)
                            if (team1.getPlayers().get(j).getShow() == ground[movePlayer.getLocationX()][movePlayer.getLocationY() - 1])
                                movePlayer = team1.getPlayers().get(j);
                        for (int j = 0; j < team2.getPlayercounter(); j++)
                            if (team2.getPlayers().get(j).getShow() == ground[movePlayer.getLocationX()][movePlayer.getLocationY() - 1])
                                movePlayer = team2.getPlayers().get(j);
                      //  System.out.println("endplayer"+movePlayer.getShow());

                    }
                }
            }
        }
    }
    public boolean ballMove(int degree,int d,Player p){
        for(int i=0;i<d;i++) {
            if (degree == 1) {
                if (ground[ball.getLocationX() + 1][ball.getLocationY()] == ' ') {
                    ground[ball.getLocationX()][ball.getLocationY()]=' ';
                    ball.setLocationX(ball.getLocationX() + 1);
                    ground[ball.getLocationX()][ball.getLocationY()]='0';
                    ClearConsole();
                    printTable();
                    if(table.isGoal(ball.getLocationX(), ball.getLocationY())){
                        p.getTeam().setGoals(p.getTeam().getGoals()+1);
                        ground[ball.getLocationX()][ball.getLocationY()]=' ';
                        return true;
                    }
                }
                 if (ground[ball.getLocationX() + 1][ball.getLocationY()] == '|' || ground[ball.getLocationX() + 1][ball.getLocationY()] == '_'){
                    //hit wall
                    degree=3;
                }
                else{
                    //hit player
                    degree=3;
                }

            }
            else if (degree == 2) {
                if (ground[ball.getLocationX()][ball.getLocationY() + 1] == ' ') {
                    ground[ball.getLocationX()][ball.getLocationY()]=' ';
                    ball.setLocationY(ball.getLocationY() + 1);
                    ground[ball.getLocationX()][ball.getLocationY()]='0';
                    ClearConsole();
                    printTable();
                    if(table.isGoal(ball.getLocationX(), ball.getLocationY())){
                        p.getTeam().setGoals(p.getTeam().getGoals()+1);
                        ground[ball.getLocationX()][ball.getLocationY()]=' ';
                        return true;
                    }
                }
                else if (ground[ball.getLocationX() + 1][ball.getLocationY()] == '|' || ground[ball.getLocationX() + 1][ball.getLocationY()] == '_'){
                    //hit wall
                    degree=4;
                }
                else{
                    degree=4;
                }
            }
            else if (degree == 3) {
                if (ground[ball.getLocationX() - 1][ball.getLocationY()] == ' ') {
                    ground[ball.getLocationX()][ball.getLocationY()]=' ';
                    ball.setLocationX(ball.getLocationX() - 1);
                    ground[ball.getLocationX()][ball.getLocationY()]='0';
                    ClearConsole();
                    printTable();
                    if(table.isGoal(ball.getLocationX(), ball.getLocationY())){
                        p.getTeam().setGoals(p.getTeam().getGoals()+1);
                        ground[ball.getLocationX()][ball.getLocationY()]=' ';
                        return true;
                    }
                }
                else if (ground[ball.getLocationX() + 1][ball.getLocationY()] == '|' || ground[ball.getLocationX() + 1][ball.getLocationY()] == '_'){
                    //hit wall
                    degree=1;
                }
                else{
                    degree=1;
                }

            } else if (degree == 4) {
                if (ground[ball.getLocationX()][ball.getLocationY() - 1] == ' ') {
                    ground[ball.getLocationX()][ball.getLocationY()]=' ';
                    ball.setLocationY(ball.getLocationY() - 1);
                    ground[ball.getLocationX()][ball.getLocationY()]='0';
                    ClearConsole();
                    printTable();
                    if(table.isGoal(ball.getLocationX(), ball.getLocationY())){
                        p.getTeam().setGoals(p.getTeam().getGoals()+1);
                        ground[ball.getLocationX()][ball.getLocationY()]=' ';
                        return true;
                    }
                }
                else if (ground[ball.getLocationX() + 1][ball.getLocationY()] == '|' || ground[ball.getLocationX() + 1][ball.getLocationY()] == '_'){
                    //hit wall
                    degree=2;
                }
                else{
                    degree=2;
                }
            }
        }
        return false;
    }
}
