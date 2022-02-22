package FarmManage;

import java.util.*;

public abstract class Cattle {
    protected String code;
    protected float weight;
    protected int age;

    private static final Scanner input = new Scanner(System.in);

    public Cattle()
    {
        this.code = " ";
        this.weight = 0;
        this.age = 0;
    }

    public Cattle(String code,float weight,int age)
    {
        this.code = code;
        this.weight = weight;
        this.age = age;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public void setWeight(float weight)
    {
        this.weight = weight;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getCode()
    {
        return this.code;
    }

    public float getWeight()
    {
        return this.weight;
    }

    public int getAge()
    {
        return this.age;
    }

    public void input()
    {
        System.out.println("Enter cattle code: ");
        this.code = input.nextLine();
        System.out.println("Enter weight: ");
        this.weight = input.nextFloat();
        System.out.println("Enter age: ");
        this.age = input.nextInt();
    }

    public void output()
    {
        System.out.print("Cattle code: " + this.code);
        System.out.print(" Weight: " + this.weight);
        System.out.print(" Age: " + this.age);
        System.out.println(" Milk: " + calculatingMilk());
        System.out.println();
    }

    public abstract float calculatingMilk();
}
