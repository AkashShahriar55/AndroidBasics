package com.akash.androidbasics

import android.app.Service
import android.content.Intent
import android.os.*
import android.widget.Toast


/**
 * it can be started (to run indefinitely) and also allow binding.
 * It's simply a matter of whether you implement a couple of callback methods: onStartCommand()
 * to allow components to start it and onBind() to allow binding.
 *
 * a service still runs in your application's main thread by default,
 * so you should still create a new thread within the service if it performs intensive or blocking operations.
 *
 *
 * If a component starts the service by calling startService()
 * (which results in a call to onStartCommand()),
 * the service continues to run until it stops itself with stopSelf()
 * or another component stops it by calling stopService().
 *
 *
 * If a component calls bindService() to create the service
 * and onStartCommand() is not called, the service runs only as long as the component is bound to it.
 * After the service is unbound from all of its clients, the system destroys it.
 *
 *
 * bound to an activity that has user focus ---- less likely to be killed
 * declared to run in the foreground ---- rarely killed
 *
 *
 *
 * If the system kills your service, it restarts it as soon as resources become available,
 * but this also depends on the value that you return from onStartCommand().
 *
 * it has a lifecycle that's independent of the component that started it
 *
 *
 */

// It runs on main thread by default


// It works just like an IntentService and processes all requests serially,
// one after another. You could change the code to run the work on a thread pool,
// for example, if you'd like to run multiple requests simultaneously.
class MyService: Service() {



    private var serviceLooper: Looper? = null
    private var serviceHandler: ServiceHandler? = null

    // Handler that receives messages from the thread
    private inner class ServiceHandler(looper: Looper) : Handler(looper) {

        override fun handleMessage(msg: Message) {
            // Normally we would do some work here, like download a file.
            // For our sample, we just sleep for 5 seconds.
            try {
                Thread.sleep(5000)
            } catch (e: InterruptedException) {
                // Restore interrupt status.
                Thread.currentThread().interrupt()
            }

            // Stop the service using the startId, so that we don't stop
            // the service in the middle of handling another job
            stopSelf(msg.arg1)
        }
    }



    /**
     * The system invokes this method by calling bindService()
     * when another component wants to bind with the service
     * (such as to perform RPC). In your implementation of this method,
     * you must provide an interface that clients use to communicate
     * with the service by returning an IBinder.
     * You must always implement this method; however,
     * if you don't want to allow binding, you should return null.
     */
    override fun onBind(intent: Intent?): IBinder? {
        // We don't provide binding, so return null
        return null
    }


    /**
     * The system invokes this method by calling startService() when another component
     * (such as an activity) requests that the service be started. When this method executes,
     * the service is started and can run in the background indefinitely. If you implement this,
     * it is your responsibility to stop the service when its work is complete by calling stopSelf()
     * or stopService(). If you only want to provide binding, you don't need to implement this method.
     *
     *  invokes by passing an intent to startService()
     */
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show()

        // For each start request, send a message to start a job and deliver the
        // start ID so we know which request we're stopping when we finish the job
        serviceHandler?.obtainMessage()?.also { msg ->
            msg.arg1 = startId
            serviceHandler?.sendMessage(msg)
        }

        // If we get killed, after returning from here, restart
        return START_STICKY
    }


    /**
     * The system invokes this method to perform one-time setup procedures
     * when the service is initially created (before it calls either onStartCommand() or onBind()).
     * If the service is already running, this method is not called.
     */
    override fun onCreate() {
        // Setup here

        // Start up the thread running the service.  Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block.  We also make it
        // background priority so CPU-intensive work will not disrupt our UI.
        HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND).apply {
            start()

            // Get the HandlerThread's Looper and use it for our Handler
            serviceLooper = looper
            serviceHandler = ServiceHandler(looper)
        }
    }


    /**
     * The system invokes this method when the service is no longer used and is being destroyed.
     * Your service should implement this to clean up any resources such as threads,
     * registered listeners, or receivers. This is the last call that the service receives.
     */
    override fun onDestroy() {
        Toast.makeText(this, "service done", Toast.LENGTH_SHORT).show()
    }





}