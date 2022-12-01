package com.bamsong.app.core.domain.repository

import com.bamsong.app.core.domain.entity.Content

interface ContentRepository {
    fun getContent(type: String, contentId: String): Content
}