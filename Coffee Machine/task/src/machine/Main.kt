package machine

var exit = false

class CoffeeMachine(var water: Int = 400,
                    var milk: Int = 540,
                    var coffee: Int = 120,
                    var cups: Int = 9,
                    var money: Int = 550) {

    fun start() {
        while (!exit) {
            println("Write action (buy, fill, take, remaining, exit):")
            when (readln()) {
                "buy" -> buy()
                "fill" -> fill()
                "take" -> take()
                "remaining" -> stateMachine()
                "exit" -> exit = true

            }
        }
    }

    private fun stateMachine() {
        println("\nThe coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$coffee g of coffee beans")
        println("$cups disposable cups")
        println("\$$money of money\n")


    }
    private fun take() {
        println("\nI gave you \$$money\n")
        money = 0
    }

    private fun fill() {
        println("Write how many ml of water you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        coffee += readln().toInt()
        println("Write how many disposable cups you want to add:")
        cups += readln().toInt()
    }

    private fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        when (readln()) {
            "1" -> isResourcesThenBuy(250,0,16,4)
            "2" -> isResourcesThenBuy(350,75,20,7)
            "3" -> isResourcesThenBuy(200,100,12,6)
            "back" -> {}
        }
    }

    private fun isResourcesThenBuy(w : Int, m : Int, c : Int, mo : Int) {

        if (w <= water && m <= milk && c <= coffee && 1 <= cups) {
            println("I have enough resources, making you a coffee!")
            water -= w
            milk -= m
            coffee -= c
            cups--
            money += mo
        }
        else {
            if (w > water) println("Sorry, not enough water!")
            if (m > milk) println("Sorry, not enough milk!")
            if (c > coffee) println("Sorry, not enough coffee!")
            if (1 > cups) println("Sorry, not enough cups!")

        }
    }

}




fun main() {

    val coffeeMachine = CoffeeMachine()
    coffeeMachine.start()


}