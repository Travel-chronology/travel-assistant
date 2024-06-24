package by.nexer.travelassistant.provider;

import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventType;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.models.KeycloakSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MyEventListenerProvider implements EventListenerProvider {

    Logger logger = LoggerFactory.getLogger(MyEventListenerProvider.class);

    KeycloakSession keycloakSession;
    public MyEventListenerProvider(KeycloakSession keycloakSession) {
        this.keycloakSession = keycloakSession;
    }

    @Override
    public void onEvent(Event event) {
        logger.info(event.getDetails().toString());
        if (event.getType() == EventType.REGISTER) {
            String userId = event.getUserId();
            String email = event.getDetails().get("email");
            String username = event.getDetails().get("username");

            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres")) {
                String sql = "INSERT INTO public.users (keycloak_id, username, email) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, userId);
                    stmt.setString(2, username);
                    stmt.setString(3, email);
                    stmt.executeUpdate();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onEvent(AdminEvent adminEvent, boolean b) {
        if(adminEvent.getOperationType().name().equals("UPDATE")){
            logger.info(adminEvent.getRepresentation());
        }
    }

    @Override
    public void close() {

    }
}
