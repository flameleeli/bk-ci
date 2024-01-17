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

package com.tencent.devops.project.pojo.user

import com.tencent.devops.project.pojo.DeptInfo
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 用户机构信息
 *
 * since: 2018-12-09
 */
@Schema(title = "用户部门信息")
data class UserDeptDetail(
    @Schema(title = "bg名称")
    val bgName: String,
    @Schema(title = "bgID")
    val bgId: String,
    @Schema(title = "业务线名称")
    val businessLineName: String? = null,
    @Schema(title = "业务线ID")
    val businessLineId: String? = null,
    @Schema(title = "部门名称")
    val deptName: String,
    @Schema(title = "部门ID")
    val deptId: String,
    @Schema(title = "中心名称")
    val centerName: String,
    @Schema(title = "中心ID")
    val centerId: String,
    @Schema(title = "组ID")
    val groupId: String,
    @Schema(title = "组名称")
    val groupName: String,
    @Schema(title = "用户ID")
    val userId: String? = null,
    @Schema(title = "用户名称")
    val name: String? = null,
    @Schema(title = "部门及以上层级")
    val deptInfos: List<DeptInfo>? = emptyList()
)
