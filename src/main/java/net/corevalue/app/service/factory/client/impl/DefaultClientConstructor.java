package net.corevalue.app.service.factory.client.impl;

import net.corevalue.app.client.Client;
import net.corevalue.app.constant.ClientType;
import net.corevalue.app.device.Device;
import net.corevalue.app.service.factory.client.ClientConstructor;
import net.corevalue.app.service.factory.client.ClientCreator;
import net.corevalue.app.util.ConnectionArguments;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

public class DefaultClientConstructor implements ClientConstructor<Device> {

    private Map<ClientType, ClientCreator<Device>> creatorMap;

    @PostConstruct
    public void init(@Named("MqttClientCreator") ClientCreator<Device> mqttClientCreator) {
        creatorMap = new HashMap<>();
        creatorMap.put(ClientType.MQTT, mqttClientCreator);
    }

    @Override
    public Client<Device> constructClient(ClientType clientType, ConnectionArguments connectionArguments, Device device) throws Exception {
        ClientCreator<Device> clientCreator = creatorMap.get(clientType);
        return clientCreator.createClient(connectionArguments, device);
    }
}