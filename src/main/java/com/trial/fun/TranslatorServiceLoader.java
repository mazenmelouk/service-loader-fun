package com.trial.fun;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;

public class TranslatorServiceLoader {
    private static TranslatorServiceLoader provider;
    private final Map<String, TranslatorService> services;

    private TranslatorServiceLoader() {
        services = new HashMap<>();
        ServiceLoader.load(TranslatorService.class)
                .iterator().forEachRemaining(translatorService ->
                services.put(translatorService.getClass().getSimpleName(), translatorService));
    }

    static TranslatorServiceLoader getInstance() {
        if (isNull(provider)) {
            provider = new TranslatorServiceLoader();
        }
        return provider;
    }

    void listImplementations() {
        services.keySet().forEach(System.out::println);
    }

    TranslatorService loadServiceByName(String serviceName) {
        return ofNullable(services.get(serviceName))
                .orElseThrow(() -> new IllegalArgumentException("Implementation doesn't exist!"));
    }
}
