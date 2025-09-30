package persistence;

import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class for testing UserData methods
 *
 */
class UserDataTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    UserData userData;

    /**
     *  Test setup
     *
     */
    @BeforeEach
    void setUp() {
        userData = new UserData();

        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");

    }

    /**
     * Get by id test
     *
     */
    @Test
    void getById() {
        User retrievedUser = userData.getById(1);

        assertEquals("Austin", retrievedUser.getFirstName());
    }

    /**
     * Update data test
     *
     */
    @Test
    void update() {
        User userToUpdate = userData.getById(1);
        userToUpdate.setFirstName("Poopyhead");
        userData.update(userToUpdate);

        User updatedUser = userData.getById(1);
        assertEquals("Poopyhead", updatedUser.getFirstName());
    }

    /**
     * Insert data test
     *
     */
    @Test
    void insert() {
        User userToInsert = new User ("testInsert", "testInsert", "testInsert", "testInsert", "testInsert@email.com");
        int insertedUserId = userData.insert(userToInsert);

        assertTrue(insertedUserId != 0);
    }

    /**
     * Delete data test
     *
     */
    @Test
    void delete() {
        User userToDelete = userData.getById(1);
        userData.delete(userToDelete);

        User retrievedUser = userData.getById(1);
        assertNull(retrievedUser);
    }

    /**
     * Get all data test
     *
     */
    @Test
    void getAll() {
        List<User> retrievedUsers = userData.getAll();

        assertFalse(retrievedUsers.isEmpty());
    }

    /**
     * Get property equal to test
     *
     */
    @Test
    void getByPropertyEqual() {
        List<User> retrievedUsers = userData.getByPropertyEqual("lastName", "Spriggs");

        assertFalse(retrievedUsers.isEmpty());
    }

    /**
     * Get property like test
     *
     */
    @Test
    void getByPropertyLike() {
        List<User> retrievedUsers = userData.getByPropertyLike("lastName", "Spriggs");

        assertFalse(retrievedUsers.isEmpty());
    }
}