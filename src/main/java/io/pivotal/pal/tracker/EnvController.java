package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    Map<String, String> envMap = new HashMap<>();
         @GetMapping("/env")
         public Map<String, String> getEnv (){

            return envMap;
            }

            public EnvController (@Value("${PORT:NOT SET}") String port,
                                  @Value("${MEMORY_LIMIT:NOT SET}") String mem_lim,
                                  @Value("${CF_INSTANCE_INDEX:NOT SET}") String inst_ind,
                                  @Value("${CF_INSTANCE_ADDR:NOT SET}") String ins_addr){
                envMap.put("PORT",port);
                envMap.put("MEMORY_LIMIT",mem_lim);
                envMap.put("CF_INSTANCE_INDEX",inst_ind);
                envMap.put("CF_INSTANCE_ADDR",ins_addr);
            }
}
