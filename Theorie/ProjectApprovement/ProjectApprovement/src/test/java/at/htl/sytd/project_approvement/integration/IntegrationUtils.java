package at.htl.sytd.project_approvement.integration;

public class IntegrationUtils {
    private static final String PROTOCOL = "http";
    private static final String ADDRESS = "127.0.0.1";
    private static final String PORT = "8181";
    private static final String PROJECT = "project";

    public static String buildURL(String controller, String path) {
        return String.format(
                "%s://%s:%s/%s/%s/%s",
                PROTOCOL,
                ADDRESS,
                PORT,
                PROJECT,
                controller,
                path);
    }
}
