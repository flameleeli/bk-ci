package com.tencent.devops.process.pojo.classify

import com.tencent.devops.process.constant.PipelineViewType
import com.tencent.devops.process.pojo.classify.enums.Logic
import io.swagger.v3.oas.annotations.media.Schema

@Schema(title = "流水线视图表单")
data class PipelineViewForm(
    @Schema(title = "ID", required = false)
    val id: String? = null,
    @Schema(title = "视图名称", required = false)
    var name: String,
    @Schema(title = "是否项目", required = false)
    val projected: Boolean,
    @Schema(title = "流水线组类型,1--动态,2--静态")
    var viewType: Int = PipelineViewType.UNCLASSIFIED,
    @Schema(title = "逻辑符", required = false)
    val logic: Logic = Logic.AND,
    @Schema(title = "流水线视图过滤器列表", required = false)
    val filters: List<PipelineViewFilter> = emptyList(),
    @Schema(title = "流水线列表", required = false)
    val pipelineIds: List<String>? = null
)
