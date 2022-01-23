package com.devplayg.bowling

import kotlin.test.Test
import kotlin.test.assertEquals


internal class GameTest {
    private val g: Game = Game()

    @Test
    fun testTwoThrowsNoMark() {
        g.add(5)
        g.add(4)
        assertEquals(9, g.score())
    }

    @Test
    fun testTwoThrowsNoMark2() {
        g.add(5)
        g.add(4)
        g.add(7)
        g.add(2)
        assertEquals(18, g.score())
        assertEquals(9, g.scoreForFrame(1))
        assertEquals(18, g.scoreForFrame(2))
    }

    @Test
    fun testSimpleSpare() {
        g.add(3)
        g.add(7)
        g.add(3)

        assertEquals(13, g.scoreForFrame(1))
    }

    @Test
    fun testSimpleFrameAfterSpare() {
        g.add(3)
        g.add(7)
        g.add(3)
        g.add(2)

        assertEquals(13, g.scoreForFrame(1))
        assertEquals(18, g.scoreForFrame(2))
        assertEquals(18, g.score())
    }

    @Test
    fun testSimpleStrike() {
        g.add(10)
        g.add(3)
        g.add(6)

        assertEquals(19, g.scoreForFrame(1))
        assertEquals(28, g.score())
    }

    @Test
    fun testPerfectGame() {
        for (i in 0 until 12) {
            g.add(10)
        }
        assertEquals(300, g.score())
    }

    @Test
    fun testEndOfArray() {
        for (i in 0 until 9) {
            g.add(0)
            g.add(0)
        }

        g.add(2)
        g.add(8)
        g.add(10)

        assertEquals(20, g.score())
    }

    @Test
    fun testHeartBreak() {
        for (i in 0 until 11) {
            g.add(10)
        }
        g.add(9)
        assertEquals(299, g.score())
    }

    @Test
    fun testTenthFrameSpare() {
        for (i in 0 until 9) {
            g.add(10)
        }
        g.add(9)
        g.add(1)
        g.add(1)

        assertEquals(270, g.score())
    }

}
