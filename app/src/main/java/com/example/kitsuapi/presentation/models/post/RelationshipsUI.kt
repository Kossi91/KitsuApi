package com.example.kitsuapi.presentation.models.post

import com.example.domain.models.post.Relationships
import com.example.kitsuapi.presentation.models.user.UserUI
import com.example.kitsuapi.presentation.models.user.toUI

data class RelationshipsUI(
    val spoiledUnit: SpoiledUnitUI,
    val targetGroup: TargetGroupUI,
    val comments: CommentsUI,
    val ama: AmaUI,
    val lockedBy: LockedByUI,
    val media: MediaUI,
    val user: UserUI,
    val targetUser: TargetUserUI,
    val postLikes: PostLikesUI,
    val uploads: UploadsUI
)

fun Relationships.toUI(): RelationshipsUI = RelationshipsUI(
    spoiledUnit.toUI(), targetGroup.toUI(), comments.toUI(), ama.toUI(), lockedBy.toUI(),
    media.toUI(), user.toUI(), targetUser.toUI(), postLikes.toUI(), uploads.toUI()
)