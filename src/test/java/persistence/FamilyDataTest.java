package persistence;

import entity.Family;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FamilyDataTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    UserData userData;
    FamilyData familyData;

    /**
     *  Test setup
     *
     */
    @BeforeEach
    void setUp() {
        familyData = new FamilyData();
        userData = new UserData();

        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
    }

    @Test
    void getById() {
        Family retrievedFamily = familyData.getById(1);

        assertEquals("Spriggs Family", retrievedFamily.getFamilyName());
    }

    @Test
    void update() {
        Family familyToUpdate = familyData.getById(1);
        familyToUpdate.setFamilyName("New Family");
        familyData.update(familyToUpdate);

        Family updatedFamily = familyData.getById(1);
        assertEquals("New Family", updatedFamily.getFamilyName());
    }

    @Test
    void insert() {
        // Create a new user
        User testUser = new User("Bilbo", "Baggins", "testUser", "testUser@email.com");
        int insertedUserId = userData.insert(testUser);

        // Test user creates a family
        Family familyToInsert = new Family("Baggins Family", insertedUserId);
        int insertedFamilyId = familyData.insert(familyToInsert);

        assertTrue(insertedFamilyId != 0);
    }

    @Test
    void delete() {
        Family familyToDelete = familyData.getById(1);
        familyData.delete(familyToDelete);

        assertNull(familyData.getById(1));
    }

    @Test
    void getAll() {
        User testUser = new User("Bilbo", "Baggins", "testUser", "testUser@email.com");
        int insertedUserId = userData.insert(testUser);

        Family familyToInsert = new Family("Baggins Family", insertedUserId);
        int insertedFamilyId = familyData.insert(familyToInsert);

        List<Family> families = familyData.getAll();

        assertEquals(2, families.size());
        assertEquals("Baggins Family", families.get(1).getFamilyName());
    }

    @Test
    void getByPropertyEqual() {
        List<Family> families = familyData.getByPropertyEqual("familyName", "Spriggs Family");

        assertEquals("Spriggs Family", families.get(0).getFamilyName());
    }

    @Test
    void getByPropertyLike() {
        List<Family> families = familyData.getByPropertyLike("familyName", "Spriggs");
        List<Family> families2 = familyData.getByPropertyLike("familyName", "Family");

        assertEquals("Spriggs Family", families.get(0).getFamilyName());
        assertEquals("Spriggs Family", families2.get(0).getFamilyName());
    }
}