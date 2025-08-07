<%@include file="header.jsp"%>
<%@include file="navbar.jsp"%>
<br />
<br />
<br />
<div class="container">
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="card">
				<div class="card-header">Customer Login</div>
				<div class="card-body">
					<form action="AuthenticateServlet" method="post">
						<table class="table table-borderless">
							<tr>
								<td><span class="msg_success">${SUCCESS}</span> <span
									class="msg_error">${ERROR}</span></td>
							</tr>

							<tr>
								<td><input type="text" name="username"
									placeholder="Username" required="required" class="form-control" /></td>
							</tr>
							<tr>
								<td><input type="password" name="password"
									placeholder="password" required="required" class="form-control" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Sign In"
									class="btn btn-primary fullwidth" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>


		</div>
		<div class="col-md-4"></div>
	</div>
</div>
<%@include file="footer.jsp"%>

