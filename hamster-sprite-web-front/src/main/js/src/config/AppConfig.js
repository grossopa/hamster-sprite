class AppConfig {
  user : null
  env : null
  baseUrl : null

  /* Optional variables */
  dateFormat : null
  dateTimeFormat : null

  initialize(config) {
    this.user = config.user
    this.env = config.env
    this.baseUrl = config.baseUrl

    this.dateFormat = config.dateFormat ? config.dateFormat : 'll'
    this.dateTimeFormat = config.dateTimeFormat ? config.dateTimeFormat : 'lll'
  }

  url(key) {
    return this.baseUrl + key
  }
}

export default new AppConfig()
