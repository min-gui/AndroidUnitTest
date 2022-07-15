package com.mingui.dallija

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
            "",
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

    //empty password
    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    //password was repeated incorrectly
    @Test
    fun `it returns false that password was repeated incorrectly`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "",
            ""
        )
        assertThat(result).isFalse()
    }

    //password contains less than 2 digits
    @Test
    fun `less than 2 digits password returns false `() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "2",
            "2"
        )
        assertThat(result).isFalse()
    }

}