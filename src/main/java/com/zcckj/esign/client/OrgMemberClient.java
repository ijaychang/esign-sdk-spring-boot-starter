package com.zcckj.esign.client;

import com.github.lianjiatech.retrofit.spring.boot.core.RetrofitClient;
import com.github.lianjiatech.retrofit.spring.boot.interceptor.Intercept;
import com.zcckj.esign.client.interceptor.ESignRequestInterceptor;
import com.zcckj.esign.dto.R;
import com.zcckj.esign.dto.res.GetAdministratorsRes;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 企业成员管理
 *
 * @author zhangjie
 */
@RetrofitClient(baseUrl = "${esign.base-url}")
@Intercept(handler = ESignRequestInterceptor.class)
public interface OrgMemberClient {

    /**
     * 查询企业管理员
     *
     * @return
     */
    @POST("/v3/organizations/{orgId}/administrators")
    R<GetAdministratorsRes> getAdministrators(@Path("orgId") String orgId);
}
