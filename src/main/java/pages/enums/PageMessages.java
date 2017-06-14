package pages.enums;

public enum PageMessages {
    noSearchResults("Brak danych");

    public String get() {
        return caption;
    }

    private String caption;

    private PageMessages(String caption) {
        this.caption = caption;
    }
}
