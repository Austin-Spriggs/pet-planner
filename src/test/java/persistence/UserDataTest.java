package persistence;

import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDataTest {

    UserData userData;
    private final Logger logger = LogManager.getLogger(this.getClass());


    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");

    }

    @Test
    void getById() {
        UserData userData = new UserData();
        User retrievedUser = userData.getById(1);

        assertEquals("Test", retrievedUser.getFirstName());
    }

    @Test
    void update() {
    }

    @Test
    void insert() {
        UserData userData = new UserData();
        User userToInsert = new User ("Test", "Test", "test", "test", "test@email.com");
        int insertedUserId = userData.insert(userToInsert);

        assertTrue(insertedUserId != 0);
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getByPropertyEqual() {
    }

    @Test
    void getByPropertyLike() {
    }
}