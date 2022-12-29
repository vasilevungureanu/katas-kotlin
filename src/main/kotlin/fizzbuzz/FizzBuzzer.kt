package fizzbuzz

class FizzBuzzer {
    fun fizzBuzz(number: Int): String {
        return when {
            divisibleBy(15, number) -> "FizzBuzz"
            divisibleBy(3, number) -> "Fizz"
            divisibleBy(5, number) -> "Buzz"
            else -> number.toString()
        }
    }

    private fun divisibleBy(factor: Int, number: Int) = number % factor == 0
}