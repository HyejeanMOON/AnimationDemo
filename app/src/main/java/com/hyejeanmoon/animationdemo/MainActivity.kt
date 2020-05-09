package com.hyejeanmoon.animationdemo

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hyejeanmoon.animationdemo.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val animator = ValueAnimator.ofFloat(0F, 5000F)
        animator.interpolator = LinearInterpolator()
        animator.setDuration(2000)

        val objectAnimator = ObjectAnimator.ofFloat(binding.textView, "rotation", 0F, 360F)
        objectAnimator.setEvaluator(CustomTypeEvaluator())
        objectAnimator.setDuration(2000)


        val colorObjectAnimator = ObjectAnimator.ofArgb(Color.BLACK, Color.WHITE, Color.BLACK)
        colorObjectAnimator.interpolator = AccelerateDecelerateInterpolator()
        colorObjectAnimator.setDuration(2000)
        colorObjectAnimator.repeatMode = ObjectAnimator.REVERSE
        colorObjectAnimator.addUpdateListener {
            binding.textView.setTextColor(it.animatedValue as Int)
        }

        animator.addUpdateListener {
            binding.textView.text = ((it.animatedValue as Float).toInt() / 100).toString()
            binding.bezierView.setValue(it.animatedValue as Float)
        }

        binding.start.setOnClickListener {
            colorObjectAnimator.start()
            animator.start()
            objectAnimator.start()
        }

        binding.pause.setOnClickListener {
            colorObjectAnimator.pause()
            animator.pause()
            objectAnimator.pause()
        }

        binding.stop.setOnClickListener {
            animator.end()
            objectAnimator.end()
        }

        binding.next.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, SecondActivity::class.java)
            startActivity(intent)
        }


    }

}

class CustomTypeEvaluator : TypeEvaluator<Float> {
    override fun evaluate(fraction: Float, startValue: Float?, endValue: Float?): Float {
        return fraction * abs(endValue ?: 0F - startValue!!)
    }
}
