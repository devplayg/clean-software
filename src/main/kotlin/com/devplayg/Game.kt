// clean software

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

    private fun scoreForFrame(theFrame: Int): Int {
        return itsScorer.scoreForFrame(theFrame)
    }

    private var itsCurrentFrame = 0
    private var firstThrowInFrame = true
    private val itsScorer: Scorer = Scorer()
}

class Scorer {
    fun addThrow(pins: Int) {
        itsThrows[itsCurrentThrow++] = pins
    }

    fun scoreForFrame(theFrame: Int): Int {
        var ball = 0
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
                    ball++
                }
                else -> {
                    score += twoBallsInFrame()
                    ball += 2
                }
            }
        }
    }

    private fun strike(): Boolean {
        return itsThrows[ball] == 10
    }

    private fun spare(): Boolean {
        return (itsThrows[ball] + itsThrows[ball + 1]) == 10
    }

    private fun nextTwoBallsForStrike(): Int {
        return itsThrows[ball + 1] + itsThrows[ball + 1]
    }

    private fun nextBallForSpare(): Int {
        return itsThrows[ball + 1]
    }

    private fun twoBallsInFrame(): Int {
        return itsThrows[ball] + itsThrows[ball + 1]
    }

    private var ball: Int = 0
    private var itsThrows: MutableList<Int> = arrayListOf()
    private var itsCurrentThrow = 0
}




Class TestGame extends TestCase {
    fun TestGame(name: String) {
        super(name)
    }

    private g: Game 

    public void testTwoThrowsNoMark() {
        g.add(5)
        g.add(4)
        assertEquals(9, g.score())
    }

    public void testTwoThrowsNoMark() {
        g.add(5)
        g.add(4)
        g.add(7)
        g.add(2)
        assertEquals(18, g.score())
        assertEquals(9 g.scoreForFrame(1))
        assertEquals(18 g.scoreForFrame(2))
    }



}
