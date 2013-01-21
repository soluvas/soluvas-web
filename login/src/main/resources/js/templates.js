define(['handlebars'], function(Handlebars) {
  var template = Handlebars.template, templates = Handlebars.templates = Handlebars.templates || {};
templates['org.soluvas.web.login.LoginForm.mustache'] = template(function (Handlebars,depth0,helpers,partials,data) {
  helpers = helpers || Handlebars.helpers; data = data || {};
  var buffer = "", stack1, foundHelper, functionType="function", escapeExpression=this.escapeExpression;


  buffer += "<!-- To generate:\nceefour@annafi:~/git/bippo-commerce5/app/src/main/resources$ handlebars templates_web/*.mustache --amd --output js/templates.js\n-->\n	<div class=\"control-group\">\n		<label class=\"control-label\" for=\"username\">Username</label>\n		<div class=\"controls\"><input type=\"text\" id=\"username\" value=\"";
  foundHelper = helpers.username;
  if (foundHelper) { stack1 = foundHelper.call(depth0, {hash:{},data:data}); }
  else { stack1 = depth0.username; stack1 = typeof stack1 === functionType ? stack1.apply(depth0) : stack1; }
  buffer += escapeExpression(stack1) + "\" placeholder=\"Username\"/></div>\n	</div>\n	<div class=\"control-group\">\n		<label class=\"control-label\" for=\"password\">Password</label>\n		<div class=\"controls\"><input type=\"password\" id=\"password\" value=\"";
  foundHelper = helpers.password;
  if (foundHelper) { stack1 = foundHelper.call(depth0, {hash:{},data:data}); }
  else { stack1 = depth0.password; stack1 = typeof stack1 === functionType ? stack1.apply(depth0) : stack1; }
  buffer += escapeExpression(stack1) + "\" placeholder=\"Password\"/></div>\n	</div>\n	<div class=\"control-group\">\n		<div class=\"controls\">\n			<input type=\"checkbox\" id=\"rememberMe\"/><label for=\"rememberMe\"> Remember me</label>\n		</div>\n		<div class=\"controls\">\n			<input type=\"submit\" value=\"Login\" class=\"btn btn-primary\" />\n		</div>\n	</div>\n	\n	\n	<button class=\"btn\">Login with Facebook</button>\n	<button class=\"btn\">Login with Twitter</button>\n	<button class=\"btn\">Login with Google</button>\n	\n	<a href=\"#\">Forgot password</a>\n	<a href=\"#\">Register</a>\n";
  return buffer;});
});