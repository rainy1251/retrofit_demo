package com.example.retrofit_demo.internet

import java.lang.RuntimeException

class RequestException constructor(
    response:String
): RuntimeException(response)
