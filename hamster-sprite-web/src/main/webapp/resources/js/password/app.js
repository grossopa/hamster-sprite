define(['core/index', 'password/controllers/index'], function() {
  // configuration goes here
  return angular.module('app.password', [
    'app.password.controllers'
  ]);
});