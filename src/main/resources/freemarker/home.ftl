<!DOCTYPE html>
<html lang="en">
<#import "partial/siteTemplate.ftl" as siteTemplate>
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<@siteTemplate.navbar currentPage="home"/>
<div class="container">
	<div class="row">
		<div class="col">

			<#if latestFilm??>
				<p>Our latest entry is <b>${latestFilm}</b></p>
			<#else>
				SMDB is empty at the moment
			</#if>


		</div>
	</div>
</div>
<@siteTemplate.footer/>
</body>
</html>
