package hu.example.samplerecursiveapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "hu.example.samplerecursiveapp.search" })
public class Config {
}
