<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="section">
	<h1>Add Sensor</h1>
	<div class="section" id="getting-started">

		<form class="form-horizontal">
			<div class="form-group">
				<label for="firstName" class="col-sm-4 control-label">Sensor Name:</label>
				<div class="col-sm-5">
					<input type="text" class="form-control"
						   id="firstName" placeholder="Sensor Type" name="name" ng-model="sensor.sensorName">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-4">
					<button type="button" class="btn btn-default" ng-click="addSensor()" ng-disabled="!sensor.sensorName">
						Add Sensor
					</button>
				</div>
			</div>
		</form>

	</div>
</div>