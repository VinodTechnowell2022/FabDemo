package com.tw.fabdemo

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tw.fabdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding
    val TAG: String = this.javaClass.simpleName

    // Initializing the animations class object
    private val rotateOpenAnimation: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_animation) }
    private val rotateCloseAnimation: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_animation) }
    private val fromBottomAnimation: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_animation) }
    private val toBottomAnimation: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom_animation) }
    private var addButtonClicked = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)


        fabClickListeners()
    }

    private fun fabClickListeners() {
        mBinding.fabPlus.setOnClickListener {
            Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show()
            onAddButtonClicked()
        }
        mBinding.fabLayer.setOnClickListener {
            Toast.makeText(this, "Layers", Toast.LENGTH_SHORT).show()
        }
        mBinding.fabMyLocation.setOnClickListener {
            Toast.makeText(this, "Location", Toast.LENGTH_SHORT).show()
        }

        mBinding.fabNavigate.setOnClickListener {
            Toast.makeText(this, "Navigation", Toast.LENGTH_SHORT).show()
        }

        mBinding.fabRefresh.setOnClickListener {
            Toast.makeText(this@MainActivity, "Refresh", Toast.LENGTH_LONG).show()
        }

        mBinding.fabInfo.setOnClickListener {
            Toast.makeText(this@MainActivity, "Info", Toast.LENGTH_LONG).show()

        }


    }

    private fun onAddButtonClicked() {
        setVisibility(addButtonClicked)
        setAnimation(addButtonClicked)
        buttonSetClickable()

        if (!addButtonClicked){
            addButtonClicked = true
        }else{
            addButtonClicked = false
        }
    }

    //Setting call and message buttons visible
    private fun setVisibility(buttonClicked: Boolean) {
        if (!buttonClicked){
            mBinding.fabLayer.visibility = View.VISIBLE
            mBinding.fabMyLocation.visibility = View.VISIBLE
            mBinding.fabNavigate.visibility = View.VISIBLE
            mBinding.fabRefresh.visibility = View.VISIBLE
            mBinding.fabInfo.visibility = View.VISIBLE
        }else{
            mBinding.fabLayer.visibility = View.INVISIBLE
            mBinding.fabMyLocation.visibility = View.INVISIBLE
            mBinding.fabNavigate.visibility = View.INVISIBLE
            mBinding.fabRefresh.visibility = View.INVISIBLE
            mBinding.fabInfo.visibility = View.INVISIBLE
        }
    }

    //Setting the animation on the buttons
    private fun setAnimation(buttonClicked: Boolean) {
        if (!buttonClicked){
            mBinding.fabLayer.startAnimation(fromBottomAnimation)
            mBinding.fabMyLocation.startAnimation(fromBottomAnimation)
            mBinding.fabNavigate.startAnimation(fromBottomAnimation)
            mBinding.fabRefresh.startAnimation(fromBottomAnimation)
            mBinding.fabInfo.startAnimation(fromBottomAnimation)
            mBinding.fabPlus.startAnimation(rotateOpenAnimation)

        }else{
            mBinding.fabLayer.startAnimation(toBottomAnimation)
            mBinding.fabMyLocation.startAnimation(toBottomAnimation)
            mBinding.fabNavigate.startAnimation(toBottomAnimation)
            mBinding.fabRefresh.startAnimation(toBottomAnimation)
            mBinding.fabInfo.startAnimation(toBottomAnimation)
            mBinding.fabPlus.startAnimation(rotateCloseAnimation)
        }
    }

    //Checking if the add button is clicked
    private fun buttonSetClickable() {
        if (!addButtonClicked){
            mBinding.fabLayer.isClickable = true
            mBinding.fabMyLocation.isClickable = true
            mBinding.fabNavigate.isClickable = true
            mBinding.fabRefresh.isClickable = true
            mBinding.fabInfo.isClickable = true
        }else{
            mBinding.fabLayer.isClickable = false
            mBinding.fabMyLocation.isClickable = false
            mBinding.fabNavigate.isClickable = false
            mBinding.fabRefresh.isClickable = false
            mBinding.fabInfo.isClickable = false
        }
    }

}