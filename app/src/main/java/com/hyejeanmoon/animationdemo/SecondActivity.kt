package com.hyejeanmoon.animationdemo

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hyejeanmoon.animationdemo.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivitySecondBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_second)

        binding.alpha.setOnClickListener {
            val objectAnimator = ObjectAnimator.ofFloat(binding.imageView, "alpha", 1F, 0F, 1F)
            objectAnimator.setDuration(2000)
            objectAnimator.start()
        }

        binding.rotation.setOnClickListener {
            val objectAnimator = ObjectAnimator.ofFloat(binding.imageView, "rotation", 0F, 360F, 0F)
            objectAnimator.setDuration(2000)
            objectAnimator.start()
        }

        binding.rotationX.setOnClickListener {
            val objectAnimator =
                ObjectAnimator.ofFloat(binding.imageView, "rotationX", 0F, 360F, 0F)
            objectAnimator.setDuration(2000)
            objectAnimator.start()
        }

        binding.rotationY.setOnClickListener {
            val objectAnimator =
                ObjectAnimator.ofFloat(binding.imageView, "rotationY", 0F, 360F, 0F)
            objectAnimator.setDuration(2000)
            objectAnimator.start()
        }

        binding.translationX.setOnClickListener {
            val objectAnimator =
                ObjectAnimator.ofFloat(binding.imageView, "translationX", 0F, 360F, 0F)
            objectAnimator.setDuration(2000)
            objectAnimator.start()
        }

        binding.translationY.setOnClickListener {
            val objectAnimator =
                ObjectAnimator.ofFloat(binding.imageView, "translationY", 0F, 360F, 0F)
            objectAnimator.setDuration(2000)
            objectAnimator.start()
        }

        binding.scaleX.setOnClickListener {
            val objectAnimator =
                ObjectAnimator.ofFloat(binding.imageView, "scaleX", 1F, 3F, 1F)
            objectAnimator.setDuration(2000)
            objectAnimator.start()
        }

        binding.scaleY.setOnClickListener {
            val objectAnimator =
                ObjectAnimator.ofFloat(binding.imageView, "scaleY", 1F, 3F, 1F)
            objectAnimator.setDuration(2000)
            objectAnimator.start()
        }
    }

}