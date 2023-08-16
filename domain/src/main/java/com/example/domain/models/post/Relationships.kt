package com.example.domain.models.post

import com.example.domain.models.user.User

data class Relationships(
    val spoiledUnit: SpoiledUnit,
    val targetGroup: TargetGroup,
    val comments: Comments,
    val ama: Ama,
    val lockedBy: LockedBy,
    val media: Media,
    var user: User,
    val targetUser: TargetUser,
    val postLikes: PostLikes,
    val uploads: Uploads
)
