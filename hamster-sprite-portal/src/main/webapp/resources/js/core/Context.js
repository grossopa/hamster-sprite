define(['exports'], function(exports) {
  var cxt = window.CXT;
  
  function getWsUrl(key, options) {
    var suffix = _.result(options, 'suffix', 'json');
    var params = _.result(options, 'params', {});
    
    var paramString = $.param(params);
    
    var url = cxt.web_api[key];
    return cxt.contextPath + url + '.' + suffix + (paramString ? '?' + paramString : '');
  };
  
  exports.getWsUrl = getWsUrl;
});