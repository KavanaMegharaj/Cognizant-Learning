package com.cognizant.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BankServiceTest {

    @Test
    public void testVerifyInteraction() {

        // Arrange
        Database db = mock(Database.class);
        when(db.getBalance()).thenReturn(5000);

        BankService service = new BankService(db);

        // Act
        service.fetchBalance();

        // Assert
        verify(db).getBalance();

    }

}