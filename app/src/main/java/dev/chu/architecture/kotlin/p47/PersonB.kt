package dev.chu.architecture.kotlin.p47

import javax.inject.Inject

class PersonB {
    @JvmField
    @Inject
    var name: String? = null  // 필드 주입

    private var age = 0

    // 메서드 주입
    @Inject
    fun setAge(age: Int) {
        this.age = age
    }

    fun getAge() = age

}