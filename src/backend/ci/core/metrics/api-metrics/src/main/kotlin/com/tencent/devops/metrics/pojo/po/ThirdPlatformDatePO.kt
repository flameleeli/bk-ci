package com.tencent.devops.metrics.pojo.po

import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDateTime

@Schema(title = "第三方平台数据对象")
data class ThirdPlatformDatePO(
    @Schema(title = "主键ID")
    val id: Long,
    @Schema(title = "项目ID")
    val projectId: String,
    @Schema(title = "codecc检查代码库平均分")
    val repoCodeccAvgScore: BigDecimal?,
    @Schema(title = "已解决缺陷数")
    val resolvedDefectNum: Int?,
    @Schema(title = "使用质量红线的流水线执行被拦截次数")
    val qualityPipelineInterceptionNum: Int?,
    @Schema(title = "使用质量红线的流水线执行总次数")
    val qualityPipelineExecuteNum: Int?,
    @Schema(title = "编译加速节省时间，单位：秒")
    val turboSaveTime: BigDecimal?,
    @Schema(title = "统计时间")
    val statisticsTime: LocalDateTime,
    @Schema(title = "创建者")
    val creator: String? = null,
    @Schema(title = "修改者")
    val modifier: String? = null,
    @Schema(title = "修改时间")
    val updateTime: LocalDateTime,
    @Schema(title = "创建时间")
    val createTime: LocalDateTime
)
