package io.soebes.simple.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.Objects;

@Component
@ConfigurationProperties("xyz")
public class ConfigurationLeiDaD {

  private static final Logger LOG = LoggerFactory.getLogger(ConfigurationLeiDaD.class);

  private static final String DEFAULT_INBOUND = "inbound";

  private Path baseDirectory;

  /**
   * The name of the <code>inbound</code> directory.
   */
  private Path inbound;

  /**
   * The name of the <code>export</code> directory.
   */
  private Path export;

  ConfigurationLeiDaD() {
    LOG.info("ConfigurationLeiDaD.ConfigurationLeiDaD");
    this.baseDirectory = null;
    this.inbound = null;
  }

  public Path getBaseDirectory() {
    return baseDirectory;
  }

  void setBaseDirectory(Path baseDirectory) {
    LOG.info("baseDirectory {}", baseDirectory);
    this.baseDirectory = baseDirectory;
  }

  public Path getInbound() {
    return Objects.requireNonNullElseGet(this.inbound, () -> this.baseDirectory.resolve(DEFAULT_INBOUND));
  }

}