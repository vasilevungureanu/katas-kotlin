package leapyear

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class YearShould {
    @Test
    fun `not be a leap year if is not divisible by 4`() {
        assertThat(leapYear(1997)).isFalse()
    }

    @Test
    fun `be a leap year if is divisible by 4`() {
        assertThat(leapYear(1996)).isTrue()
    }

    @Test
    fun `be a leap year if is divisible by 400`() {
        assertThat(leapYear(1600)).isTrue()
    }

    @Test
    fun `not be a leap year if is divisible by 100 but not by 400`() {
        assertThat(leapYear(1800)).isFalse()
    }

    private fun leapYear(input: Int) = year.isLeapYear(input)

    companion object {
        private lateinit var year: Year

        @BeforeAll
        @JvmStatic
        fun initAll() {
            year = Year()
        }
    }
}