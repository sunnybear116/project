package nimingInnerClass;

//为何用匿名内部类，背景、语法
public class Class100_2 implements Interface100_1 {
    @Override
    public void show() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        Class100_2 obj100_2 = new Class100_2();
        obj100_2.show();

        //有的时候参数只需要一个接口类型或者抽象类的对象，为此专门创建个对象还要起个名字，太麻烦
//        此时可用匿名内部类，new 后面直接跟接口或抽象类名，省去对象名。生成该对象当作参数
        new Interface100_1(){
            public void show() {
                System.out.println("hello2");
            }
        };


    }
}
