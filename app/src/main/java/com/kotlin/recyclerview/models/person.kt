package com.kotlin.recyclerview.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(val name: String?, val email: String?): Parcelable
