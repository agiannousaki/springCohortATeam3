<!DOCTYPE html>
<html lang="en">
<#import 'partial/siteTemplate.ftl' as siteTemplate>
<#import "/spring.ftl" as spring />
<#import "partial/filmTemplate.ftl" as filmTemplate>
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<@siteTemplate.navbar currentPage="findPerson"/>
<div class="container">
	<div class="row">
		<div class="col">
			<form action="/mvc/findPerson" method="get">
				<label for="lastName">Lastname</label>
				<input type="text" name="lastName" id="lastName" placeholder="Enter lastname Here">
                <#-- If value is not null-->
                <#if error??>
					<div>
						<small class="text-danger">
							<@spring.message "search.noperson"/>
						</small>
					</div>
                </#if>
				<button type="submit" class="btn btn-primary">Search</button>
			</form>
		</div>
	</div>
	<hr>
	<#if person??>
        <#include "partial/person.ftl">
	</#if>
</div>

<@siteTemplate.footer/>
</body>
</html>
