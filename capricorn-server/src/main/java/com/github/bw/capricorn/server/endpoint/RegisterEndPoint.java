package com.github.bw.capricorn.server.endpoint;


import com.github.bw.capricorn.commons.DefaultServiceInstance;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dc/ns/instance")
public class RegisterEndPoint {

  /**
   * 注册一个服务实例
   */
  @PostMapping
  public DefaultServiceInstance register(@RequestBody DefaultServiceInstance instanceInfo) {
    instanceInfo.setInstanceId(UUID.randomUUID().toString());
    return instanceInfo;
  }

  /**
   * 剔除一个服务实例
   */
  @DeleteMapping("{instanceId}")
  public DefaultServiceInstance deregister(@PathVariable String instanceId) {
    DefaultServiceInstance instanceInfo = new DefaultServiceInstance();
    instanceInfo.setInstanceId(instanceId);
    return instanceInfo;
  }

  /**
   * 发送实例心跳包
   */
  @PutMapping("{instanceId}")
  public DefaultServiceInstance heartbeat(@PathVariable String instanceId) {
    DefaultServiceInstance instanceInfo = new DefaultServiceInstance();
    instanceInfo.setInstanceId(instanceId);
    return instanceInfo;
  }

  /**
   * 查询实例信息
   */
  @GetMapping
  public List<DefaultServiceInstance> instances() {
    DefaultServiceInstance instanceInfo = new DefaultServiceInstance();
    instanceInfo.setInstanceId(UUID.randomUUID().toString());
    return Arrays.asList(instanceInfo);
  }

}
