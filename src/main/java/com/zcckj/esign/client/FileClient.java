package com.zcckj.esign.client;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import com.zcckj.common.mvc.result.Result;
import com.zcckj.esign.client.interceptor.ESignRequestInterceptor;
import com.zcckj.esign.dto.req.GetFileUploadUrlReq;
import com.zcckj.esign.dto.res.GetFileUploadStatusRes;
import com.zcckj.esign.dto.res.GetFileUploadUrlRes;
import retrofit2.http.*;


@RetrofitClient(baseUrl = "${esign.base-url}")
@Intercept(handler = ESignRequestInterceptor.class)
public interface FileClient {
    /**
     * 获取文件上传地址
     *
     * @param req 请求体
     * @return
     */
    @POST("/v3/files/file-upload-url")
    Result<GetFileUploadUrlRes> getFileUploadUrl(@Body GetFileUploadUrlReq req);

    /**
     * 查询文件上传状态
     *
     * @param req 请求体
     * @return
     */
    @GET("/v3/files/{fileId}")
    Result<GetFileUploadStatusRes> getFileUploadStatus(@Path("fileId") String fileId, @Query("pageSize") Boolean pageSize);

}
