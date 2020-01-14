package com.example.benchmark

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.random.Random

private const val JETPACK = "images/jetpack.png"

@LargeTest
@RunWith(AndroidJUnit4::class)
class SetAlphaBenchmark {

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    private val context = ApplicationProvider.getApplicationContext<Context>()
    private lateinit var bitmap: Bitmap
    private lateinit var paint: Paint
    private lateinit var canvas: Canvas

    @Before
    fun setUp() {
        val inputStream = context.assets.open(JETPACK)
        bitmap = BitmapFactory.decodeStream(inputStream)
        inputStream.close()
        paint = Paint()
        canvas = Canvas()
    }

    /**
     * Measure the cost of many relatively cheaper JNI calls to fetch a row of pixels, one pixel at
     * a time.
     */
    @Test
    fun testSetAlpha() {
        benchmarkRule.measureRepeated {
            setAlpha()
        }
    }

    /**
     * Measure the cost of a single expensive JNI call to fetch a row of 100 pixels.
     */
    @Test
    fun testDrawBitmap() {
        benchmarkRule.measureRepeated {
            drawBitmap()
        }
    }

    private fun setAlpha() {
        for (i in 0..9999) {
//            val alpha: Int = Random.nextInt(255)
//            paint.setAlpha(alpha)
            paint.setAlpha(128)
        }
    }

    private fun drawBitmap() {
        for (i in 0..9999) {
            canvas.drawBitmap(bitmap, 0f, 0f, paint)
        }
    }

}
