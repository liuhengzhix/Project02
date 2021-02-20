package inid.lhz.day06.demo05;

/*
    通过对象名引用成员方法
    使用前提是对象名是已经存在的,成员方法也是已经存在
    就可以使用对象名来引用成员方法
 */
public class Demo01ObjectMethodReference {
    //定义一个方法，方法的参数传递printable
    public static void printString(Printable p) {
        p.print("gtaV");
    }

    public static void main(String[] args) {
        /*
            使用方法引用优化Lambda
            对象是已经存在的MethodRerObject
            成员方法也是已经存在的printUpperCaseString
            所以我们可以使用对象名引用成员方法
         */
        MethodRerObject obj = new MethodRerObject();
        printString(obj::printUpperCaseString);
    }
}
