package DeveloperTeam.Application;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO Crear clase askMaterial que unicamente accepte madera o plastico (se puede hacer con un tolower case o pidiendo un byte i en funcion del byte returnear 'madera' o 'plastico')
public class AskParameter {
    // the  System.out.println(messages) depend of question;
        public static Scanner myScannerObj = new Scanner(System.in);

    public static int askInteger(String message){

        int outputParameter=0;
        boolean continua = true;

        do{
            try{
                System.out.println("\r"+message);
                outputParameter= myScannerObj.nextInt();
                continua= false;
            } catch(InputMismatchException e) {
                System.out.println("Entered value isn't a Integer, try again! ");
            }

            myScannerObj.nextLine();

        } while(continua);

        return outputParameter;

    }

    public static String askString(String message){
        System.out.println("\r"+message);
        return myScannerObj.nextLine().toLowerCase();
    }

    public static float askFloat(String message){

        float outputParameter=0f;
        boolean continua=true;

        do{
            try{

                System.out.println("\r"+message);

                outputParameter = myScannerObj.nextFloat();
                outputParameter = (float) (Math.round(outputParameter * 100.0) / 100.0); // round 2 decimals
                continua= false;

            } catch(InputMismatchException e) {
                System.out.println("Entered value isn't a Float, try again! ");
            }
            myScannerObj.nextLine();
        } while(continua);

        return outputParameter;
    }

    public static byte askByte(String message){


        byte outputParameter = 0;
        boolean continua  = true;

        do {
            try {
                System.out.println("\r"+message);
                outputParameter = myScannerObj.nextByte();
                continua=false;

            } catch (InputMismatchException e) {
                System.out.println("Entered value isn't a byte, try again! ");
            }
            myScannerObj.nextLine();
        } while (continua);
        return outputParameter;
    }

    public static boolean askBoolean(String message){


        boolean outputParameter = false;
        boolean continua  = true;

        do {
            try {
                System.out.println("\r"+message);
                outputParameter = myScannerObj.nextBoolean();
                continua=false;

            } catch (InputMismatchException e) {
                System.out.println("Entered value isn't a booolean, try again! ");
            }
            myScannerObj.nextLine();

        } while (continua);

        return outputParameter;
    }

}
