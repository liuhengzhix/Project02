package inid.lhz.day06.demo10;

/*
    定义一个创建数组的函数式接口
 */
public interface ArrayBuilder {
    //定义一个创建int类型数组的方法,参数是传递数组的长度,返回创建好的int类型数组
    int[] builderArray(int length);
}
