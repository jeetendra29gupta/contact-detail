<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Number Management</title>
<link href="css/theme.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="headerDiv">Contact Number Management</div>
	<div id="formDiv">
		<h2 style="text-align: center;">Add Contact Detail</h2>
		<br>
		<s:form method="post" action="validationsForm" validate="true"
			namespace="/" name="contactForm">
			<s:push value="contactDetail">
				<s:hidden name="id" />
				<s:textfield name="firstname" label="First Name"
					placeholder="Your first name.." class="inputBox" />
				<s:textfield name="lastname" label="Last Name"
					placeholder="Your last name.." class="inputBox" />
				<s:textfield name="email" label="Email ID"
					placeholder="Your email id.." class="inputBox" />
				<s:textfield name="phone" label="Phone No"
					placeholder="Your phone no.." class="inputBox" />
				<s:submit value="Submit" class="buttonBox" />
			</s:push>
		</s:form>
	</div>
	<div id="footerDiv">
		<a href="openCV" style="text-decoration: none;"> 
			copyright &copy; Jeetendra Gupta.</a>
	</div>
</body>
</html>