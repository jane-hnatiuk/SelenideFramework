package pages.enums;

public enum PageTitle {
    titleLogin("Logowanie"),
    titleMain("MyPGS"),
    headerPage("MYPGS"),

    adminContact("Log in - Jira"),
    jira("System Dashboard - Jira"),
    confluence("Log In - Confluence"),
    crucible("Log in to Crucible 3.6.2"),
    roomReservation("Conference Room Bookmaking");

    public String get() {
        return caption;
    }

    private String caption;

    private PageTitle(String caption) {
        this.caption = caption;
    }
}
