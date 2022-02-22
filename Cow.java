package FarmManage;

public class Cow extends Cattle {
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
        if (this.age > 1 && this.age < 6) {
            return (this.weight - this.age) / 10;
        }
        return 0;
    }
}
