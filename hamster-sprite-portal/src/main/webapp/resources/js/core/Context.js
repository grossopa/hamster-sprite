define([ 'exports' ], function(exports) {
  var cxt = window.CXT;

  function _buildUrl(url, params) {
    var symb = url.indexOf('?') > 0 ? '&' : '?';
    var paramString = $.param(params);
    return url + (paramString ? symb + paramString : '');
  };

  function getWsUrl(key, options) {
    var suffix = _.result(options, 'suffix', 'json');
    var params = _.result(options, 'params', {});

    var url = cxt.web_api[key];
    return _buildUrl(cxt.contextPath + url + '.' + suffix, params);
  };

  function getPageUrl(key, options) {
    var params = _.result(options, 'params', {});

    var paramString = $.param(params);

    var url = cxt.web_api[key];
    return _buildUrl(cxt.contextPath + url, params);
  }

  exports.getWsUrl = getWsUrl;
  exports.getPageUrl = getPageUrl;
});