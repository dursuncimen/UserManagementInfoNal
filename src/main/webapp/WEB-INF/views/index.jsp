<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Users Management Web Application</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/materialize.min.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/styles.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<div class="container">


		<h1 class="headline">
			<span class="text-blue">&lt;</span>Users<span class="text-blue">&gt;</span>
			<span class="yellow-text">Management</span>
		</h1>
		<h2>
			Created by <a
				href="https://www.linkedin.com/in/dursun-%C3%A7imen-8439a557/"
				target="_blank">Dursun ÇİMEN</a>
		</h2>
		<!-- Modal Structure -->
		<!-- Modal Trigger -->
		<a class="waves-effect waves-light btn right" href="#createModal">Kullanıcı
			Ekle</a>


		<table class="users-table ">
			<thead>
				<tr>
					<th><h1>Adı</h1></th>
					<th><h1>Soyadı</h1></th>
					<th><h1>Telefon</h1></th>
					<th><h1>İşlemler</h1></th>
				</tr>
			</thead>
			<tbody class="table-body">



			</tbody>
		</table>
	</div>
	<!-- Delete Modal  -->
	<div id="deleteModal" class="modal">
		<div class="modal-content">
			<h4>Silme İşlemini Onaylıyor musunuz?</h4>
			<p>
				<b id="delete-details"></b> İsimli kullanıcıyı silmek istiyor
				musunuz?
			</p>
		</div>
		<div class="modal-footer">
			<a href="#!"
				class="modal-action modal-close waves-effect  red btn-flat delete-success">Evet</a>
			<a href="#!"
				class="modal-action modal-close waves-effect waves-green btn-flat ">Hayır</a>

		</div>
	</div>


	<!-- Create Modal  -->
	<div id="createModal" class="modal">
		<form id="createForm">
			<div class="modal-content">
				<h4 id="modal-head">Yeni Kullanıcı</h4>
			<input id="userId" type="hidden" >
				<div class="input-field col s12">
					<input placeholder="Adı" id="firstName" type="text"
						class="validate" required>
				</div>
				<div class="input-field col s12">
					<input placeholder="Soyadı" id="surName" type="text"
						class="validate" required>
				</div>
				<div class="input-field col s12">
					<input placeholder="Telefon" id="phone" type="text"
						class="validate" required>
				</div>

				<div class="input-field col s12" id="recaptcha-body">
					<div class="g-recaptcha"
						data-sitekey="6LchNSMUAAAAAHMG_dCn5pgTnyC2lz4EvQC70uC9"></div>
						<span class="red-text" id="g-recaptcha-info"></span>
				</div>


			</div>
			<div class="modal-footer">
				<input type="submit"
					class="modal-action  waves-effect  green btn-flat create" value="Kaydet"/>
				<a href="#!"
					class="modal-action modal-close waves-effect waves-green btn-flat cancel ">İptal</a>

			</div>
		</form>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src='https://www.google.com/recaptcha/api.js'></script>
		<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/materialize.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/jquery.maskedinput.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/resources/js/app.js"></script>


</body>
</html>
