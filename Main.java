package FarmManage;

public class Main {

    public static void main(String[] args) {
        Farm myFarm = new Farm();

        myFarm.input();

        myFarm.output();

        float totalMilk = myFarm.totalMilk();
        System.out.println("Total milk: " + totalMilk);

        float totalCowMilk = myFarm.totalCowMilk();
        System.out.println("Total cow milk: " + totalCowMilk);
        
        float totalGoatMilk = myFarm.totalGoatMilk();
        System.out.println("Total goat milk: " + totalGoatMilk);

        Farm cattletThatGiveTheMostMilk = myFarm.theCattleThatGiveTheMostMilk();
        System.out.println("Cattles that give the most milk:");
        cattletThatGiveTheMostMilk.output();
        
        Farm fbc = myFarm.findByCode();
        if(fbc == null)
        {
            System.out.println("The cattle code does not exist!!!");
        }
        else
        {
            System.out.println("The cattle has been found!!");
            fbc.output();
        }
        
        Farm fba = new Farm();
        if(myFarm.findByAge(fba) == true)
        {
            System.out.println("The cattle has been found!!");
            fba.output();
        }
        else
        {
            System.out.println("The cattle code does not exist!!!");
        }

        System.out.println("The list after sort by milk:");
        Farm sortByMilk = myFarm.increaseMilk();
        sortByMilk.output();

        System.out.println("The list after sort by age:");
        Farm sortByAge = myFarm.sortAge();
        sortByAge.output();
    }
}