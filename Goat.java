package FarmManage;

public class Goat extends Cattle {
    public void input()
    {
        super.input();
    }

    public void output()
    {
        super.output();
    }

    public float calculatingMilk()
    {
        if(this.age >=1 && this.age <= 2)
        {
            return this.weight / 10;
        }
        else if(this.age > 2 && this.age <=4)
        {
            return this.weight / 15;
        }
        return 0;
    }

}
