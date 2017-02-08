<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${!ajaxRequest}">
<html>
<head>
	<title>fileupload | mvc-showcase</title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> 
    <script src="http://malsup.github.com/jquery.form.js"></script>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
	<style>
<!--
/*form {display: block; background: #333; padding: 15px}*/
.progress {margin-left:auto; margin-right: auto; position:relative; width:400px; border: 1px solid #ddd; padding: 1px; border-radius: 3px;}
.bar {margin-left:auto; margin-right: auto;background-color: #B4F5B4; width:0%; height:20px; border-radius: 3px; }
.percent {position:absolute; display:inline-block; top:3px; left:48%;}
-->
</style> 
	
</head>
<body>
</c:if>    
	<div id="fileuploadContent">
	
	
		<h2>File Upload</h2>
		<p>
			See the <code>org.springframework.samples.mvc.fileupload</code> package for the @Controller code	
		</p>
		<!--
		    File Uploads must include CSRF in the URL.
		    See http://docs.spring.io/spring-security/site/docs/3.2.x/reference/htmlsingle/#csrf-multipart
		-->
		<c:url var="actionUrl" value="fileupload?${_csrf.parameterName}=${_csrf.token}"/>
		<form id="fileuploadForm" action="${actionUrl}" method="POST" enctype="multipart/form-data" class="cleanform">
			<div class="header">
		  		<h2>Form</h2>
		  		<c:if test="${not empty message}">
					<div id="message" class="success">${message}</div>	  		
		  		</c:if>
			</div>
			<label for="file">File</label>
			<input id="file" type="file" name="file" />
			<p><button type="submit">Upload</button></p>		
		</form>
		<div class="progress">
        <div class="bar"></div >
        <div class="percent">0%</div >
        <div id="status"></div >
    	</div>
    
		<script type="text/javascript">

			$(document).ready(function() {
				
				var bar = $('.bar');
				var percent = $('.percent');
				var status = $('#status');
				
				$('<input type="hidden" name="ajaxUpload" value="true" />').insertAfter($("#file"));
				$("#fileuploadForm").ajaxForm({
					success: function(html) {
						$("#fileuploadContent").replaceWith(html);
					},
					beforeSend: function() {
						status.empty();
						var percentVal = '0%'; 
				        bar.width(percentVal) 
				        percent.html(percentVal); 
					},
				    uploadProgress: function(event, position, total, percentComplete) {
				        var percentVal = percentComplete + '%';
				        bar.width(percentVal)
				        percent.html(percentVal);
				    },
				    complete : function(response) {
				    }
				});
			});
		</script>	
	</div>
<c:if test="${!ajaxRequest}">
</body>
</html>
</c:if>