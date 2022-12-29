package romannumerals

class RomanNumeralsConverter {
    fun romanFor(arabic: Int): String {
        var mutableArabic = arabic
        var roman = ""
        for (arabicToRoman in ArabicToRoman.values()) {
            while (mutableArabic >= arabicToRoman.arabic) {
                roman += arabicToRoman.roman
                mutableArabic -= arabicToRoman.arabic
            }
        }

        return roman
    }

    enum class ArabicToRoman(val arabic: Int, val roman: String) {
        THOUSAND(1000, "M"),
        NINE_HUNDRED(900, "CM"),
        FIVE_HUNDRED(500, "D"),
        FOUR_HUNDRED(400, "CD"),
        HUNDRED(100, "C"),
        NINETY(90, "XC"),
        FIFTY(50, "L"),
        FORTY(40, "XL"),
        TEN(10, "X"),
        NINE(9, "IX"),
        FIVE(5, "V"),
        FOUR(4, "IV"),
        ONE(1, "I");
    }
}