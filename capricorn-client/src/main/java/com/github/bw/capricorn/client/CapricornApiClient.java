package com.github.bw.capricorn.client;

import com.github.bw.capricorn.commons.Registration;
import com.github.bw.capricorn.commons.response.CommonResponse;
import com.github.bw.capricorn.commons.response.InstanceRegisterResponse;
import com.github.bw.capricorn.commons.response.QueryInstanceResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CapricornApiClient {

  /**
   * 注册一个服务实例
   */
  @POST("/api/v1/dc/ns/instance")
  Call<InstanceRegisterResponse> register(@Body Registration registration);

  /**
   * 剔除一个服务实例
   */
  @DELETE("/api/v1/dc/ns/instance/{dc}/{ns}/{instanceId}")
  Call<CommonResponse> deregister(@Path("dc") String datacenter, @Path("ns") String namespace,
      @Path("instanceId") String instanceId);

  /**
   * 发送实例心跳包
   */
  @PUT("/api/v1/dc/ns/instance/{dc}/{ns}/{instanceId}")
  Call<CommonResponse> heartbeat(@Path("dc") String datacenter, @Path("ns") String namespace,
      @Path("instanceId") String instanceId);

  /**
   * 查询实例信息
   */
  @GET("/api/v1/dc/ns/instance")
  Call<QueryInstanceResponse> instances(@Query("dc") String datacenter, @Query("ns") String namespace,
      @Query("serviceId") String serviceId);
}
