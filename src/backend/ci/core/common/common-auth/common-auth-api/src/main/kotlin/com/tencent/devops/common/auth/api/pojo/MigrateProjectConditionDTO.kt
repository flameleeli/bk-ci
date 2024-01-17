package com.tencent.devops.common.auth.api.pojo

import com.tencent.devops.common.auth.enums.AuthSystemType
import io.swagger.v3.oas.annotations.media.Schema

@Schema(title = "条件迁移项目实体")
data class MigrateProjectConditionDTO(
    @Schema(title = "中心ID")
    val centerId: Long? = null,
    @Schema(title = "部门ID")
    val deptId: Long? = null,
    @Schema(title = "项目创建人")
    val projectCreator: String? = null,
    @Schema(title = "排除项目code")
    val excludedProjectCodes: List<String>? = null,
    @Schema(title = "项目ID列表")
    val projectCodes: List<String>? = null,
    @Schema(title = "资源类型")
    val resourceType: String? = null,
    @Schema(title = "路由tag")
    val routerTag: AuthSystemType? = null
)
