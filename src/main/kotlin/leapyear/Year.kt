package leapyear

class Year {
    fun isLeapYear(year: Int): Boolean {
        return divisibleBy(year, 4) && !(divisibleBy(year, 100) && !divisibleBy(year, 400))
    }

    private fun divisibleBy(year: Int, divisor: Int) = year % divisor == 0
}