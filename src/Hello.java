import java.util.Date;

public class Hello {
    public static void main(String[] args) {
        // 获取当前时间
        Date date = new Date(System.currentTimeMillis());
        // 打印当前时间
        System.out.println(date);
        // 打印 Hello world
        System.out.println("Hello World!");
    }
}
