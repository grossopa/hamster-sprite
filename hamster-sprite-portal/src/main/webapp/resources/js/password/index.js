requirejs.config({
  baseUrl : 'resources/js'
});

define([ 'config' ], function() {
  require([ 'password/app'], function() {
  });
});