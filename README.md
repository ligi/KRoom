Why?
====


I was writing a extension function for room in the WALLETH project and realized I will use this in more projects. So to be DRY this is the place.
Currently it is only this one:

```kotlin
fun <T : RoomDatabase> T.inTransaction(call: T.() -> Unit) = try {
    beginTransaction()
    call.invoke(this)
    setTransactionSuccessful()
} finally {
    endTransaction()
}
```

So you can do:
```kotlin
myDatabase.inTransaction { 
    addressBook.upsert(newAddress) 
}
```

in your app.

If you have other useful Kotlin extension functions for room let me know!

Where?
======

get it via jitpack:

[![Release](https://jitpack.io/v/ligi/kroom.svg)](https://jitpack.io/#ligi/kroom)

License
=======

MIT License
