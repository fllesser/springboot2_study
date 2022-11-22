package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Test {
    /**
     * 总结 不带declared, 返回的是当前类和它父类的所有public成员
     * 带declared, 返回当前类所有成员
     * @param args
     */
    public static void main(String[] args) {
        Field[] fields = A.class.getFields();
        System.out.println(Arrays.toString(fields));
        Field[] declaredFields = A.class.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));
        Field[] fields1 = Ia.class.getFields();
        System.out.println(Arrays.toString(fields1));
        Field[] declaredFields1 = Ia.class.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields1));
        Method[] declaredMethods = Ia.class.getMethods();
        System.out.println(Arrays.toString(declaredMethods));
        Method[] declaredMethods1 = A.class.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods1));
    }
}

class A extends B implements Ia {
    static String staticname;
    public String name;
    Integer age;

    @Override
    public void test() {
        System.out.println(name);
    }
}

class B {
    public String bName;
}

interface Ia extends Ib {
    String iaName = "ia";
}

interface Ib {
    String ibName = "ib";

    void test();
}