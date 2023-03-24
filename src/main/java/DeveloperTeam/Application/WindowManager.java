package DeveloperTeam.Application;

import javax.swing.*;
import java.awt.*;

public class WindowManager {
    public static String getPath(){
        String path = "";

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        fileChooser.setDialogTitle("Select the path to save the ticket");

        int result = fileChooser.showOpenDialog(frame);
        if(result==JFileChooser.APPROVE_OPTION){
            path = fileChooser.getSelectedFile().getAbsolutePath();
        } else{
            System.out.println("Process has been canceled, current directory will be used");
        }
        return path;
    }

    public static String[] getSQLConnection(){
        String[] data = new String[2];
        JPanel panel = new JPanel();
        JOptionPane.getRootFrame().setAlwaysOnTop(true);
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(10);
        panel.setLayout(new GridLayout(2, 2));
        panel.add(usernameLabel);
        JTextField usernameField = new JTextField(10);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        int option = JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(), panel, "Enter your SQL credentials", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) {
            data[0] = usernameField.getText();
            data[1] = new String(passwordField.getPassword());
        }
        return data;
    }

    public static boolean promptYesNo(String message) {
        JOptionPane.getRootFrame().setAlwaysOnTop(true);
        int option = JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(), message, "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return option == JOptionPane.YES_OPTION;
    }

}
