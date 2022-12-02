package com.bamsong.app.detail3.domain.usecase

import com.bamsong.app.core.domain.entity.Content
import com.bamsong.app.detail3.domain.repository.ContentRepository
import kotlinx.coroutines.flow.Flow

class ContentUseCaseImpl(
    private val contentRepository: ContentRepository
) : ContentUseCase {
    override suspend fun getContent(type: String, contentId: String): Flow<Content> {
        return contentRepository.getContent(type, contentId)
    }
}