$(document).ready(function() {
					var userId;
					var url="http://localhost:8080/usermanagement"
					$(function() {
						$('.modal').modal();
						$('.trigger-modal').modal();
						getAllUsers();
						$("#phone").mask("(999) 999-9999");
					});

					$("#createForm").submit(function(event) {										
										event.preventDefault();
										if (grecaptcha.getResponse().length == 0 && $('#userId').val() == '') {
											$('#g-recaptcha-info').text("Lütfen ReCaptcha'yi doğrulayınız!!");
										} else {
											$('#createModal').modal('close');
											openPreloaderForProgress();
											var userData = {
												id : $("#userId").val(),											
												firstName : $("#firstName").val(),
												surName : $("#surName").val(),
												phone : $("#phone").val()
											}
											$.ajax({	type : "POST",
														contentType : "application/json",
														url : url + "/users/add",
														data : JSON.stringify(userData),
														dataType : 'json',
														success : function(result) {
															Materialize.toast('İşlem Başarılı!',4000);
															getAllUsers();
															console.log(result);
														},
														error : function(e) {
															Materialize.toast('İşlem Başarısız!',4000);
															console.log("ERROR: ",e);
														}
													});
											resetForm();
											closePreloaderForProgress();
										}
									});

					function getAllUsers() {
						$(".table-body").empty();
						$.get(url + "/users/list",function(data) {
											$.each(data,function(i, user) {
																$(".table-body").append("<tr data-id=\""
																						+ user.id
																						+ "\" data-firstName=\""
																						+ user.firstName
																						+ "\" data-surName=\""
																						+ user.surName
																						+ "\" data-phone=\""
																						+ user.phone
																						+ "\" >"
																						+ "<td>"
																						+ user.firstName
																						+ "</td>"
																						+ "<td >"
																						+ user.surName
																						+ "</td>"
																						+ "<td>"
																						+ user.phone
																						+ "</td>"
																						+ "<td width='200'>   <a class='waves-effect waves-light btn orange edit'>     <i class='fa fa-edit'></i> </a>  <a class='waves-effect waves-light btn red delete'  >     <i class='fa fa-times-circle-o'></i> </a></td></tr>");
															});
										});
					}
					$(document).on('click',"a.cancel",function() {
								resetForm();	
							});
					$(document).on('click',"a.edit",function() {
								$('#userId').val($(this).closest('tr').attr('data-id'));
								$('#firstName').val($(this).closest('tr').attr('data-firstName'));
								$('#surName').val($(this).closest('tr').attr('data-surName'));
								$('#phone').val($(this).closest('tr').attr('data-phone'));
								$('#modal-head').text("Kullanıcıyı Düzenle");
								$('#createForm').modal('open');
								$('#recaptcha-body').hide();
							});

					$(document).on('click',"a.delete",function() {
								userId = $(this).closest('tr').attr('data-id');
								var name = $(this).closest('tr').attr('data-firstName')+ " "+ $(this).closest('tr').attr('data-surName');
								$('#delete-details').text(name);
								$('#deleteModal').modal('open');
							});

					$(document).on('click',"a.delete-success",function() {
										openPreloaderForProgress();
										$.get(url + "/users/delete/"+ userId,function(data, status) {
															if (status == "success") {
																Materialize.toast('İşlem Başarılı!',4000);
																getAllUsers();
															} else {
																Materialize.toast('İşlem Başarısız!',4000);
															}
														});
										closePreloaderForProgress();
									});

					function openPreloaderForProgress() {
						$('body')
								.append(
										'<div class=\"modal-overlay\" style=\"z-index: 1002; display: block; opacity: 0.7;\"></div>');
						$('body')
								.append(
										'<div class=\"progress-message\"><h1>İşleminiz gerçekleştiriliyor</h1></div>');
						$('body')
								.append(
										'<div class=\"progress\"><div class=\"indeterminate\"></div></div>');
					}

					function closePreloaderForProgress() {
						$(".modal-overlay").remove();
						$(".progress-message").remove();
						$(".progress").remove();
					}					
					
					function resetForm() {
						$("#userId").val("");
						$("#firstName").val("");
						$("#surName").val("");
						$("#phone").val("");
						$('#recaptcha-body').show();
						grecaptcha.reset();
					}

				})