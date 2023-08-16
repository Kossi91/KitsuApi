package com.example.data.network.remote.dtos.post

import com.example.data.network.remote.dtos.user.UserDto
import com.example.data.network.remote.dtos.user.toDomain
import com.example.domain.models.post.Relationships
import com.google.gson.annotations.SerializedName

data class RelationshipsDto(
    @SerializedName("spoiledUnit")
    val spoiledUnit: SpoiledUnitDto,
    @SerializedName("targetGroup")
    val targetGroup: TargetGroupDto,
    @SerializedName("comments")
    val comments: CommentsDto,
    @SerializedName("ama")
    val ama: AmaDto,
    @SerializedName("lockedBy")
    val lockedBy: LockedByDto,
    @SerializedName("media")
    val media: MediaDto,
    @SerializedName("user")
    val user: UserDto,
    @SerializedName("targetUser")
    val targetUser: TargetUserDto,
    @SerializedName("postLikes")
    val postLikes: PostLikesDto,
    @SerializedName("uploads")
    val uploads: UploadsDto
)

fun RelationshipsDto.toDomain(): Relationships = Relationships(
    spoiledUnit.toDomain(), targetGroup.toDomain(), comments.toDomain(),ama.toDomain(),
    lockedBy.toDomain(),media.toDomain(),user.toDomain(), targetUser.toDomain(), postLikes.toDomain(),uploads.toDomain()
)
