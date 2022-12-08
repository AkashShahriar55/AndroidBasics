package com.akash.androidbasics

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.akash.androidbasics.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private var count = 0
    lateinit var binding:ActivityMainBinding

    companion object{
        const val TAG = "MainActivity"
    }


    /**
     * your implementation of onCreate() might bind data to lists,
     * associate the activity with a ViewModel, and instantiate some class-scope variables.
     * This method receives the parameter savedInstanceState,
     * which is a Bundle object containing the activity's previously saved state.
     * If the activity has never existed before, the value of the Bundle object is null.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myLayout.setOnClickListener {
            incrementCount()
        }

        binding.serviceActivity.setOnClickListener {
            val intent = Intent(this,ServiceActivity::class.java)
            startActivity(intent)
        }

    }



    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        Log.d(TAG, "onCreateView: ")
        return super.onCreateView(name, context, attrs)

    }


    /**
     * The onStart() call makes the activity visible to the user,
     * as the app prepares for the activity to enter the foreground
     * and become interactive. For example, this method is where
     * the app initializes the code that maintains the UI.
     */
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        Log.d(TAG, "onPostCreate: ")
    }


    /**
     * This is the state in which the app interacts with the user. T
     * he app stays in this state until something happens to
     * take focus away from the app. Such an event might be,
     * for instance, receiving a phone call, the user’s navigating to
     * another activity, or the device screen’s turning off.
     */
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
        incrementCount()
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        Log.d(TAG, "onResumeFragments: ")
    }

    override fun onPostResume() {
        super.onPostResume()
        Log.d(TAG, "onPostResume: ")
    }

    override fun onEnterAnimationComplete() {
        super.onEnterAnimationComplete()
        Log.d(TAG, "onEnterAnimationComplete: ")
    }


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.d(TAG, "onAttachedToWindow: ")
    }




    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }


    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        super.onActivityReenter(resultCode, data)
        Log.d(TAG, "onActivityReenter: ")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.d(TAG, "onDetachedFromWindow: ")
    }




    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }



    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d(TAG, "onSaveInstanceState: out ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: ")
    }






    private fun incrementCount() {
        binding.myText.text = (++count).toString()
    }


    override fun onNavigateUp(): Boolean {
        Log.d(TAG, "onNavigateUp: ")
        return super.onNavigateUp()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Log.d(TAG, "onBackPressed: ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState: ")
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d(TAG, "onConfigurationChanged: ")
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.d(TAG, "onTouchEvent: ")
        return super.onTouchEvent(event)
       
    }


    override fun onUserInteraction() {
        super.onUserInteraction()
        Log.d(TAG, "onUserInteraction: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }



}