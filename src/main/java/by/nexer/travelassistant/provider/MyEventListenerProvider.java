package by.nexer.travelassistant.provider;

import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventType;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.models.KeycloakSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyEventListenerProvider implements EventListenerProvider {

    Logger logger = LoggerFactory.getLogger(MyEventListenerProvider.class);

    KeycloakSession keycloakSession;
    public MyEventListenerProvider(KeycloakSession keycloakSession) {
        this.keycloakSession = keycloakSession;
    }

    @Override
    public void onEvent(Event event) {
        logger.info(event.getDetails().toString());
        if(event.getType() ==  EventType.REGISTER){

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
