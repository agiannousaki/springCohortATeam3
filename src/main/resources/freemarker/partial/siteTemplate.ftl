<#macro navbar currentPage>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="/mvc">SMDB</a>

		<div class="collapse navbar-collapse" id="navbarWithLogOut">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item">
					<a class="nav-link ${(currentPage=='home')?then('active','')}" href="/mvc">Home <span
								class="sr-only">
							(current)
						</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link ${(currentPage=='people')?then('active','')}" href="/mvc/people">
						All People</a>
				</li>
				<li class="nav-item">
					<a class="nav-link ${(currentPage=='findPerson')?then('active','')}" href="/mvc/findPerson">
						Search Person</a>
				</li>
				<li class="nav-item">
					<a class="nav-link ${(currentPage=='about')?then('active','')}" href="/mvc/about">About Us</a>
				</li>
			</ul>
		</div>
	</nav>
	<!-- Navbar -->
</#macro>

<#macro footer>
	<!-- Footer -->
	<footer class="bg-dark text-center text-white">
		<!-- Copyright -->
		<div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
			© 2022 Copyright:
			<a class="text-white" href="/mvc">SMDB</a>
		</div>
		<!-- Copyright -->
	</footer>
	<!-- Footer -->
</#macro>
