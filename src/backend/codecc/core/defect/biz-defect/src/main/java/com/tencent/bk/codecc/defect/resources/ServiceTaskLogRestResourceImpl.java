/*
 * Tencent is pleased to support the open source community by making BK-CODECC 蓝鲸代码检查平台 available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * BK-CODECC 蓝鲸代码检查平台 is licensed under the MIT license.
 *
 * A copy of the MIT License is included in this file.
 *
 *
 * Terms of the MIT License:
 * ---------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
 * NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.tencent.bk.codecc.defect.resources;

import com.tencent.bk.codecc.defect.api.ServiceTaskLogRestResource;
import com.tencent.bk.codecc.defect.service.TaskLogService;
import com.tencent.bk.codecc.defect.vo.TaskLogRepoInfoVO;
import com.tencent.bk.codecc.defect.vo.TaskLogVO;
import com.tencent.bk.codecc.defect.vo.UploadTaskLogStepVO;
import com.tencent.bk.codecc.task.vo.TaskDetailVO;
import com.tencent.devops.common.api.GetLastAnalysisResultsVO;
import com.tencent.devops.common.api.analysisresult.BaseLastAnalysisResultVO;
import com.tencent.devops.common.api.analysisresult.ToolLastAnalysisResultVO;
import com.tencent.devops.common.api.pojo.CodeCCResult;
import com.tencent.devops.common.service.BizServiceFactory;
import com.tencent.devops.common.service.IBizService;
import com.tencent.devops.common.web.RestResource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 工具侧上报任务分析记录接口实现
 *
 * @version V1.0
 * @date 2019/5/5
 */
@RestResource
public class ServiceTaskLogRestResourceImpl implements ServiceTaskLogRestResource
{
    @Autowired
    private TaskLogService taskLogService;

    @Autowired
    private BizServiceFactory<IBizService> bizServiceFactory;

    @Override
    public CodeCCResult<Boolean> stopRunningTask(String pipelineId, String streamName, Set<String> toolSet, String projectId, long taskId, String userName)
    {
        return new CodeCCResult<>(taskLogService.stopRunningTask(projectId, pipelineId, streamName, taskId, toolSet, userName));
    }


    @Override
    public CodeCCResult<TaskLogVO> getLatestTaskLog(long taskId, String toolName)
    {
        return new CodeCCResult<>(taskLogService.getLatestTaskLog(taskId, toolName.toUpperCase()));
    }

    @Override
    public CodeCCResult<List<ToolLastAnalysisResultVO>> getLastAnalysisResults(GetLastAnalysisResultsVO getLastAnalysisResultsVO)
    {
        long taskId = getLastAnalysisResultsVO.getTaskId();
        Set<String> toolSet = getLastAnalysisResultsVO.getToolSet();
        return new CodeCCResult<>(taskLogService.getLastAnalysisResults(taskId, toolSet));
    }

    @Override
    public CodeCCResult<BaseLastAnalysisResultVO> getLastStatisticResult(ToolLastAnalysisResultVO toolLastAnalysisResultVO)
    {
        return new CodeCCResult<>(taskLogService.getLastAnalysisResult(toolLastAnalysisResultVO, toolLastAnalysisResultVO.getToolName()));
    }

    @Override
    public CodeCCResult<List<ToolLastAnalysisResultVO>> getBatchLatestTaskLog(long taskId, Set<String> toolSet)
    {
        return new CodeCCResult<>(taskLogService.getLastAnalysisResults(taskId, toolSet));
    }

    @Override
    public CodeCCResult<Map<String, List<ToolLastAnalysisResultVO>>> getBatchTaskLatestTaskLog(List<TaskDetailVO> taskDetailVOList)
    {
        Map<String, List<ToolLastAnalysisResultVO>> taskAndLogMap = new HashMap<>();
        if (CollectionUtils.isNotEmpty(taskDetailVOList))
        {
            taskDetailVOList.forEach(taskDetailVO ->
                    taskAndLogMap.put(String.valueOf(taskDetailVO.getTaskId()), taskLogService.getLastTaskLogResult(taskDetailVO.getTaskId(), new HashSet<>(Arrays.asList(taskDetailVO.getToolNames().split(",")))))
            );
        }
        return new CodeCCResult<>(taskAndLogMap);
    }


    @Override
    public CodeCCResult<Boolean> uploadDirStructSuggestParam(UploadTaskLogStepVO uploadTaskLogStepVO)
    {
        if (StringUtils.isNotEmpty(uploadTaskLogStepVO.getToolName()))
        {
            uploadTaskLogStepVO.setToolName(uploadTaskLogStepVO.getToolName().toUpperCase());
        }
        return new CodeCCResult<>(taskLogService.uploadDirStructSuggestParam(uploadTaskLogStepVO));
    }

    @Override
    public CodeCCResult<Boolean> refreshTaskLogByPipeline(Long taskId, Set<String> toolNames)
    {
        return new CodeCCResult<>(taskLogService.refreshTaskLogByPipeline(taskId, toolNames));
    }

    @Override
    public CodeCCResult<Map<String, TaskLogRepoInfoVO>> getLastAnalyzeRepoInfo(Long taskId) {
        return new CodeCCResult<>(taskLogService.getLastAnalyzeRepoInfo(taskId));
    }
}
