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

  private static final String DEFAULT_IMPORTER = "importer";

  private static final String DEFAULT_ARCHIVE = "archive";

  private static final String DEFAULT_EXPORT = "export";

  /**
   * Defines the base directory under which the structure
   * <ul>
   * <li>inbound</li>
   * <li>import</li>
   * <li>archive</li>
   * <li>export</li>
   * </ul>
   * is located.
   */
  private Path baseDirectory;

  /**
   * The name of the <code>inbound</code> directory.
   */
  private Path inbound;

  /**
   * The name of the <code>importer</code> directory.
   */
  private Path importer;

  /**
   * The name of the <code>archive</code> directory.
   */
  private Path archive;

  /**
   * The name of the <code>export</code> directory.
   */
  private Path export;

  ConfigurationLeiDaD() {
    LOG.info("ConfigurationLeiDaD.ConfigurationLeiDaD");
    this.baseDirectory = null;
    this.inbound = null;
    this.importer = null;
    this.archive = null;
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

  void setInbound(Path inbound) {
    this.inbound = inbound;
  }

  public Path getImporter() {
    return Objects.requireNonNullElseGet(this.importer, () -> this.baseDirectory.resolve(DEFAULT_IMPORTER));
  }

  void setImporter(Path importer) {
    this.importer = importer;
  }

  public Path getArchive() {
    return Objects.requireNonNullElseGet(this.archive, () -> this.baseDirectory.resolve(DEFAULT_ARCHIVE));
  }

  void setArchive(Path archive) {
    this.archive = archive;
  }

  public Path getExport() {
    return Objects.requireNonNullElseGet(this.export, () -> this.baseDirectory.resolve(DEFAULT_EXPORT));
  }

  void setExport(Path export) {
    this.export = export;
  }

}