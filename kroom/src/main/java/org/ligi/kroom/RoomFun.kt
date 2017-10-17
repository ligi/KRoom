package org.ligi.kroom

import android.arch.persistence.room.RoomDatabase

inline fun <T : RoomDatabase> T.inTransaction(transaction: T.() -> Unit) = try {
    beginTransaction()
    transaction()
    setTransactionSuccessful()
} finally {
    endTransaction()
}
