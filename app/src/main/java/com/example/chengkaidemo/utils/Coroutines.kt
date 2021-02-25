package com.example.chengkaidemo.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *
 * @author ChengKai YH
 * @version $
 * <p/>
 * <p/> $
 */
object Coroutines {
    // unit equal void
    fun main(work: suspend (() ->Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }
}