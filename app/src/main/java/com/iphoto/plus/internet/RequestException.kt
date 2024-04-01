package com.iphoto.plus.internet

import java.lang.RuntimeException

class RequestException constructor(
    response:String
): RuntimeException(response)
