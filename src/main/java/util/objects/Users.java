package util.objects;

import util.configurations.TestConfiguration;
import util.enums.CredentialType;
import util.helpers.RandomStringGenerator;

public class Users {
    public static Users DEFAULT;

    private TestConfiguration testConfiguration;
    private RandomStringGenerator generator;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public Users(){}

    public Users(TestConfiguration testConfiguration, RandomStringGenerator generator)   {
        this.testConfiguration = testConfiguration;
        this.generator = generator;

        DEFAULT = new Users();
        DEFAULT.setUsername(testConfiguration.defaultUserName);
        DEFAULT.setPassword(testConfiguration.defaultUserPassword);
        DEFAULT.setEmail(testConfiguration.defaultUserEmail);
    }

    public Users getUser (CredentialType type) {
        Users users = new Users();
        switch (type) {
            case empty:
                return users;

            case invalid:
                String cred = generator.getRandomSentence();
                users.setUsername(cred);
                users.setPassword(cred);
                return users;

            default:
                return DEFAULT;
        }
    }
}
