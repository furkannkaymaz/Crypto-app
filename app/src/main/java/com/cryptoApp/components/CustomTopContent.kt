package com.cryptoApp.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.fragment.app.FragmentActivity
import com.cryptoApp.base.BaseLinearLayout
import com.cryptoApp.databinding.LayTopContentBinding

class CustomTopContent(context: Context, attrs: AttributeSet? = null) :
    BaseLinearLayout<LayTopContentBinding>(context, attrs) {

    override fun createView(inflater: LayoutInflater): LayTopContentBinding {
        return LayTopContentBinding.inflate(inflater, this, true)
    }

    @SuppressLint("ClickableViewAccessibility", "Recycle")
    override fun viewCreated(attrs: AttributeSet?) {}

    fun setText(text : String , activity : FragmentActivity){
        binding.tvTitleHeader.text = text

    }

}