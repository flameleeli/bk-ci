package com.tencent.devops.store.pojo.container

import io.swagger.v3.oas.annotations.media.Schema

@Schema(title = "操作系统信息")
data class ContainerOsInfo(
    @Schema(title = "OS", required = true)
    val os: String,
    @Schema(title = "NAME", required = true)
    val name: String
)
