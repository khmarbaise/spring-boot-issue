package io.soebes.simple.service;

import io.soebes.simple.config.ConfigurationLeiDaD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class FirstService {

  private static final Logger LOG = LoggerFactory.getLogger(FirstService.class);

  private final ConfigurationLeiDaD configurationLeiDaD;

  public FirstService(ConfigurationLeiDaD configurationLeiDaD) {
    this.configurationLeiDaD = configurationLeiDaD;
  }

  @EventListener(classes = ApplicationReadyEvent.class)
  void applicationReady(@NonNull ApplicationReadyEvent event) {
    LOG.info("Event {}", event);
    Path inbound = configurationLeiDaD.getInbound();
    LOG.info("inbound: {}", inbound);
  }

}
