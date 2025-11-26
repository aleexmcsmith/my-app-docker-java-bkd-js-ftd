package com.kaycodes.demo_service_2_service_call;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient restClient(){
        return RestClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    @Bean
    public NewTodoService todoService() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();

        // Use WebClientAdapter
        WebClientAdapter adapter = WebClientAdapter.create(webClient);

        // Use the adapter with HttpServiceProxyFactory
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(NewTodoService.class);
    }
}
