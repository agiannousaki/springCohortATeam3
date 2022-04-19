<!DOCTYPE html>
<html lang="en">
<#import 'partial/siteTemplate.ftl' as siteTemplate>
<head>
	<meta charset="UTF-8">
	<title>Actors/Producers/Directors</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<@siteTemplate.navbar currentPage="people"/>
<div class="container">
	<div class="row">
		<div class="col">
			<table class="table table-hover">
				<thead>
				<tr>
					<th>#</th>
					<th>Lastname</th>
					<th>Firstname</th>
					<th>Height</th>
					<th>Date of birth</th>
					<th>Place of Birth</th>
					<th>Biography</th>
					<th>Company</th>
				</tr>
				</thead>
				<tbody>
                <#list allPeople as people>
					<tr>
						<td>${people?counter}</td>
						<td>${people.lastName}</td>
						<td>${people.firstName}</td>
						<td>${people.height!""}</td>
						<td>${people.dateOfBirth?date!""}</td>
						<td>${people.placeOfBirth!""}</td>
						<td>${people.biography!""}</td>
						<td>${people.company!""}</td>
					</tr>
                </#list>
				</tbody>
			</table>
		</div>
	</div>
</div>
<@siteTemplate.footer/>
</body>
</html>
