package com.example.venturustest.components

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.venturustest.R

class HorizontalTextIconView constructor(context: Context, attrs: AttributeSet): ConstraintLayout(context, attrs) {

    init {
        inflate(context, R.layout.component_horizontal_text_icon ,this)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.HorizontalTextIconView)
        val icon = attributes.getResourceId(R.styleable.HorizontalTextIconView_icon, R.drawable.ic_launcher_foreground)
        attributes.recycle()

        findViewById<ImageView>(R.id.iv_icon).setImageResource(icon)
    }

    fun setValue(text: String) {
        findViewById<TextView>(R.id.tv_value).text = text
    }

}