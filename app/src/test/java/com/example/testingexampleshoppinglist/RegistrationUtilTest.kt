package com.example.testingexampleshoppinglist

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Philipp",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Philipp",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password repeated incorrectly return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Philipp",
            "123",
            "321"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password contains less then two digits return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Philipp",
            "1asdf",
            "1asdf"
        )
        assertThat(result).isFalse()
    }
}