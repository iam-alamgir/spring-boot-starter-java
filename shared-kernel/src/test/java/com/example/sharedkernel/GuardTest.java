package com.example.sharedkernel;

import com.example.sharedkernel.guard.Guard;
import com.example.sharedkernel.types.EmailAddress;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GuardTest {
    @Test
    void givenBlankValue_whenNotBlank_thenThrows() {
        assertThrows(IllegalArgumentException.class, () -> Guard.notBlank(" ", "name"));
    }

    @Test
    void givenEmail_whenConstructed_thenKeepsValue() {
        EmailAddress email = new EmailAddress("a@b.com");
        assertEquals("a@b.com", email.value());
    }
}
