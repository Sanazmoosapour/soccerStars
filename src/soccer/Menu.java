package soccer;
import java.util.Scanner;
public class Menu {
    private Team team1;
    private Team team2;
    public Menu(Team team1,Team team2){
        this.team1=team1;
        this.team2=team2;
    }
    public int showMenu(){
        Scanner scanner=new Scanner(System.in);
        while(true) {
            String menu = "1)new game\n2)show two team with their information\n3)exit";
            System.out.println(menu);
            int select = scanner.nextInt();
            if (select == 1) {
                System.out.println("which team will start?\n1)" + team1.getName() + " 2)" + team2.getName());
                int start = scanner.nextInt();
                return start;
            }
             else if (select == 2) {
                System.out.print(team1.getName()+": goals:"+team1.getGoals()+" players: ");
                for(int i=0;i<team1.getPlayercounter();i++)
                    System.out.print(team1.getPlayers().get(i).getName()+" ");
                System.out.print("\n");
                System.out.print(team2.getName()+": goals:"+team2.getGoals()+" players: ");
                for(int i=0;i<team2.getPlayercounter();i++)
                    System.out.print(team2.getPlayers().get(i).getName()+" ");
                System.out.print("\n");

            } else if (select == 3) {
                return 0;
            }
        }
    }
}
