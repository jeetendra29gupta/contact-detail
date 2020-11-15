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

	<div id="tableDiv">
		<div style="text-align: center">
			<a href="openContactDetailForm" style="text-decoration: none;">
				<button class="add-button">Add Contact</button>
			</a> <input class="search-input" type="text" id="searchBox"
				placeholder="&#x1F50D Search Contact..." onkeyup="searchFunction()">
			<br> <br>
		</div>
		<table class="contactTable">
			<tr>
				<th class="contactTable-th">Name</th>
				<th class="contactTable-th">Email Id</th>
				<th class="contactTable-th">Phone No</th>
				<th class="contactTable-th">Action</th>
			</tr>
		</table>
		<div class="scrollingTable">
			<table class="contactTable">
				<s:iterator value="contactDetailList">
					<tr>
						<td class="contactTable-td searchItem"><s:property
								value="firstname" /> <s:property value="lastname" /></td>
						<td class="contactTable-td"><s:property value="email" /></td>
						<td class="contactTable-td"><s:property value="phone" /></td>
						<td class="contactTable-td"><a
							href='update?id=<s:property value="id"/>' id="updateButton">Update</a>
							<a href='delete?id=<s:property value="id"/>' id="deleteButton">Delete</a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>

	<div id="footerDiv">
		<a href="openCV" style="text-decoration: none;"> copyright &copy;
			Jeetendra Gupta.</a>
	</div>

	<script type="text/javascript">
        function searchFunction() {
            var searchBox = document.getElementById("searchBox");
            var searchItem = searchBox.value.toUpperCase();
            var allItem = document.getElementsByClassName("searchItem");
            for (let i = 0; i < allItem.length; i++) {
                var foundItem = allItem[i].innerText.toUpperCase();
                if (foundItem.indexOf(searchItem) > -1) {
                    allItem[i].parentNode.style.display = "";
                } else {
                    allItem[i].parentNode.style.display = "none";
                }
            }
        }
    </script>
</body>
</html>