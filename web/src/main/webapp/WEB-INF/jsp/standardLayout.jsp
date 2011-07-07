<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>The Free Car Pool</title>
<link href="<c:url value="/resources/styles/footer.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/styles/common.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/styles/menu.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/styles/header.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/styles/layout.css"/>"
	rel="stylesheet" type="text/css" />
<script src="<c:url value="/resources/SpryAssets/SpryMenuBar.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery-1.6.1.min.js"/>"
	type="text/javascript"></script>
<link
	href="<c:url value="/resources/SpryAssets/SpryMenuBarVertical.css"/>"
	rel="stylesheet" type="text/css" />
</head>

<body>
<div id="carpool_frame">
<div id="header"><a class="carpool_pic" href="#"></a></div>
<div id="page"><tiles:insertAttribute name="mainContent" />
<div id="sidepanel">
<div id="group">
<h3 align="center" class="notopmargin">REGISTER | SEARCH</h3>
<div class="menu">
<ul id="MenuBar1" class="MenuBarVertical">
	<li><a href="<c:url value="/"/>">Home</a></li>
	<li><a href="#" class="MenuBarItemSubmenu">Car Pool</a>
	<ul>
		<li><a href="carpoolsimplesearch.html">Search Car Pool</a></li>
		<li><a href="<c:url value="/flows/carpool-registration"/>">Register Car Pool</a></li>
	</ul>
	</li>
	<li><a href="<c:url value="registeruser"/>">Register Free</a></li>
	<li><security:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')" >
		<a href="<c:url value="/logout" />">Logout</a>
	</security:authorize>
		<a href="<c:url value="login"/>">Login</a>
	</li>
</ul>
</div>
<div class="clear"></div>
<a href="#" class="button_corpbutton"></a>
<div class="topspace greenbox"><img src="images/Publicat.jpg"
	width="125" height="176" /></div>
<h3 align="center" class="topspace">INFORMATION</h3>
<div class="menu">
<ul id="MenuBar2" class="MenuBarVertical">
	<li><a href="#">Savings Calculator</a></li>
	<li><a href="#">Benefits</a></li>
	<li><a href="#">Etiquette</a></li>
	<li><a href="#">About Us/Contact Us</a></li>
	<li><a href="#">FAQ's</a></li>
</ul>
</div>
<div class="clear"></div>
<a href="#" class="button_emailbutton"></a></div>
</div>
</div>
<div id="footer">
<p>&copy; Copyright 2011 Mauritian Car Pool | Contact Us</p>
</div>
</div>
<script type="text/javascript">
	var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {
		imgRight : "SpryAssets/SpryMenuBarRightHover.gif"
	});
	var MenuBar2 = new Spry.Widget.MenuBar("MenuBar2", {
		imgRight : "SpryAssets/SpryMenuBarRightHover.gif"
	});
</script>
<script src="<c:url value="/resources/js/pageheight.js"/>"
	type="text/javascript"></script>
</body>
</html>