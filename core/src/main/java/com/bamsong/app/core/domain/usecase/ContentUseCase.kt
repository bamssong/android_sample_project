package com.bamsong.app.core.domain.usecase

import com.bamsong.app.core.domain.entity.Content

interface ContentUseCase {
    fun getContent(type: String, contentId: String): Content
}