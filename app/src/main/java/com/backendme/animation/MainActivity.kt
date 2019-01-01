package com.backendme.animation

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.CardView
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    private var isvisible = false
    var constraint: ConstraintLayout? = null // cache the ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(1024, 1024)
        setContentView(R.layout.activity_main2)
        constraint = findViewById(R.id.con1)
        val backarrow = findViewById<ImageView>(R.id.back)



        backarrow.setOnClickListener {
            if (isvisible)
                hideit()
            else
                showit()
        }


        val cardView = findViewById<CardView>(R.id.cardView)
        cardView.setOnClickListener {
            if (isvisible)
                hideit()
            else
                showit()
        }

    }

    private fun showit() {
        isvisible = true

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_main)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 900

        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet.applyTo(constraint)
    }

    private fun hideit() {
        isvisible = false

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_main2)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateOvershootInterpolator(1.0f)
        transition.duration = 900

        TransitionManager.beginDelayedTransition(constraint, transition)
        constraintSet.applyTo(constraint)
    }
}
