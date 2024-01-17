package com.tencent.devops.process.pojo.template

import io.swagger.v3.oas.annotations.media.Schema

@Schema(title = "流水线模板信息")
class TemplatePipelineInfo(
    @Schema(title = "模板id", required = false)
    val templateId: String? = null,
    @Schema(title = "版本名称", required = false)
    val versionName: String? = null,
    @Schema(title = "版本", required = false)
    val version: Long? = null,
    @Schema(title = "流水线id", required = false)
    val pipelineId: String
)
