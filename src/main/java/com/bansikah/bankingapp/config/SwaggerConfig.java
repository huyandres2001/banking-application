package com.bansikah.bankingapp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() throws SocketException {
        AtomicReference<String> address = new AtomicReference<>("");
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        networkInterfaces.asIterator().forEachRemaining(networkInterface -> {
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            inetAddresses.asIterator().forEachRemaining(inetAddress -> {
                String hostAddress = inetAddress.getHostAddress();
                address.set(address.get() + hostAddress + ", ");
            });
        });
        return new OpenAPI()
                .info(new Info().title("Bank Account API ip = " + address.get())
                        .version("1.0")
                        .description("API to test CRUD Bank Account | Tech with Bansikah"));
    }
}
