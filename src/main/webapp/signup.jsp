<%@include file="header.jsp"%>
<%@include file="navbar.jsp"%>
<div class="container">
	<br />
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<div class="card">
				<div class="card-header">Employee Registration</div>
				<div class="card-body">
					<form action="SignupController" method="post">
						<table class="table table-borderless">
							<tr>
								<td>${ERROR}</td>
							</tr>
							<tr>
								<td><input type="text" name="username"
									placeholder="Enter Username" class="form-control" /></td>
							</tr>
							<tr>
								<td><input type="password" name="password"
									placeholder="Enter password" class="form-control" /></td>
							</tr>
							<tr>
								<td><input type="text" name="firstname"
									placeholder="Enter Firstname" class="form-control" /></td>
							</tr>
							<tr>
								<td><input type="text" name="lastname"
									placeholder="Enter Lastname" class="form-control" /></td>
							</tr>
							<tr>
								<td><input type="email" name="email"
									placeholder="Enter Email" class="form-control" /></td>
							</tr>
							<tr>
								<td><input type="text" name="mobileno"
									placeholder="Enter Mobile Number" class="form-control" /></td>
							</tr>
							<tr>
								<td><select required="required" name="gender"
									class="form-control">
										<option value="-1" selected="selected">Select Gender</option>
										<option value="male">Male</option>
										<option value="female">Female</option>
								</select></td>
							</tr>
							<tr>
								<td><input type="text" name="designation"
									class="form-control" placeholder="Enter Designation" />
							</tr>
							<tr>
								<td><input type="submit" value="Create Account"
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

