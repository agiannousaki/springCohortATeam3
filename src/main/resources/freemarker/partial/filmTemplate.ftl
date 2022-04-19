<#macro film films>
		<table class="table table-hover">
			<thead>
			<tr class="table-light">
				<th>Title</th>
				<th>Date Of Release</th>
				<th>Genre</th>
				<th>Rating</th>
			</tr>
			</thead>
			<tbody>
            <#list films as film>
				<tr class="table">
					<td>${film.title}</td>
					<td>${film.dateOfRelease}</td>
					<td>${film.genre?join(", ")}</td>
					<td>${film.rating}</td>
				</tr>
            </#list>
			</tbody>
		</table>
</#macro>
