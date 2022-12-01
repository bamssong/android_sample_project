package com.bamsong.app.core.domain.usecase

import com.bamsong.app.core.domain.entity.Content
import com.bamsong.app.core.domain.repository.ContentRepository

class ContentUseCaseImpl(
    private val contentRepository: ContentRepository
) : ContentUseCase {
    override fun getContent(type: String, contentId: String): Content {
        return contentRepository.getContent(type, contentId)
    }
}