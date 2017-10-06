I was writing a extension function for room in the WALLETH project and realized I will use this in more projects. So be DRY this is the place.
Currently it is only this one:

```kotlin
fun <T : RoomDatabase> T.inTransaction(call: T.() -> Unit) {
    beginTransaction()
    call.invoke(this)
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