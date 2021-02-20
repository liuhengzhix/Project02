package inid.lhz.day06.demo08;

/*
    通过this引用本类的成员方法
 */
public class Husband {
    //定义一个买房子的方法
    public void buyHouse() {
        System.out.println("北京二环内买一套四合院!");
    }

    //定义一个结婚的方法,参数传递Richable函数式接口
    public void marry(Richable r) {
        r.buy();
    }

    //定义一个非常高兴的方法
    public void soHappy() {
        /*
            使用方法引用优化Lambda表达式
            this是已经存在的
            本类的成员方法buyHouse也是已经存在的
            所以我们可以直接使用this引用本类的成员方法buyHouse
         */
        marry(this::buyHouse);
    }

    public static void main(String[] args) {
        new Husband().soHappy();
    }
}
