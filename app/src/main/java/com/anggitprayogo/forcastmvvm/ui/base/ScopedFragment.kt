package com.anggitprayogo.forcastmvvm.ui.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class ScopedFragment: Fragment(), CoroutineScope {

    private lateinit var jobs: Job

    override val coroutineContext: CoroutineContext
        get() = jobs + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jobs = Job()
    }

    override fun onDestroy() {
        super.onDestroy()
        jobs.cancel()
    }
}