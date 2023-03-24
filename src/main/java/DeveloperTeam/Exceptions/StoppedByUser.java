package DeveloperTeam.Exceptions;

public class StoppedByUser extends Exception{
    public StoppedByUser() {
    }

    public StoppedByUser(String message) {
        super(message);
    }
}
