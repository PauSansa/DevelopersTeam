package DeveloperTeam.Application;

import java.io.File;

import javax.swing.JFileChooser;
public class WindowManager {
    public static String getPath(){
        String path = "";

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Select the path to save the ticket");

        int result = fileChooser.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION){
            path = fileChooser.getSelectedFile().getAbsolutePath();
        } else{
            System.out.println("Process has been canceled, current directory will be used");
        }
        return path;
    }


}
