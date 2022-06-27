package com.example.gantt;

import com.example.gantt.Domain.Gantt;
import com.example.gantt.service.GanttService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@SpringBootApplication
public class GanttApplication {

    public static void main(String[] args) {
        SpringApplication.run(GanttApplication.class, args);
    }

    @Bean
    CommandLineRunner runner (GanttService ganttService) {
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Gantt>> typeReference = new TypeReference<List<Gantt>>() {
            };
            InputStream inputStream = TypeReference.class.getResourceAsStream("/com/example/gantt/repository/jsonItems.json");
            try {
                List<Gantt> gantts = mapper.readValue(inputStream, typeReference);
                ganttService.create(gantts);
                System.out.println("they are created!");

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        };
    }



}
