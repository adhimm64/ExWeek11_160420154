package com.example.advweek4_kp_c.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.advweek4_kp_c.model.Student

class DetailViewModel(application: Application): AndroidViewModel(application) {
    val studentLD = MutableLiveData<Student>()

    fun fetch() {
        val student1 = Student(
            "16055", "Nonie", "1998/03/28", "5718444778",
            "http://dummyimage.com/75x100.jpg/cc0000/ffffff"
        )
        studentLD.value = student1
    }
}