function displayClients() {
	$('.cnttable').DataTable().clear().draw();
	$
			.get(
					ctx + "/clients",
					function(clientsData) {
						$('.cnttable')
								.DataTable(
										{
											"data" : clientsData,
											"responsive" : true,
											"bRetreive" : true,
											"bDestroy" : true,
											"searching" : false,
											"paging" : true,
											"info" : false,
											"filter" : false,
											"ordering" : false,
											"bLengthChange" : false,
											"columns" : [
													{
														"data" : null,
														"render" : function(
																data, type,
																full, meta) {
															return meta.row + 1;
														},
													},
													{
														"data" : "clientName"
													},
													{
														"data" : "clientLocation"
													},
													{
														"data" : null,
														"render" : function(
																data, type,
																full, meta) {
															return "<a title='EDIT' class='pointer' id='clientedit_"
																	+ data.clientId
																	+ "'><i class='fa fa-pencil-square-o'></i></a>";
														}
													}, ]
										});
					});
}