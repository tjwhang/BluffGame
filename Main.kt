/*
 Credits
 Initial code by CopilotAI
 Refined by TJ Whang
 For JW Yoon @CAHS Board Game Club
 */

package me.yjw.bluff

import java.util.*

class Player(val name: String, var diceQuantity: Int) {
    val dice = mutableListOf<Int>()

    init {
        rollDice(diceQuantity)
    }

    fun rollDice(n: Int) {
        dice.clear()
        val rand = Random()
        repeat(n) {
            dice.add(rand.nextInt(6) + 1)
        }
    }

    fun showDice() {
        println("❗ ${name}'s dice: $dice")
    }

    fun hideDice() {
        println("❓ ${name}'s dice quantity: ${dice.size}")
    }
}

object Main {
    private val players = mutableListOf<Player>()
    private val scanner = Scanner(System.`in`)

    @JvmStatic
    fun main(args: Array<String>) {
        println("Call My BLUFF!")
        println("""
            Rules:
            1. Each player starts with 5 dice.
            2. Players take turns to make a bid on the quantity of dice with a specific face value.
            3. The next player must bid higher than the previous bid.
            4. If a player thinks the previous bid is incorrect, they can call bluff.
            5. If bluff is called, all dice are revealed. If the bid is correct, the player who made the bid loses a die. If the bid is incorrect, the player who called bluff loses a die.
            6. The game continues until only one player has dice left.
        """.trimIndent())
        println("===========================================\n")
        print("Enter name for Player 1: ")
        players.add(Player(scanner.nextLine(), 5))
        print("Enter name for Player 2: ")
        players.add(Player(scanner.nextLine(), 5))

        while (true) {
            players.forEach { player ->
                if (player.diceQuantity == 0) {
                    println("🎉 ${player.name} has lost all dice. ${players[(players.indexOf(player) + 1) % players.size].name} wins!")
                    return
                }
                player.rollDice(player.diceQuantity)
                println("🎲 Dice for ${player.name} has been rolled.")
                player.hideDice()
            }

            var gameOn = true
            var lastQuantity = 0
            var lastFaceValue = 0

            println("Press enter to continue.")
            scanner.nextLine()

            while (gameOn) {
                for (i in players.indices) {
                    val currentPlayer = players[i]
                    clearConsole()
                    currentPlayer.showDice()

                    var quantity: Int
                    var faceValue: Int

                    while (true) {
                        println("${currentPlayer.name}, make your bid (e.g., '3 4' for three 4s): ")
                        val bid = scanner.nextLine().split(" ")
                        quantity = bid[0].toInt()
                        faceValue = bid[1].toInt()

                        if (!(faceValue > lastFaceValue || quantity > lastQuantity)) {
                            println("🚫 Invalid bid! You must bid higher than the previous bid.")
                            continue
                        }

                        lastQuantity = quantity
                        lastFaceValue = faceValue
                        break
                    }

                    clearConsole()
                    println("❓ ${currentPlayer.name}'s guess: $quantity $faceValue")
                    println("💣 ${players[(i + 1) % players.size].name}, do you call bluff? (y/n): ")
                    val call = scanner.nextLine()

                    if (call.equals("y", ignoreCase = true)) {
                        players.forEach { it.showDice() }
                        val actualCount = countDice(faceValue)
                        if (actualCount >= quantity) {
                            println("❌ Bluff called incorrectly! ${currentPlayer.name} wins this round.")
                            players[(i + 1) % players.size].apply {
                                diceQuantity--
                            }
                        } else {
                            println("✅ Bluff called correctly! ${players[(i + 1) % players.size].name} wins this round.")
                            currentPlayer.diceQuantity--
                        }
                        println("===========================================\n")
                        gameOn = false
                        break
                    } else {
                        println("➡️ Bluff not called. Continue playing.")
                    }
                }
            }
        }
    }

    private fun countDice(faceValue: Int): Int {
        return players.sumOf { player ->
            player.dice.count { it == faceValue || it == 6 }
        }
    }

    private fun clearConsole() {
        repeat(10000) {
            println()
        }
    }
}
