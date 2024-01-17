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

package com.tencent.devops.common.pipeline.pojo.element.trigger

import com.tencent.devops.common.pipeline.enums.StartType
import com.tencent.devops.common.pipeline.pojo.element.Element
import io.swagger.v3.oas.annotations.media.Schema

@Schema(title = "手动触发")
data class ManualTriggerElement(
    @Schema(title = "任务名称", required = true)
    override val name: String = "手动触发",
    @Schema(title = "id", required = false)
    override var id: String? = null,
    @Schema(title = "状态", required = false)
    override var status: String? = null,
    @Schema(title = "是否可跳过插件", required = false)
    var canElementSkip: Boolean? = false,
    @Schema(title = "是否使用最近一次的参数进行构建", required = false)
    var useLatestParameters: Boolean? = false
) : Element(name, id, status) {
    companion object {
        const val classType = "manualTrigger"
    }

    override fun getClassType() = classType

    private val startTypeSet = setOf(StartType.MANUAL.name, StartType.SERVICE.name, StartType.PIPELINE.name)

    override fun findFirstTaskIdByStartType(startType: StartType): String {
        return if (startTypeSet.contains(startType.name)) {
            this.id!!
        } else {
            super.findFirstTaskIdByStartType(startType)
        }
    }
}
