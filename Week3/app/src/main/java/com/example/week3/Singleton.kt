package com.example.week3

class Singleton private constructor() {
    var userName : String = ""
        get() = field
        set(value) {field = value}
    var password: String = ""
        get() = field
        set(value) {field = value}
    var email: String = ""
        get() = field
        set(value) {field = value}
    var phoneNumber: String = ""
        get()= field
        set(value) {field = value}
    companion object {
        private var uniqInstance: Singleton? = null
        val instance: Singleton?
            get() {
                if (uniqInstance == null) uniqInstance = Singleton()
                return uniqInstance
            }
    }
}
