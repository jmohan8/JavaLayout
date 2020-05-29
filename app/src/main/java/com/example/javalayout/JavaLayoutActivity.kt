package com.example.javalayout

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet


class JavaLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_java_layout)
      configureLayout()

    }
    fun convertToPx(i: Int): Float {
        val r = resources
        val px: Float = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, i.toFloat(), r.displayMetrics)
        return px
    }


    fun configureLayout() {
        val myButton = Button(this)
        myButton.text = getString(R.string.press_me)
        myButton.setBackgroundColor(Color.YELLOW)
        myButton.id = R.id.myButton

        val myEditText = EditText(this)
//        myEditText.setBackgroundColor(GREEN)
        myEditText.id = R.id.myEditText

        val px = convertToPx(200).toInt()
        myEditText.width = px

        val myLayout = ConstraintLayout(this)
        myLayout.setBackgroundColor(Color.BLUE)
        myLayout.addView(myButton)
        myLayout.addView(myEditText)
        setContentView(myLayout)

        val set = ConstraintSet()
        set.constrainHeight(myButton.id, ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(myButton.id, ConstraintSet.WRAP_CONTENT)

        set.connect(myButton.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0)
        set.connect(myButton.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0)
        set.connect(myButton.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0)
        set.connect(myButton.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0)

        set.constrainHeight(myEditText.id, ConstraintSet.WRAP_CONTENT)
        set.constrainWidth(myEditText.id, ConstraintSet.WRAP_CONTENT)

        set.connect(myEditText.id, ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0)
        set.connect(myEditText.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0)
        set.connect(myEditText.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 8)
        set.connect(myEditText.id, ConstraintSet.BOTTOM, R.id.myButton, ConstraintSet.TOP, 78)
        set.applyTo(myLayout)

    }

}
