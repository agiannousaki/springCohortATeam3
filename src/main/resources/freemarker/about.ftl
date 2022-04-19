<!DOCTYPE html>
<html lang="en">
<#import 'partial/siteTemplate.ftl' as siteTemplate>
<#import "/spring.ftl" as spring />
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<@siteTemplate.navbar currentPage="about"/>
<div class="container">
	<div class="row">
		<div class="col">
			<h1><@spring.message "about.header"/></h1>
			<h4><@spring.message "about.names"/></h4>
			<p><@spring.message "about.description"/></p>
		</div>
	</div>
	<hr>
</div>
<@siteTemplate.footer/>

</body>
</html>
