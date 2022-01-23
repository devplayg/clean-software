package com.devplayg.bowling

class Game {
    fun score(): Int {
        return scoreForFrame(itsCurrentFrame)
    }

    fun add(pins: Int) {
        itsScorer.addThrow(pins)
        adjustCurrentFrame(pins)
    }

    private fun adjustCurrentFrame(pins: Int) {
        if (lastBallInFrame(pins)) {
            advanceFrame()
            return
        }
        firstThrowInFrame = false
    }

    private fun lastBallInFrame(pins: Int): Boolean {
        return strike(pins) || !firstThrowInFrame
    }

    fun strike(pins: Int): Boolean {
        return firstThrowInFrame && pins == 10
    }

    private fun advanceFrame() {
        itsCurrentFrame = Math.min(10, itsCurrentFrame + 1)
    }

    fun scoreForFrame(theFrame: Int): Int {
        return itsScorer.scoreForFrame(theFrame)
    }

    private var itsCurrentFrame = 0
    private var firstThrowInFrame = true
    private val itsScorer: Scorer = Scorer()
}


