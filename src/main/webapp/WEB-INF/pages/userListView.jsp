<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="section">
	<h1>User Account List</h1>
	<div class="section" id="getting-started">
		<table border="1" class="index-table docutils">
			<colgroup>
				<col width="15%">
				<col width="20%">
				<col width="20%">
				<col width="20%">
				<col width="25%">
			</colgroup>
			<thead valign="bottom">
				<tr class="row-odd">
					<th class="head">User Name</th>
					<th class="head">Email</th>
					<th class="head">Phone</th>
					<th class="head">Address</th>
					<th class="head">Operation</th>
				</tr>
			</thead>
			<tbody valign="top">
				<tr class="row-even" ng-repeat="u in users">
					<td>
						<p>{{u.firstName}} {{u.lastName}}</p>
					</td>
					<td>
						<p>{{u.email}}</p>
					</td>
					<td>
						<p>
							{{u.phone}}
						</p>
					</td>
					<td>
						<p>{{u.address}}</p>
					</td>
					<td>
						<p>
						<div class="btn-group btn-group-xs" role="group"
							aria-label="Operation">
							<button type="button" class="btn btn-default" ng-click="deleteUser(u)">remove</button>
						</div>
						</p>
					</td>
				</tr>
			</tbody>
		</table>

	</div>
</div>