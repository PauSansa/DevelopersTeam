package DeveloperTeam.Application;

import java.util.Scanner;

//TODO implementar metodos
public class AskParameter {
    public static Scanner sc = new Scanner(System.in);

    public static int readInt(String msg){
        System.out.println(msg + "\n");
        sc.nextLine();
        return 0;
    }

    public static String readString(String msg){
        System.out.println(msg + "\n");
        sc.nextLine();

        return null;
    }

    public static float readFloat(String msg){
        System.out.println(msg + "\n");
        sc.nextLine();

        return 0f;
    }

    public static byte readByte(String msg){
        System.out.println(msg + "\n");
        sc.nextLine();

        return 0;
    }

}
