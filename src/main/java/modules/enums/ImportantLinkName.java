package modules.enums;

public enum ImportantLinkName {
    adminContact("KONTAKT Z ADMINISTRATORAMI"),
    jira("JIRA"),
    confluence("CONFLUENCE"),
    crucible("CRUCIBLE"),
    roomReservation("REZERWACJE SALEK");

    public String get() {
        return caption;
    }

    private String caption;

    private ImportantLinkName(String caption) {
        this.caption = caption;
    }
}
