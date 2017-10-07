package org.ligi.kroom

import android.arch.persistence.room.RoomDatabase

fun <T : RoomDatabase> T.inTransaction(call: T.() -> Unit) = try {
    beginTransaction()
    call.invoke(this)
    setTransactionSuccessful()
} finally {
    endTransaction()
}
