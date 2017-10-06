package org.ligi.kroom

import android.arch.persistence.room.RoomDatabase

fun <T : RoomDatabase> T.inTransaction(call: T.() -> Unit) {
    beginTransaction()
    call.invoke(this)
    endTransaction()
}
