package com.qlangtech.tis.job.common;

/**
 * @create: 2023-08-07 18:25
 **/
public interface JobParams {
    String KEY_TASK_ID = "taskid";
    /**
     * 上一次执行任务的TaskId
     */
    String KEY_PREVIOUS_TASK_ID = "preTaskId";
    String KEY_COLLECTION = "app";
    String KEY_LOG_TYPE = "logtype";


    String KEY_JAVA_MEMORY_SPEC = "javaMemorySpec";
}
