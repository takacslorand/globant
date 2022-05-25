package com.globant.got.client.feign.client;

import com.globant.got.client.config.FeignConfig;
import com.globant.got.client.model.GoTCharacter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@FeignClient(name = "characters-client", url = "${globant.client.host.url}", configuration = FeignConfig.class)
public interface GoTCharacterClient {

    @RequestMapping(value = "/characters", method = RequestMethod.GET)
    List<GoTCharacter> all(@SpringQueryMap Map<String, String> queryParams);

    @RequestMapping(value = "/characters/{id}", method = RequestMethod.GET)
    GoTCharacter one(@PathVariable(name = "id")int id);
}