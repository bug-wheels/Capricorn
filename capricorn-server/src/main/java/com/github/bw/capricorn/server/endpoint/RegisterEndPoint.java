package com.github.bw.capricorn.server.endpoint;


import com.github.bw.capricorn.commons.DefaultServiceInstance;
import com.github.bw.capricorn.commons.Registration;
import com.github.bw.capricorn.commons.ServiceInstance;
import com.github.bw.capricorn.commons.response.CommonResponse;
import com.github.bw.capricorn.commons.response.InstanceHealthStatus;
import com.github.bw.capricorn.commons.response.InstanceRegisterResponse;
import com.github.bw.capricorn.commons.response.QueryInstanceResponse;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dc/ns/instance")
public class RegisterEndPoint {

  private final DiscoveryRegistry<Registration> discoveryRegistry;

  public RegisterEndPoint(DiscoveryRegistry<Registration> discoveryRegistry) {
    this.discoveryRegistry = discoveryRegistry;
  }

  /**
   * 注册一个服务实例
   * <p>
   * 注册示例相对简单，就是往数据库插一条数据
   */
  @PostMapping
  public InstanceRegisterResponse register(@RequestBody Registration registration) {
    discoveryRegistry.register(registration);
    return new InstanceRegisterResponse(registration.getServiceInstance().getInstanceId());
  }

  /**
   * 剔除一个服务实例
   */
  @DeleteMapping("{dc}/{ns}/{instanceId}")
  public CommonResponse deregister(@PathVariable String dc, @PathVariable String ns,
      @PathVariable String instanceId) {
    Registration registration = new Registration(dc, ns, new DefaultServiceInstance(instanceId));
    discoveryRegistry.deregister(registration);
    return new CommonResponse();
  }

  /**
   * 发送实例心跳包
   */
  @PutMapping("{dc}/{ns}/{instanceId}")
  public CommonResponse heartbeat(@PathVariable String dc, @PathVariable String ns,
      @PathVariable String instanceId) {
    Registration registration = new Registration(dc, ns, new DefaultServiceInstance(instanceId));
    discoveryRegistry.setStatus(registration, "up");
    return new CommonResponse();
  }

  /**
   * 查询实例信息
   */
  @GetMapping
  public QueryInstanceResponse instances(@RequestParam String dc, @RequestParam String ns,
      @RequestParam String serviceId, @RequestParam(required = false) Byte healthStatus) {

    InstanceHealthStatus instanceHealthStatus = null;
    if (healthStatus != null) {
      instanceHealthStatus = InstanceHealthStatus.getByStatus(healthStatus);
    }

    List<ServiceInstance> instances = discoveryRegistry.instances(dc, ns, serviceId, instanceHealthStatus);

    return new QueryInstanceResponse(instances);
  }

}
