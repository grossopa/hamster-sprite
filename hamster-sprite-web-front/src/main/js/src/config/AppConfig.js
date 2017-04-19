class AppConfig {
  user : null;
  env : null;
  baseUrl : null;

  initialize(config) {
    this.user = config.user;
    this.env = config.env;
    this.baseUrl = config.baseUrl;
  };

  url(key) {
    return this.baseUrl + key;
  }
}

export default new AppConfig();
