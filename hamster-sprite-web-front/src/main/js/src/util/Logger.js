export const TRACE = 'trace';
export const DEBUG = 'debug';
export const INFO = 'info';
export const WARN = 'warn';
export const ERROR = 'error';
export const ALL = 'all';

const CONFIG = {
  ALL   : {order : 0, level : ALL},
  TRACE : {order : 1, level : TRACE},
  DEBUG : {order : 2, level : DEBUG},
  INFO  : {order : 3, level : INFO},
  WARN  : {order : 4, level : WARN},
  ERROR : {order : 5, level : ERROR}
};

class Logger {
  static getLogger(target) {
    //TODO: support configuration-based loggerWritter
    return new Logger(target);
  }

  target : null;
  config : null;
  writer : null;

  constructor(target, loggerWriter) {
    this.writer = loggerWriter ? loggerWriter : new ConsoleLoggerWriter(console);
  };

  init(level) {
    if (!CONFIG[level]) {
      throw new Error(`Illegal Logger level : ${level}.`);
    }
    config = CONFIG[level];
  };

  trace(message, err) {
    doLogger(message, err, CONFIG.TRACE);
  };

  debug(message, err) {
    doLogger(message, err, CONFIG.DEBUG);
  };

  info(message, err) {
    doLogger(message, err, CONFIG.INFO);
  };

  warn(message, err) {
    doLogger(message, err, CONFIG.WARN);
  };

  error(message, err) {
    doLogger(message, err, CONFIG.ERROR);
  };

  doLogger(message, err, level) {
    if (level.order >= config.order) {
      writer.logger({
        message : message,
        err : err,
        target : target,
        level : level.level
      });
    }
  }

}

class ConsoleLoggerWriter {

  cons : null;
  constructor(cons) {
    this.cons = cons;
  };

  logger(details) {
    var text = `[${details.level}] ${details.target} - ${message}`;
    switch (level.level) {
      case CONFIG.TRACE:
      case CONFIG.DEBUG:
      case CONFIG.INFO:
        cons.info(text);
        if (details.err) {
          cons.info(err);
        }
        break;
      case CONFIG.WARN:
        cons.warn(text);
        if (details.err) {
          cons.warn(err);
        }
        break;
      case CONFIG.ERROR:
        cons.error(text);
        if (details.err) {
          cons.error(err);
        }
        break;
    }
  };
}

export default Logger;
