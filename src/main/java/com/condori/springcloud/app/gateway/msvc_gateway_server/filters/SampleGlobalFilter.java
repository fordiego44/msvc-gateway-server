package com.condori.springcloud.app.gateway.msvc_gateway_server.filters;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class SampleGlobalFilter implements Filter, Ordered {

    private final Logger logger = LoggerFactory.getLogger(SampleGlobalFilter.class);

    @Override
    public int getOrder() {
        return 100;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("Llamada filtro SampleGlobalFilter::doFilter");
        chain.doFilter(request, response);
    }
}

// import java.util.Optional;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.cloud.gateway.filter.GatewayFilterChain;
// import org.springframework.cloud.gateway.filter.GlobalFilter;
// import org.springframework.core.Ordered;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseCookie;
// import org.springframework.http.server.reactive.ServerHttpRequest;
// import org.springframework.stereotype.Component;
// import org.springframework.web.server.ServerWebExchange;

// import reactor.core.publisher.Mono;

// @Component
// public class SampleGlobalFilter implements GlobalFilter, Ordered {

//     private final Logger logger = LoggerFactory.getLogger(SampleGlobalFilter.class);
    
//     @Override
//     public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

//         logger.info("ejecutando el filtro antes del request PRE");

//         ServerHttpRequest mutateRequest =  exchange.getRequest().mutate().headers(h -> h.add("token", "abcdefg")).build();

//         ServerWebExchange mutatedExchange = exchange.mutate().request(mutateRequest).build();

//         return chain.filter(mutatedExchange).then(Mono.fromRunnable(() -> {
//             logger.info("ejecutando filtro POST response");
//             String token = mutatedExchange.getRequest().getHeaders().getFirst("token");
//                  logger.info("token: " + token);
//             if (token != null) {
//                 logger.info("token: " + token);
//                 mutatedExchange.getResponse().getHeaders().add("token", token);
//             }

//             Optional.ofNullable(mutatedExchange.getRequest().getHeaders().getFirst("token"))
//             .ifPresent(value -> {
//                 logger.info("token2: " + value);
//                 exchange.getResponse().getHeaders().add("token2", value);
//             });;

//             exchange.getResponse().getCookies().add("color", ResponseCookie.from("color", "red").build());
//             // exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
//         }));
//     }
    
//     @Override
//     public int getOrder() {
//         return 100;
//     }

// }
