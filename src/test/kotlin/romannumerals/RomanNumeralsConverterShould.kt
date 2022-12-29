package romannumerals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RomanNumeralsConverterShould {
    @ParameterizedTest
    @CsvSource(
        "1, I",
        "2, II",
        "3, III",
        "4, IV",
        "5, V",
        "7, VII",
        "9, IX",
        "10, X",
        "17, XVII",
        "30, XXX",
        "38, XXXVIII",
        "479, CDLXXIX",
        "3999, MMMCMXCIX"
    )
    fun `convert arabic numbers into their roman numerals representation`(arabic: Int, roman: String) {
        assertEquals(roman, romanNumeralsConverter.romanFor(arabic))
    }

    companion object {
        private lateinit var romanNumeralsConverter: RomanNumeralsConverter

        @BeforeAll
        @JvmStatic
        fun initAll() {
            romanNumeralsConverter = RomanNumeralsConverter()
        }
    }
}