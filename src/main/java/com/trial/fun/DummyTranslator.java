package com.trial.fun;

import static java.lang.String.format;

public class DummyTranslator implements TranslatorService {

    @Override
    public String translate(String text) {
        return format("What do you mean by %s? Yea..I'm dummy!", text);
    }
}
