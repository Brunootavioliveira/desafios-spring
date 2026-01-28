package br.com.brunootavio.desafios_spring.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConverterDados implements IConverteDados{
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(File file, Class<T> classe) {
        try {
            return mapper.readValue(file, classe);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
