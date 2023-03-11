package DeveloperTeam;

import DeveloperTeam.Application.App;
import DeveloperTeam.Application.WindowManager;

public class MainTestingPau {
    public static void main(String[] args) {
        WindowManager.getTicketDir();
        App app = new App();
        App app2 = new App();
        App app3 = new App();

        app.init();
    }
}
