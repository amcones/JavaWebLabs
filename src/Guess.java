public class Guess {
    public String handleNumber(int num){
        int randNum=(int)(Math.random()*100+1);
        System.out.println(randNum);
        if(num>randNum){
            return "用户输入的数字大了";
        }
        else if(num<randNum){
            return "用户输入的数字小了";
        }
        else return "用户输入正确";
    }
}
