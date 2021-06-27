package tw.edu.pu.s410819390.myapp;

public class FoodBean {

    public FoodBean(String title,int num,int money){
        this.num = num;
        this.money = money;
        this.title = title;
    }

    private String title;
    private int num;
    private int money;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "FoodBean{" +
                "title='" + title + '\'' +
                ", num=" + num +
                ", money=" + money +
                '}';
    }
}
