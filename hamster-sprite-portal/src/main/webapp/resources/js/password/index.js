requirejs.config({
  baseUrl : 'resources/js'
});

define([ 'config' ], function() {
  require([ 'password/app' ], function() {
    $(document).ready(function() {
      angular.bootstrap(document, ['app.password']);
    });
  });
});