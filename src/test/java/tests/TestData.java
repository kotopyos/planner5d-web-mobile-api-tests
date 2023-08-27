package tests;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class TestData {

    @AllArgsConstructor
    public enum Language {
        ENGLISH("English"),
        RUSSIAN("Русский"),
        POLISH("Polski");

        @Getter
        private String value;
    }
}
