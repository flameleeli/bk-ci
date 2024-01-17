package com.tencent.devops.auth.pojo

import io.swagger.v3.oas.annotations.media.Schema

@Schema(title = "申请加入用户组itsm表单内容")
data class ApplyJoinGroupFormDataInfo(
    @Schema(title = "项目名称")
    val projectName: String,
    @Schema(title = "资源名称类型")
    val resourceTypeName: String,
    @Schema(title = "资源名称")
    val resourceName: String,
    @Schema(title = "用户组名称")
    val groupName: String,
    @Schema(title = "申请期限")
    val validityPeriod: String,
    @Schema(title = "资源跳转链接")
    val resourceRedirectUri: String? = null,
    @Schema(title = "用户组权限详情跳转链接")
    val groupPermissionDetailRedirectUri: String? = null
)
