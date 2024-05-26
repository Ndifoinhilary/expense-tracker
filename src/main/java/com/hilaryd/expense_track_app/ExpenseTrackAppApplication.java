package com.hilaryd.expense_track_app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
        info = @Info(
                title = "Expense Tracker API",
                description = "Expense Tracker API",
                version = "v1.0",
                contact = @Contact(
                        name = "NDifoin Hilary",
                        url = "https:hilary.com",
                        email = "ndifoinhilary@gmail.com"
                )
        )
)
@SpringBootApplication
public class ExpenseTrackAppApplication {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(ExpenseTrackAppApplication.class, args);
    }

}
