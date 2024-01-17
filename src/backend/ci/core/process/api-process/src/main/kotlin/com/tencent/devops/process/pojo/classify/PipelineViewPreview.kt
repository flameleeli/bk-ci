package com.tencent.devops.process.pojo.classify

import io.swagger.v3.oas.annotations.media.Schema

@Schema(title = "Pipeline视图预览")
data class PipelineViewPreview(
    @Schema(title = "新增的流水线ID列表", required = true)
    val addedPipelineInfos: List<PipelineInfo>,
    @Schema(title = "删除的流水线ID列表", required = true)
    val removedPipelineInfos: List<PipelineInfo>,
    @Schema(title = "保留的流水线ID列表", required = true)
    val reservePipelineInfos: List<PipelineInfo>
) {
    data class PipelineInfo(
        @Schema(title = "名称", required = true)
        val pipelineName: String,
        @Schema(title = "ID", required = true)
        val pipelineId: String,
        @Schema(title = "是否删除", required = true)
        val delete: Boolean
    )

    companion object {
        val EMPTY = PipelineViewPreview(emptyList(), emptyList(), emptyList())
    }
}
