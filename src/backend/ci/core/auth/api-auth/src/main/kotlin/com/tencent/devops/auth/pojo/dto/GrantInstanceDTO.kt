package com.tencent.devops.auth.pojo.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(title = "实例授权入参")
data class GrantInstanceDTO(
    @Schema(title = "资源类型, 如：pipeline,project等")
    val resourceType: String,
    @Schema(title = "资源实例编码, 如：pipelineId,projectId等")
    val resourceCode: String,
    @Schema(title = "资源名称")
    val resourceName: String?,
    @Schema(title = "权限类型, 如：create,edit等")
    val permission: String,
    @Schema(title = "目标操作用户")
    val createUser: String
)
