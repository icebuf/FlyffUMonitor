package com.icetang.flyffumonitor

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform