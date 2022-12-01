package com.bamsong.app.core.domain.entity

data class Content(
    val type: String,
    val id: String,
    val name: String,
    val desc: String
)

fun emptyContent() = Content("", "", "", "")