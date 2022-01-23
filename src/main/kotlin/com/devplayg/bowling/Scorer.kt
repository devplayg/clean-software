package com.devplayg.bowling

class Scorer {
    fun addThrow(pins: Int) {
        itsThrows[itsCurrentThrow++] = pins
    }

    fun scoreForFrame(theFrame: Int): Int {
        ball = 0
        var score = 0
        for (i: Int in 1..10)
            print("$i ") // output : 1, 2, 3, 4, 5 ... 10

        for (currentFrame in 0 until theFrame) {
            when {
                strike() -> {
                    score += 10 + nextTwoBallsForStrike()
                    ball++
                }
                spare() -> {
                    score += 10 + nextBallForSpare()
                    ball += 2
                }
                else -> {
                    score += twoBallsInFrame()
                    ball += 2
                }
            }
        }
        return score
    }

    private fun strike(): Boolean {
        return itsThrows[ball] == 10
    }

    private fun spare(): Boolean {
        return (itsThrows[ball] + itsThrows[ball + 1]) == 10
    }

    private fun nextTwoBallsForStrike(): Int {
        return itsThrows[ball + 1] + itsThrows[ball + 2]
    }

    private fun nextBallForSpare(): Int {
        return itsThrows[ball + 2]
    }

    private fun twoBallsInFrame(): Int {
        return itsThrows[ball] + itsThrows[ball + 1]
    }

    private var ball: Int = 0
    private val itsThrows = IntArray(22)
    private var itsCurrentThrow = 0
}