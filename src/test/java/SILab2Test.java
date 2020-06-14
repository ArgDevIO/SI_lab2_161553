import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranchTest() {
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, new ArrayList<>()));
        assertTrue(ex.getMessage().contains("The user is not instantiated"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User(null, null, "test@test.com"), new ArrayList<>()));
        assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));

        assertFalse(() -> SILab2.function(new User("test", "test123", "test@test.com"), new ArrayList<>()));

        assertFalse(() -> SILab2.function(new User("user", "test123", "test@test.com"), new ArrayList<>()));

        assertFalse(() -> SILab2.function(new User("user", "testtest", "test@test.com"), new ArrayList<>()));

        assertTrue(() -> SILab2.function(new User("user", "Test@123", "test@test.com"), new ArrayList<>()));
    }

}