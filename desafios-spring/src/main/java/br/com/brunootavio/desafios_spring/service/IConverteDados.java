package br.com.brunootavio.desafios_spring.service;

import java.io.File;

public interface IConverteDados {
    <T> T obterDados(File file, Class<T> classe);
}
