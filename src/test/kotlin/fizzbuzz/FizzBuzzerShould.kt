package fizzbuzz

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class FizzBuzzerShould {
    @ParameterizedTest
    @CsvSource("1, 1", "2, 2", "4, 4")
    fun `get back a string representing it when I fizzBuzz a regular number`(input: Int, expectedOutput: String) {
        assertEquals(expectedOutput, fizzBuzz(input))
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 6, 9])
    fun `get back "Fizz" when I fizzBuzz a number that is multiplier of 3`(input: Int) {
        assertEquals("Fizz", fizzBuzz(input))
    }

    @ParameterizedTest
    @ValueSource(ints = [5, 10, 20])
    fun `get back "Buzz" when I fizzBuzz a number that is multiplier of 5`(input: Int) {
        assertEquals("Buzz", fizzBuzz(input))
    }

    @ParameterizedTest
    @ValueSource(ints = [15, 30, 45])
    fun `get back "FizzBuzz" when I fizzBuzz a number that is multiplier of 3 and 5`(input: Int) {
        assertEquals("FizzBuzz", fizzBuzz(input))
    }

    private fun fizzBuzz(input: Int) = fizzBuzzer.fizzBuzz(input)

    companion object {
        private lateinit var fizzBuzzer: FizzBuzzer

        @BeforeAll
        @JvmStatic
        fun initAll() {
            fizzBuzzer = FizzBuzzer()
        }
    }
}