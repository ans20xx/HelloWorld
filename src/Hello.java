import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) throws IOException {
        int state = login();
        if(state == 0) {
            // 获取当前时间
            Date date = new Date(System.currentTimeMillis());
            // 打印当前时间
            System.out.println(date);
            // 打印 Hello world
            System.out.println("Hello World!");
        } else if(state == 1){
            System.out.println("用户名错误");
        } else {
            // merge conflict , please contact an
            System.out.println("密码错误");
        }
    }

    /**
     * 验证用户名和密码
     * @return 用户名错误返回 1, 密码错误返回 2, 匹配成功返回 0
     * @throws IOException
     */
    public static int login() throws IOException {
        Properties properties = new Properties();
        URL resource = Hello.class.getClassLoader().getResource("user.properties");
        InputStream in = new FileInputStream(resource.getPath());
        properties.load(in);
        System.out.print("user: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        System.out.print("password: ");
        String password = scanner.next();
        String correctUsername = properties.getProperty("username");
        String correctPassword = properties.getProperty("password");
        if(username.equals(correctPassword) ) {
            if(password.equals(correctPassword)) {
                return 0;
            } else {
                return 2;
            }
        } else {
            return 1;
        }
    }

}
