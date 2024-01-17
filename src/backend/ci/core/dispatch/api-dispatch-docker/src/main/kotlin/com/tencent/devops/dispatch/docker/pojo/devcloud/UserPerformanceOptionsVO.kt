package com.tencent.devops.dispatch.docker.pojo.devcloud

import io.swagger.v3.oas.annotations.media.Schema

@Schema(title = "devcloud性能用户选项配置")
data class UserPerformanceOptionsVO(
    @Schema(title = "默认选项")
    val default: String,
    @Schema(title = "是否展示")
    val needShow: Boolean,
    @Schema(title = "性能配置")
    val performanceMaps: List<PerformanceMap>
)

data class PerformanceMap(
    val id: String,
    val performanceConfigVO: PerformanceConfigVO
)
