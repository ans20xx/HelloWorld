import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) throws IOException {
        if(login()) {
            // 获取当前时间
            Date date = new Date(System.currentTimeMillis());
            // 打印当前时间
            System.out.println(date);
            // 打印 Hello world
            System.out.println("Hello World!");
        } else {
            System.out.println("用户名或密码不合法");
        }
    }

    public static boolean login() throws IOException {
        Properties properties = new Properties();
        URL resource = Hello.class.getClassLoader().getResource("user.properties");
        InputStream in = new FileInputStream(resource.getPath());
        properties.load(in);
        System.out.print("user: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        System.out.print("password: ");
        String password = scanner.next();
        if(username.equals(properties.getProperty("username")) &&
            password.equals(properties.getProperty("password"))) {
            return true;
        }
        return false;
    }

}
