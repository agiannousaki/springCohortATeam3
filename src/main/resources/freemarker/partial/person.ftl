<div class="row">
	<div class="col">
		<h4>Person</h4>
		<form>
			<fieldset disabled>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label >First Name</label>
						<input class="form-control" value="${person.firstName}">
					</div>
					<div class="form-group col-md-6">
						<label>Last Name</label>
						<input class="form-control" value="${person.lastName}">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label >Height</label>
						<input class="form-control" value="${person.height!""}">
					</div>
					<div class="form-group col-md-6">
						<label >Biography</label>
						<input class="form-control" value="${person.biography!""}">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label >Date of Birth</label>
						<input class="form-control" value="${person.dateOfBirth?date!""}">
					</div>
					<div class="form-group col-md-6">
						<label >Place of Birth</label>
						<input class="form-control" value="${person.placeOfBirth!""}">
					</div>
				</div>
			</fieldset>
		</form>
		<h4>Actor</h4>
		<@filmTemplate.film films=actor/>
		<br>
		<h4>Director</h4>
		<@filmTemplate.film films=director/>
		<br>
		<h4>Producer</h4>
		<@filmTemplate.film films=producer/>
	</div>
</div>
