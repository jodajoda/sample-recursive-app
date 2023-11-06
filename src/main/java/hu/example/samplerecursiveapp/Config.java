package hu.example.samplerecursiveapp;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "hu.example.samplerecursiveapp.search" })
//@EntityScan("hu.example.samplerecursiveapp.search.entity")
public class Config {
}
