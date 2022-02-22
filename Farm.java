package FarmManage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Farm {
    
    private String farmName;
    private int numberOfCattle;
    private ArrayList<Cattle> listOfCattle;
    private static final Scanner input = new Scanner(System.in);
    public Farm()
    {
        this.farmName = " ";
        this.numberOfCattle = 0;
        this.listOfCattle = new ArrayList<Cattle>();
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public void input()
    {
        System.out.println("Enter farm name: ");
        this.farmName = input.nextLine();
        System.out.println("Enter number of cattle: ");
        this.numberOfCattle = input.nextInt();
        Cattle ct = null;

        System.out.println("Enter list of cattle:");
        for(int i = 0;i < this.numberOfCattle;i++)
        {
            int type;
            System.out.println("Enter the type of cattle(1-Cow 2-Goat):");
            type = input.nextInt();
            if(type == 1)
            {
                ct = new Cow();
            }
            else if(type == 2)
            {
                ct = new Goat();
            }
            ct.input();
            this.listOfCattle.add(ct);
        }
    }

    public void output()
    {
        System.out.println("Farm name: " + this.farmName);
        System.out.println("Number of cattles: " + this.numberOfCattle);
        System.out.println("List of cattles: ");
        for (int i = 0; i < this.numberOfCattle; i++) {
            this.listOfCattle.get(i).output();
        }
    }

    public float totalMilk()
    {
        float totalMilk = 0;
        for (int i = 0; i < this.numberOfCattle; i++) {
            totalMilk += this.listOfCattle.get(i).calculatingMilk();
        }
        return totalMilk;
    }

    public float totalCowMilk()
    {
        float result = 0;

        for (int i = 0; i < this.numberOfCattle; i++) {
            String type = this.listOfCattle.get(i).getClass().getName();
            if(type == "FarmManage.Cow")
            {
                result += this.listOfCattle.get(i).calculatingMilk();
            }
        }
        return result;
    }

    public float totalGoatMilk()
    {
        float result = 0;

        for (int i = 0; i < this.numberOfCattle; i++) {
            String type = this.listOfCattle.get(i).getClass().getName();
            if(type == "FarmManage.Goat")
            {
                result += this.listOfCattle.get(i).calculatingMilk();
            }
        }
        return result;
    }

    public float findMaxMilk()
    {
        float max = this.listOfCattle.get(0).calculatingMilk();
        for (int i = 0; i < this.numberOfCattle; i++) {
            if(this.listOfCattle.get(i).calculatingMilk() > max)
            {
                max = this.listOfCattle.get(i).calculatingMilk();
            }
        }
        return max;
    }

    public Farm theCattleThatGiveTheMostMilk()
    {
        Farm ctmm = new Farm();
        float maxMilk = findMaxMilk();
        ctmm.numberOfCattle = 1;
        for (int i = 0; i < this.numberOfCattle; i++) {
            if(this.listOfCattle.get(i).calculatingMilk() == maxMilk)
            {
                ctmm.listOfCattle.add(this.listOfCattle.get(i)); 
            }
        }
        return ctmm;        
    }

    public Farm findByCode()
    {
        Farm result = new Farm();
        String code;
        System.out.println("Enter the code to find: ");
        code = input.nextLine();
        for (int i = 0; i < this.numberOfCattle; i++) 
        {
            if(this.listOfCattle.get(i).getCode().equals(code))
            {
                result.listOfCattle.add(this.listOfCattle.get(i));
                result.numberOfCattle = result.listOfCattle.size();
                return result;
            }
        }
        return null;
    }

    public boolean findByAge(Farm result)
    {
        int age;
        boolean tf = false;
        result.numberOfCattle = 0;
        System.out.println("Enter age to find: ");
        age = input.nextInt();
        for (int i = 0; i < this.numberOfCattle; i++) {
            if(this.listOfCattle.get(i).getAge() == age)
            {
                result.listOfCattle.add( this.listOfCattle.get(i));
                result.numberOfCattle = result.listOfCattle.size();
                tf = true;
            }
        }
        return tf;
    }

    public Farm increaseMilk()
    {
        Farm result;
        result = this;

        for (int i = 0; i < result.listOfCattle.size(); i++) {
            if (i < result.listOfCattle.size() - 1) {
                if (result.listOfCattle.get(i).calculatingMilk() > result.listOfCattle.get(i + 1).calculatingMilk()) {
                    Cattle j = result.listOfCattle.get(i);
                    result.listOfCattle.remove(i);
                    result.listOfCattle.add(i, result.listOfCattle.get(i));
                    result.listOfCattle.remove(i + 1);
                    result.listOfCattle.add(j);
                    i = -1;
                }
            }
        }
        return result;
    }

    // public Farm decreaseAge()
    // {
    //     Farm result;
    //     result = this;
    //     for (int i = 0; i < result.listOfCattle.size(); i++) {
    //         if (i < result.listOfCattle.size() - 1) {
    //             if (result.listOfCattle.get(i).getAge() < result.listOfCattle.get(i + 1).getAge()) {
    //                 Cattle j = result.listOfCattle.get(i);
    //                 result.listOfCattle.remove(i);
    //                 result.listOfCattle.add(i, result.listOfCattle.get(i));
    //                 result.listOfCattle.remove(i + 1);
    //                 result.listOfCattle.add(j);
    //                 i = -1;
    //             }
    //         }
    //     }
    //     return result;
    // }

    public Farm sortAge()
    {
        Farm result = this;
        
        for (int i = 0; i < result.listOfCattle.size() - 1; i++) {
            for (int j = i + 1; j < result.listOfCattle.size(); j++) {
                if(result.listOfCattle.get(i).getAge() < result.listOfCattle.get(j).getAge())
                {
                    Collections.swap(result.listOfCattle, i, j);
                }
            }
        }

        return result;
    }
}
