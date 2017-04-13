class AppConfig {
  user : null;
  env : null;

  initialize(config) {
    this.user = config.user;
    this.env = config.env;
  };
}

export default new AppConfig();
