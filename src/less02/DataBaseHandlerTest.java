package less02;

public class DataBaseHandlerTest {
    public static void main(String[] args) {
        DataBaseHandler handler = new DataBaseHandler();
        handler.addUser("login1", "pass1", "nick1_1" );
        handler.addUser("login2", "pass2", "nick2" );
        handler.addUser("login3", "pass3", "nick3" );
        handler.addUser("login4", "pass4", "nick4_1" );
    }
}
