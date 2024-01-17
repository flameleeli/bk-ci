package com.tencent.devops.auth.pojo.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(title = "迁移资源请求实体")
data class MigrateResourceDTO(
    @Schema(title = "资源类型")
    val resourceType: String? = null,
    @Schema(title = "项目ID列表")
    val projectCodes: List<String>? = null,
    @Schema(title = "是否迁移项目级资源")
    val migrateProjectResource: Boolean? = false,
    @Schema(title = "是否迁移项目级默认用户组")
    val migrateProjectDefaultGroup: Boolean? = false,
    @Schema(title = "是否迁移其他资源类型的资源")
    val migrateOtherResource: Boolean? = false
)
