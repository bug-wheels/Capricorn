package com.github.bw.capricorn.server.endpoint;


import com.github.bw.capricorn.commons.DefaultServiceInstance;
import com.github.bw.capricorn.commons.Registration;
import com.github.bw.capricorn.commons.ServiceRegistry;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
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

  private final ServiceRegistry<Registration> serviceRegistry;

  public RegisterEndPoint(ServiceRegistry<Registration> serviceRegistry) {
    this.serviceRegistry = serviceRegistry;
  }

  /**
   * 注册一个服务实例
   * <p>
   * 注册示例相对简单，就是往数据库插一条数据
   */
  @PostMapping
  public ResponseEntity<RegisterResult> register(@RequestBody Registration registration) {
    serviceRegistry.register(registration);
    return ResponseEntity.ok(new RegisterResult(registration.getServiceInstance().getInstanceId()));
  }

  /**
   * 剔除一个服务实例
   */
  @DeleteMapping("{dc}/{ns}/{instanceId}")
  public ResponseEntity<Void> deregister(@PathVariable String dc, @PathVariable String ns,
      @PathVariable String instanceId) {
    Registration registration = new Registration(dc, ns, new DefaultServiceInstance(instanceId));
    serviceRegistry.deregister(registration);
    return ResponseEntity.ok().build();
  }

  /**
   * 发送实例心跳包
   */
  @PutMapping("{dc}/{ns}/{instanceId}")
  public ResponseEntity<Void> heartbeat(@PathVariable String dc, @PathVariable String ns,
      @PathVariable String instanceId) {
    Registration registration = new Registration(dc, ns, new DefaultServiceInstance(instanceId));
    serviceRegistry.setStatus(registration, "up");
    return ResponseEntity.ok().build();
  }

  /**
   * 查询实例信息
   */
  @GetMapping
  public List<DefaultServiceInstance> instances(@RequestParam String dc, @RequestParam String ns,
      @RequestParam String serviceId) {
    DefaultServiceInstance instanceInfo = new DefaultServiceInstance();
    instanceInfo.setInstanceId(UUID.randomUUID().toString());
    instanceInfo.setInstanceId(serviceId);
    instanceInfo.setHost("127.0.0.1");
    instanceInfo.setPort(24880);
    return Arrays.asList(instanceInfo);
  }

}
