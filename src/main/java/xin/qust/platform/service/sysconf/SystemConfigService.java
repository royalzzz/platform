package xin.qust.platform.service.sysconf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.qust.platform.domain.system.SystemConfig;
import xin.qust.platform.repository.sysconf.SystemConfigRepo;
import xin.qust.platform.utils.Parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class SystemConfigService {
    @Autowired
    private SystemConfigRepo systemConfigRepo;

//    获取最新的系统参数
    public Optional<SystemConfig> getSysConfig(){
        return systemConfigRepo.findTopByOrderByIdDesc();
    }
//    设置系统参数，先取最新的参数，然后将要更新的参数修改写入，保存在最后
    public void addSysConfig(Map<String,Object> paramsMap) throws Exception {
        Optional<SystemConfig> op = this.getSysConfig();
        if (op.isPresent()){
            SystemConfig oldSystemConfig = op.get();
            Map<String, Object> oldSystemConfigMap = (Map<String, Object>) Parser.objectToMap(oldSystemConfig);
            Map<String, Object> newSystemConfigMap = new HashMap<>();

            for(Map.Entry<String, Object> entry : oldSystemConfigMap.entrySet()){
                String mapKey = entry.getKey();
                Object mapValue = entry.getValue();
                if (paramsMap.containsKey(mapKey)){
                    newSystemConfigMap.put(mapKey, paramsMap.get(mapKey));
                }else {
                    newSystemConfigMap.put(mapKey, mapValue);
                }
            }
            SystemConfig newSystemConfig = (SystemConfig) Parser.mapToObject(newSystemConfigMap, SystemConfig.class);
            newSystemConfig.setId(newSystemConfig.getId()+1);
            systemConfigRepo.save(newSystemConfig);
        }
    }



}
