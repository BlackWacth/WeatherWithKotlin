package com.bruce.weather

import com.bruce.weather.extensions.toDataString
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.DateFormat

class ExtensionTests {

    @Test
    fun testLongToDateString() {
        assertEquals("2015-10-20", 1445275635000L.toDataString())
    }

    @Test
    fun testDateStringFullFormat() {
        assertEquals("2015年10月20日 星期二", 1445275635000L.toDataString(DateFormat.FULL))
    }
}