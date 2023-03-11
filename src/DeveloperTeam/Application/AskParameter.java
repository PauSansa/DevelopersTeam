package DeveloperTeam.Application;

import java.util.InputMismatchException;
import java.util.Scanner;

//TODO quitar mensaje de confirmacion
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
                System.out.println("entered Integer is correct!: "+ outputParameter);
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
        return myScannerObj.nextLine();
    }

    public static float askFloat(String message){

        float outputParameter=0f;
        boolean continua=true;

        do{
            try{

                System.out.println("\r"+message);

                outputParameter = myScannerObj.nextFloat();
                outputParameter = (float) (Math.round(outputParameter * 100.0) / 100.0); // round 2 decimals
                System.out.println("entered Float is correct!: " + outputParameter);
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
                System.out.println("entered Byte is correct!: " + outputParameter);
                continua=false;

            } catch (InputMismatchException e) {
                System.out.println("Entered value isn't a byte, try again! ");
            }
            myScannerObj.nextLine();
        } while (continua);
        return outputParameter;
    }

}
