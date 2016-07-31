define(['core/Context', 'Q'], function(Context, Q) {
  Q.fcall($.ajax(Context.getWsUrl('W_PASSWORD_APP_LIST'), {
    method : 'GET'
  }))
  .then(function(result) {
    alert(result);
  });
});