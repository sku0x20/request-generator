package com.example

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.*

class E2ETest {

    @Test
    fun excludeField() {
        val date = Date()
        val request = SimpleRequest(
            1,
            "2",
            3f,
            date
            // excludeThis being excluded
        )
        request.field2 = "var2"

        assertThat(request::class.isData).isTrue()
        assertThat(request::class.java.packageName).isEqualTo("com.example")
    }

    @Test
    fun multipleClassesInSameFile() {
        // in terms of compiled code.
        // for classes, it does not matter.
        // but for top level functions it generates a Kt class
        // so generating different files for each class no matter how they are declared

        val request1 = SameFileClass1Request(1)
        val request2 = SameFileClass2Request(1)
    }


    // test multiple classes in same file

    // nested fields with classes outside => need to change the type to `${type}Request` 
    // nested classes with nested fields => needs to fix creation of file logic...
    //      this also means nest inside the request object. same structure

    // when visiting i could some data too. that would make things easier esp multiple classes in same file
    // idk will see.
    // tbh imo, my visitor do not even need to create file we will create all the required files beforehand
    // my visitor will just write to those files. that makes sense.
    // instead of code generator we will pass the fileWrite, let's see
}