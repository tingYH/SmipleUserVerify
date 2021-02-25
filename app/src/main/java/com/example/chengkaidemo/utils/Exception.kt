package com.example.chengkaidemo.utils

import java.io.IOException

/**
 *
 * @author ChengKai YH
 * @version $
 * <p/>
 * <p/> $
 */

class ApiException(message: String) : IOException(message)

class NoInternetException(message: String): IOException(message)