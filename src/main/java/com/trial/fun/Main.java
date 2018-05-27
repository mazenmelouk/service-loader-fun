package com.trial.fun;

public class Main {

    public static void main(String[] args) {
        System.out.println("Available translators are:");
        TranslatorServiceLoader loader = TranslatorServiceLoader.getInstance();
        loader.listImplementations();
        String text = "Donaudampfschifffahrtselektrizitätenhauptbetriebswerkbauunterbeamtengesel";

        System.out.println("Dummy says: " + loader.loadServiceByName("DummyTranslator").translate(text));

        System.out.println("Napoleon says: " + loader.loadServiceByName("NapoleonTranslator").translate(text));
    }
}
