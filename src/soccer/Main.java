package soccer;

import soccer.Player;

public class Main {
    public static void main(String[] args) {
        Team team1=new Team("team1");
        Team team2=new Team("team2");
        Ball ball=new Ball();
        table table=new table(180,20,5,1);
        Player pl1=new Player("ali",1);
        Player pl2=new Player("reza",2);
        Player pl3=new Player("sanaz",3);
        Player pl4=new Player("sara",4);
        Player pl5=new Player("bahram",5);
        Player pl6=new Player("sayeh",6);
        team1.addplayer(pl1);
        team1.addplayer(pl2);
        team1.addplayer(pl5);
        team2.addplayer(pl3);
        team2.addplayer(pl4);
        team2.addplayer(pl6);
        game newGame=new game(team1,team2,table,ball);
        Menu menu=new Menu(team1,team2);
        newGame.ClearConsole();
        int menuanswer=menuanswer=menu.showMenu();;
        while(menuanswer!=0) {

            if(menuanswer==1 ) {
                newGame.firstFormation();
                team1.setGoals(0);
                team2.setGoals(0);
                newGame.printTable();
                while(!newGame.flag2) {
                    newGame.play(team1);
                    if(!newGame.flag2) {
                        newGame.play(team2);
                    }
                }
            }
            if(menuanswer==2 ) {
                newGame.firstFormation();
                team1.setGoals(0);
                team2.setGoals(0);
                newGame.printTable();
                while(!newGame.flag2) {
                    newGame.play(team2);
                    if(!newGame.flag2) {
                        newGame.play(team1);
                    }
                }
            }
            menuanswer=menu.showMenu();
        }

    }
}