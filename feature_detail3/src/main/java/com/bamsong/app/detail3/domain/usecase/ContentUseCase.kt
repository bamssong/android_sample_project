package com.bamsong.app.detail3.domain.usecase

import com.bamsong.app.core.domain.entity.Content
import kotlinx.coroutines.flow.Flow

interface ContentUseCase {
    suspend fun getContent(type: String, contentId: String): Flow<Content>
}