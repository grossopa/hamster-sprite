requirejs.config({
  baseUrl : 'static/js'
});

define([ 'config' ], function() {
  require([ 'password/app'], function() {
    
  });
});