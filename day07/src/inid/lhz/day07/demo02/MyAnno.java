package inid.lhz.day07.demo02;

public @interface MyAnno {
    int age();

    String name() default "张三";
}
