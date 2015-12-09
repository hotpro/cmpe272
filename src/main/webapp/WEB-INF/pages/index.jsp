<!--wj create 12/08/2015  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">

<head>

<base href=" <%=basePath%>" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
	<meta name="_csrf" content="${_csrf.token}"/>
	<!-- default header name is X-CSRF-TOKEN -->
	<meta name="_csrf_header" content="${_csrf.headerName}"/>

<title>Food Management</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="resources/css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript" src="resources/angular.js"></script>
<script type="text/javascript" src="resources/angular-route.js"></script>
<script type="text/javascript" src="resources/userApp.js"></script>

	<!--jquery-->
	<script src="resources/js/jquery.js"></script>

	<script>
//		$.ajaxSetup({
//			data: {csrfmiddlewaretoken: '{{ csrf_token }}' },
//		});
		$.ajaxSetup( {
			beforeSend: function ( xhr ) {
				var token = $("meta[name='_csrf']").attr("content");
				var header = $("meta[name='_csrf_header']").attr("content");
				xhr.setRequestHeader(header, token );
			}
		});
	</script>

	<!-- highchart -->
	<script src="resources/js/plugins/highcharts/highcharts.js"></script>
</head>

<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="user/#/index.html">Food Management
					Platform</a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-envelope"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu message-dropdown">
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong>Administrator</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong> Administrator</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong>Administrator</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-footer"><a href="#">Read All New
								Messages</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-bell"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu alert-dropdown">
						<li><a href="#">Alert Name <span
								class="label label-default">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-primary">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-success">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span class="label label-info">Alert
									Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-warning">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-danger">Alert Badge</span></a></li>
						<li class="divider"></li>
						<li><a href="#">View All</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> Administrator
						<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
						</li>
						<li><a href="#"><i class="fa fa-fw fa-envelope"></i>
								Inbox</a></li>
						<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="login-1.html"><i
								class="fa fa-fw fa-power-off"></i> Log Out</a></li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li class="active"><a class="reference internal"
						href="user/#/index"><i class="fa fa-fw fa-dashboard"></i>
							Dashboard</a></li>
					<li><a href="javascript:;" data-toggle="collapse"
						data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Food
							Query <i class="fa fa-fw fa-caret-down"></i></a>
						<ul id="demo" class="collapse">
							<li><a href="user/foodList.html" class = "disinline">Food List</a></li>
							<li><a href="user/3weekslist.html">3 weeks left food</a></li>
							<li><a href="user/2weekslist.html">2 weeks left food</a></li>
							<li><a href="user/1weeklist.html">1 week left food</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">
							Dashboard
						</h1>
						<ol class="breadcrumb">
							<li class="active"><i class="fa fa-dashboard"></i> Statistics Overview
							</li>
						</ol>
					</div>
				</div>


				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-bar-chart-o fa-fw"></i> Chart1
								</h3>
							</div>
							<div id="container-hc1" style="width: 750px; height: 400px; margin: 0 auto"></div>
						</div>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-bar-chart-o fa-fw"></i> Chart2
								</h3>
							</div>
							<div id="container-hc2" style="width: 750px; height: 400px; margin: 0 auto"></div>
						</div>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-bar-chart-o fa-fw"></i> Chart3
								</h3>
							</div>
							<div id="container-hc3" style="width: 750px; height: 400px; margin: 0 auto"></div>
						</div>
					</div>
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<i class="fa fa-bar-chart-o fa-fw"></i> Chart4
								</h3>
							</div>
							<div id="container-hc4" style="width: 750px; height: 400px; margin: 0 auto"></div>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- /#page-wrapper -->

		</div>
		<!-- /#wrapper -->
	</div>
	<!-- /#wrapper -->
		<!-- Bootstrap Core JavaScript -->
		<script src="resources/js/bootstrap.min.js"></script>

		<!--highchart1 -->
		<script language="JavaScript">
			$(document).ready(function() {
				var title = {
					text: 'Monthly Donated Food Value (Year 2010 to Year 2015)'
				};
				var xAxis = {
					categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
						'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
				};
				var yAxis = {
					title: {
						text: ' Value = UintPrice * Sales ($) '
					},
					plotLines: [{
						value: 0,
						width: 1,
						color: '#808080'
					}]
				};

				var tooltip = {
					valueSuffix: '$'
				}

				var legend = {
					layout: 'vertical',
					align: 'right',
					verticalAlign: 'middle',
					borderWidth: 0
				};

				var series =  [
					{
						name: '2010',
						data: [700, 690, 950, 1450, 1820, 2150, 2520,
							2650, 2330, 1830, 1390, 960]
					},
					{
						name: '2012',
						data: [90, 60, 350, 840, 1350, 1700, 1860,
							1790, 1430, 900, 390, 100]
					},
					{
						name: '2013',
						data: [190, 320, 470, 850, 1190, 1520, 1400,
							1660, 1020, 630, 160, 180]
					},
					{
						name: '2014',
						data: [210, 420, 570, 850, 1190, 1520, 1500,
							1060, 1220, 830, 260, 280]
					},
					{
						name: '2015',
						data: [290, 220, 270, 850, 1190, 1520, 1700,
							1660, 1420, 1030, 660, 0]
					}
				];

				var json = {};

				json.title = title;
				json.xAxis = xAxis;
				json.yAxis = yAxis;
				json.tooltip = tooltip;
				json.legend = legend;
				json.series = series;

				$('#container-hc1').highcharts(json);
			});
		</script>
		<!--highchart2 -->
		<script language="JavaScript">
			$(document).ready(function() {
				var chart = {
					type: 'bar'
				};
				var title = {
					text: 'Top 5 Discount Strategy (Year 2013 to Year 2015)'
				};
				var xAxis = {
					categories: ['1 % OFF', '5 % OFF', '3 % OFF', '9 % OFF', '4 % OFF'],
					title: {
						text: null
					}
				};
				var yAxis = {
					min: 0,
					title: {
						text: ' Value = UintPrice * Sales ($) ',
						align: 'high'
					},
					labels: {
						overflow: 'justify'
					}
				};
				var tooltip = {
					valueSuffix: '$'
				};
				var plotOptions = {
					bar: {
						dataLabels: {
							enabled: true
						}
					}
				};
				var legend = {
					layout: 'vertical',
					align: 'right',
					verticalAlign: 'top',
					x: -40,
					y: 100,
					floating: true,
					borderWidth: 1,
					backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
					shadow: true
				};
				var credits = {
					enabled: false
				};

				var series= [{
					name: 'Year 2013',
					data: [15500, 28100, 23500, 20300, 20000]
				}, {
					name: 'Year 2014',
					data: [16600, 15600, 24700, 10800, 36000]
				}, {
					name: 'Year 2015',
					data: [17200, 21400, 30500, 13200, 34000]
				}
				];

				var json = {};
				json.chart = chart;
				json.title = title;
				json.tooltip = tooltip;
				json.xAxis = xAxis;
				json.yAxis = yAxis;
				json.series = series;
				json.plotOptions = plotOptions;
				json.legend = legend;
				json.credits = credits;
				$('#container-hc2').highcharts(json);

			});
		</script>
		<!--highchart3 -->
		<script language="JavaScript">
			$(document).ready(function() {

				var title = {
					text: 'Average Value of Donated Food (Year 2015)'
				};
				var xAxis = {
					categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
						'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
				};
				var labels = {
					items: [{
						html: 'Donated Food Value',
						style: {
							left: '10px',
							top: '0px',
							color: (Highcharts.theme && Highcharts.theme.textColor) || 'black'
						}
					}]
				};

				var series= [{
					type: 'column',
					name: 'grocery store1',
					data: [290, 220, 270, 850, 1190, 1520, 1700,
						1660, 1420, 1030, 660, 100]
				}, {
					type: 'column',
					name: 'grocery store2',
					data: [90, 320, 470, 650, 1090, 1320, 1400,
						1000, 1220, 930, 460, 80]
				}, {
					type: 'column',
					name: 'grocery store3',
					data: [190, 120, 370, 650, 890, 1420, 1200,
						1560, 1720, 630, 660, 120]
				}, {
					type: 'spline',
					name: 'Average',
					data: [190, 220, 360, 710, 1050, 1420, 1430, 1460, 1450, 860, 590, 100],
					marker: {
						lineWidth: 2,
						lineColor: Highcharts.getOptions().colors[3],
						fillColor: 'white'
					}
				}, {
					type: 'pie',
					name: 'Donated Food Value (Year 2015)',
					data: [{
						name: 'grocery store1',
						y: 10910,
						color: Highcharts.getOptions().colors[0]
					}, {
						name: 'grocery store2',
						y: 9030,
						color: Highcharts.getOptions().colors[1]
					}, {
						name: 'grocery store3',
						y: 9530,
						color: Highcharts.getOptions().colors[2]
					}],
					center: [60, 50],
					size: 100,
					showInLegend: false,
					dataLabels: {
						enabled: false
					}
				}
				];


				var json = {};
				json.title = title;
				json.xAxis = xAxis;
				json.labels = labels;
				json.series = series;
				$('#container-hc3').highcharts(json);
			});
		</script>
		<!--highchart4 -->
		<script language="JavaScript">
			$(document).ready(function() {
				var chart = {
					type: 'spline',
					animation: Highcharts.svg,
					marginRight: 10,
					events: {
						load: function () {
							// set up the updating of the chart each second
							var series = this.series[0];
							setInterval(function () {
								var x = (new Date()).getTime(), // current time
										y = Math.random();
								series.addPoint([x, y], true, true);
							}, 5000);
						}
					}
				};
				var title = {
					text: 'Real-time Sales Data Under Current Strategy (Year 2015)'
				};
				var xAxis = {
					type: 'datetime',
					tickPixelInterval: 150
				};
				var yAxis = {
					title: {
						text: 'Sales Simulated Data (%)'
					},
					plotLines: [{
						value: 0,
						width: 1,
						color: '#808080'
					}]
				};
				var tooltip = {
					formatter: function () {
						return '<b>' + this.series.name + '</b><br/>' +
								Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
								Highcharts.numberFormat(this.y, 2);
					}
				};
				var plotOptions = {
					area: {
						pointStart: 1940,
						marker: {
							enabled: false,
							symbol: 'circle',
							radius: 2,
							states: {
								hover: {
									enabled: true
								}
							}
						}
					}
				};
				var legend = {
					enabled: false
				};
				var exporting = {
					enabled: false
				};
				var series= [{
					name: 'Random data',
					data: (function () {
						// generate an array of random data
						var data = [],time = (new Date()).getTime(),i;
						for (i = -19; i <= 0; i += 1) {
							data.push({
								x: time + i * 1000,
								y: Math.random()
							});
						}
						return data;
					}())
				}];

				var json = {};
				json.chart = chart;
				json.title = title;
				json.tooltip = tooltip;
				json.xAxis = xAxis;
				json.yAxis = yAxis;
				json.legend = legend;
				json.exporting = exporting;
				json.series = series;
				json.plotOptions = plotOptions;


				Highcharts.setOptions({
					global: {
						useUTC: false
					}
				});
				$('#container-hc4').highcharts(json);

			});
		</script>
</body>

</html>
