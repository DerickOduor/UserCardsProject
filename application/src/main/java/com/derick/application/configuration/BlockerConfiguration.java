package com.derick.application.configuration;

import com.derick.service.ICountryService;
import com.derick.service.implemetation.CountryService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlockerConfiguration {

    //public BlockerConfiguration blockerConfiguration=new BlockerConfiguration();

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

   @Bean
    public ICountryService iCountryService(){
        return new CountryService();
    }

}
