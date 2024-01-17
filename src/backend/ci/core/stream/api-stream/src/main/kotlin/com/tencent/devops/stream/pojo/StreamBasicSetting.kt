/*
 * Tencent is pleased to support the open source community by making BK-CI 蓝鲸持续集成平台 available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * BK-CI 蓝鲸持续集成平台 is licensed under the MIT license.
 *
 * A copy of the MIT License is included in this file.
 *
 *
 * Terms of the MIT License:
 * ---------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.tencent.devops.stream.pojo

import io.swagger.v3.oas.annotations.media.Schema

@Schema(title = "蓝盾stream 项目配置V2")
data class StreamBasicSetting(
    @Schema(title = "stream 项目ID")
    override val gitProjectId: Long,
    @Schema(title = "stream 项目名")
    override val name: String,
    @Schema(title = "stream 项目url")
    override val url: String,
    @Schema(title = "homepage")
    override val homepage: String,
    @Schema(title = "gitHttpUrl")
    override val gitHttpUrl: String,
    @Schema(title = "gitSshUrl")
    override val gitSshUrl: String,
    @Schema(title = "是否启用CI")
    val enableCi: Boolean,
    @Schema(title = "Build pushed branches")
    val buildPushedBranches: Boolean = true,
    @Schema(title = "Build pushed pull request")
    val buildPushedPullRequest: Boolean = true,
    @Schema(title = "创建时间")
    val createTime: Long?,
    @Schema(title = "修改时间")
    val updateTime: Long?,
    @Schema(title = "蓝盾项目Code")
    val projectCode: String?,
    @Schema(title = "是否开启Mr锁定")
    val enableMrBlock: Boolean = true,
    @Schema(title = "Stream开启人")
    val enableUserId: String,
    @Schema(title = "Stream开启人所在事业群")
    var creatorBgName: String?,
    @Schema(title = "Stream开启人所在部门")
    var creatorDeptName: String?,
    @Schema(title = "Stream开启人所在中心")
    var creatorCenterName: String?,
    @Schema(title = "GIT项目的描述信息")
    val gitProjectDesc: String?,
    @Schema(title = "GIT项目的头像信息")
    val gitProjectAvatar: String?,
    @Schema(title = "带有名空间的项目名称")
    val nameWithNamespace: String,
    @Schema(title = "带有名空间的项目路径")
    val pathWithNamespace: String?,
    @Schema(title = "项目最后一次构建的CI信息")
    val lastCiInfo: StreamCIInfo?,
    @Schema(title = "项目下构建是否发送commitCheck")
    val enableCommitCheck: Boolean = true,
    @Schema(title = "项目下构建是否发送mrComment")
    val enableMrComment: Boolean = true,
    @Schema(title = "pr、mr触发时的权限校验")
    val triggerReviewSetting: TriggerReviewSetting = TriggerReviewSetting()
) : StreamBaseRepository(gitProjectId, name, url, homepage, gitHttpUrl, gitSshUrl)

@Schema(title = "蓝盾stream 页面修改配置")
data class StreamUpdateSetting(
    @Schema(title = "Build pushed branches")
    val buildPushedBranches: Boolean,
    @Schema(title = "Build pushed pull request")
    val buildPushedPullRequest: Boolean,
    @Schema(title = "是否开启Mr锁定")
    val enableMrBlock: Boolean
)

@Schema(title = "mr触发时的权限校验相关配置")
data class TriggerReviewSetting(
    @Schema(title = "主库开发者及以上的用户提交的pr、mr是否默认给触发")
    val memberNoNeedApproving: Boolean = true,
    @Schema(title = "白名单，可以是用户或者项目id")
    val whitelist: List<String> = emptyList()
)
