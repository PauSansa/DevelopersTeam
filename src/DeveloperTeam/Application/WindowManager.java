package DeveloperTeam.Application;

import java.io.File;

import javax.swing.JFileChooser;
public class WindowManager {
    public static File getTicketDir(){
        String path = "";

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Select the path to save the ticket");

        int result = fileChooser.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION){
            path = fileChooser.getSelectedFile().getAbsolutePath();
        } else{
            System.out.println("Process has been canceled");
        }
        return new File(path + "/ticket.txt");
    }

    public static File getStockDir(){
        String path = "";

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Select the path to save the ticket");

        int result = fileChooser.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION){
            path = fileChooser.getSelectedFile().getAbsolutePath();
        } else{
            System.out.println("Process has been canceled");
        }
        return new File(path + "/stock.txt");
    }
}
