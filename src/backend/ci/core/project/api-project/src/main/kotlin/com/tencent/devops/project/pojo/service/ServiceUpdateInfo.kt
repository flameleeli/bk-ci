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

package com.tencent.devops.project.pojo.service

import io.swagger.v3.oas.annotations.media.Schema

@Schema(title = "服务-修改模型 只传要修改的字段,其他放空表示不修改)")
data class ServiceUpdateInfo(
    @Schema(title = "服务ID，如果为空，则使用englishName作为主键进行检索更新，如果是要更新englishName，则该字段作为检索字段不能为空")
    var serviceId: Long?,
    @Schema(title = "服务名称，英文名")
    var englishName: String?,
    @Schema(title = "服务名称，中文名")
    val name: String?,
    @Schema(title = "服务类型ID，1:项目管理 2:开发 3:测试 4:部署 5:运营 6:安全 8:管理工具")
    val serviceTypeId: Long?,
    @Schema(title = "是否展示项目列表")
    val showProjectList: Boolean?,
    @Schema(title = "是否在服务导航条上显示")
    val showNav: Boolean?,
    @Schema(title = "服务状态 ok=正常(可用) planning=规划中(灰色不可用) new=新上线(可用)")
    val status: String?,
    @Schema(title = "是否被软删除，变成不可见")
    val deleted: Boolean?,
    @Schema(title = "链接1，例如 /pipeline/")
    val link: String?,
    @Schema(title = "链接2与链接1保持一样，例如 /pipeline/")
    val linkNew: String?,
    @Schema(title = "注入类型：amd/iframe")
    val injectType: String?,
    @Schema(title = "iframeUrl")
    val iframeUrl: String?,
    @Schema(title = "grayIframeUrl 目前没用")
    val grayIframeUrl: String?,
    @Schema(title = "cssUrl")
    val cssUrl: String?,
    @Schema(title = "jsUrl")
    val jsUrl: String?,
    @Schema(title = "grayCssUrl 目前没用")
    val grayCssUrl: String?,
    @Schema(title = "grayJsUrl 目前没用")
    val grayJsUrl: String?,
    @Schema(title = "projectIdType")
    val projectIdType: String?,
    @Schema(title = "权重")
    val weight: Int?,
    @Schema(title = "logo地址")
    val logoUrl: String?,
    @Schema(title = "支持webSocket的页面")
    val webSocket: String?,
    @Schema(title = "集群类型")
    val clusterType: String? = ""
)
