import java.util.*;

public class Josephus {

    public static void main(String[] args) {

        // creation du cercle des soldats
        ArrayList<Soldier> soldiersCircle = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // collecter les donnees de chez l'utilisateur

        System.out.println("donner le nombre de soldats!");
        int soldiersNumber = scanner.nextInt();
        String soldierFirstName, soldierLastName;

        // population de la linkedlist circulaire (head pointe au tail/ tail pointe au head)
        int counter = 0;
        while (counter < soldiersNumber) {
            System.out.println("donner le prenom du soldat!");
            soldierFirstName = scanner.next();
            System.out.println("donner le nom du soldat");
            soldierLastName = scanner.next();
            soldiersCircle.add(new Soldier(counter + 1, soldierFirstName, soldierLastName));
            counter++;
        }

        // le dernier noeux de la linkedlist va maintenant pointer vers le head de la linkedlist (circular linkedlist)
//        soldiersCircle.get(soldiersCircle.size() - 1).nextSoldier = soldiersCircle.getFirst();

        // reccuperer le pas
        System.out.println("donner le pas!");
        int step = scanner.nextInt();

        // tuons des soldats maintenant hahahahahaha!
        step--;
        Josh(soldiersCircle, 0, step);

        //log des fullNames des soldats morts
        soldiersCircle.forEach(soldier -> {
            if (!soldier.isDead())
            System.out.println("le voila josephus " + soldier.getFullName());
        });

    }

    static void Josh(ArrayList<Soldier> soldiers, int index, int step)
    {
        // Base case , when only one soldiers is left
        if (soldiers.size() == 1) {
            System.out.println(soldiers.get(soldiers.size() - 1));
            return;
        }

        // find the index of first soldiers which will die
        index = ((index + step) % soldiers.size());
//        System.out.println("index = " + index);

        // remove the first soldiers which is going to be killed
        System.out.println("Soldier " + soldiers.get(index).getFullName());
        System.out.println("Killed at position " + soldiers.get(index).getPosition());
        soldiers.remove(index);
        // check soldiers list size
        System.out.println("soldiers.size = " + soldiers.size());

        // recursive call for n-1 soldierss
        Josh(soldiers, index, step);
    }
}
