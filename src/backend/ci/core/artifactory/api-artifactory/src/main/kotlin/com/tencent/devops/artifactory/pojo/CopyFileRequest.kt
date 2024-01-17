package com.tencent.devops.artifactory.pojo

import com.tencent.devops.artifactory.pojo.enums.ArtifactoryType
import io.swagger.v3.oas.annotations.media.Schema

@Schema(title = "拷贝文件请求")
data class CopyFileRequest(
    @Schema(title = "项目ID")
    val projectId: String,
    @Schema(title = "源制品类型")
    val srcArtifactoryType: ArtifactoryType,
    @Schema(title = "源文件完整路径")
    val srcFileFullPaths: List<String>,
    @Schema(title = "目标制品类型")
    val dstArtifactoryType: ArtifactoryType = ArtifactoryType.CUSTOM_DIR,
    @Schema(title = "目标目录完整路径")
    val dstDirFullPath: String
)
