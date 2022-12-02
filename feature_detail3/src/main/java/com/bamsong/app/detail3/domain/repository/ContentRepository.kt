package com.bamsong.app.detail3.domain.repository

import com.bamsong.app.core.domain.entity.Content
import kotlinx.coroutines.flow.Flow

interface ContentRepository {
    suspend fun getContent(type: String, contentId: String): Flow<Content>
}
