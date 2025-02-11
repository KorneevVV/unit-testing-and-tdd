package com.acme.banking.dbo.domain;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class SavingAccountTest {

    private static Stream<Arguments> shouldThrowErrorWhenInvalidParams() {
        return Stream.of(
                Arguments.of(-1, new Client(1, "name"), 0.01),
                Arguments.of(0, new Client(1, "name"), -0.01),
                Arguments.of(0, null, 0)
        );
    }

    private static Stream<Arguments> shouldCreateWhenValidParams() {
        return Stream.of(
                Arguments.of(0, new Client(1, "name"), 0.01),
                Arguments.of(1, new Client(1, "name"), 0.01),
                Arguments.of(1, new Client(1, "name"), 0)
        );
    }

    @ParameterizedTest
    @MethodSource
    void shouldThrowErrorWhenInvalidParams(int id, Client client, double amount) {
        assertThrows(IllegalArgumentException.class, () -> new SavingAccount(id, client, amount));
    }

    @ParameterizedTest
    @MethodSource
    void shouldCreateWhenValidParams(int validId, Client validClient, double validAmount) {
        SavingAccount savingAccount = new SavingAccount(validId, validClient, validAmount);

        assertEquals(validId, savingAccount.getId());
        assertEquals(validClient, savingAccount.getClient());
        assertEquals(validAmount, savingAccount.getAmount());
    }
}