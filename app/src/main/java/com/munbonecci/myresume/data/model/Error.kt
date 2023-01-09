package com.munbonecci.myresume.data.model

data class Error(
    val errorCode: Int = 0,
    val errorMessage: String = ""
) {
    override fun toString(): String = errorMessage
}