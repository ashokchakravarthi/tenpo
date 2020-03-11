<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create an account</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
  <div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
  </div>

  <div class="form-group ${error != null ? 'has-error' : ''}">
  <h2 class="form-heading">Operation</h2>
     <input id="value1" type="text" class="form-control" placeholder="Value 1" autofocus="true"/>
     <input id="value2" type="text" class="form-control" placeholder="Value 2" />
     <input id="answer" type="text" class="form-control" readonly/>

     <button class="btn btn-lg btn-primary btn-block" onclick="addNumbers()">Add</button>
 </div>
 <div class="form-group ${error != null ? 'has-error' : ''}">
    <h2 class="form-heading">History</h2>
   <p id="history"> </p>
  </div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  <script language="javascript">
     function addNumbers()
     {
        var value1 = parseInt(document.getElementById("value1").value);
        var value2 = parseInt(document.getElementById("value2").value);
        var answer = document.getElementById("answer");
        answer.value = value1 + value2;

        var xhttp = new XMLHttpRequest();
          xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200)
            {
              var responseText = document.getElementById("history").innerHTML;
              responseText = responseText + "<br>" + value1 + " + " + value2 + " = " + answer.value;
              document.getElementById("history").innerHTML = responseText;
            }
          };
          xhttp.open("POST", "api/persist", true);
          xhttp.setRequestHeader('Content-Type', 'application/json')
          xhttp.send('{"value1":"'+ value1 + '","value2":"' + value2+ '"}"');
     }
    </script>
</body>
</html>
