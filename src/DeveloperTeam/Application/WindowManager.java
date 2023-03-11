package DeveloperTeam.Application;

import java.io.File;

import javax.swing.JFileChooser;
public class WindowManager {
    public static File getTicketDir(){
        String path = "";

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Selecciona la carpeta de guardado del Ticket");

        int result = fileChooser.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION){
            path = fileChooser.getSelectedFile().getAbsolutePath();
        } else{
            System.out.println("Se ha cancelado el proceso");
        }
        return new File(path + "/ticket.txt");
    }
}
