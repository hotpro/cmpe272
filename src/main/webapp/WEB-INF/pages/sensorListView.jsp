<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="section">
	<h1>Sensor List</h1>
	<div class="section" id="getting-started">
		<table border="1" class="index-table docutils">
			<colgroup>
				<col width="30%">
				<col width="20%">
				<col width="20%">
				<col width="30%">
			</colgroup>
			<thead valign="bottom">
				<tr class="row-odd">
					<th class="head">Sensor Id</th>
					<th class="head">Sensor Name</th>
					<th class="head">Sensor Owner</th>
					<th class="head">Operation</th>
				</tr>
			</thead>
			<tbody valign="top">
				<tr class="row-even" ng-repeat="s in sensors">
					<td>
						<p>{{s.id}}</p>
					</td>
					<td>
						<p>{{s.sensorName}}</p>
					</td>
					<td>
						<p>{{s.sensorOwnerUsername}}</p>
					</td>
					<td>
						<p>
						<div class="btn-group btn-group-xs" role="group"
							aria-label="Operation">
							<button type="button" class="btn btn-default" ng-click="deleteSensor(s)">remove</button>
							<button type="button" class="btn btn-default" ng-click="viewData(s)">ViewData</button>
							<button type="button" class="btn btn-default" ng-click="stopSensor(s)">Stop</button>
						</div>
						</p>
					</td>
				</tr>
			</tbody>
		</table>

	</div>
</div>