import java.util.Random;

public class Guess {
    private int randNum;
    private int count;
    Guess(){
        Random random=new Random();
        randNum=random.nextInt(99)+1;
        count=0;
    }
    public int judge(int x){
        count++;
        if(x<randNum) {
            return -1;
        } else if(x==randNum) {
            return 0;
        } else {
            return 1;
        }
    }

    public int getRandNum() {
        return randNum;
    }

    public int getCount() {
        return count;
    }
}
