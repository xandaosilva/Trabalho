var categoriaModule = angular.module("categoriaModule",[]);

categoriaModule.controller("categoriaController", function($scope,$http) {
	url = "http://localhost:8080/Trabalho/rs/categoria";
	
	$scope.novo = function(){
		$scope.categoria = "";
	}

	$scope.seleciona = function(categoria){
		$scope.categoria = categoria;
	}
	
//	$scope.selecionaModalidade = function(modalidade){
//		$scope.categoria.modalidade = modalidade;
//	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(categorias) {
			$scope.categorias = categorias;
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.categoria.codigo === ""){
			$http.post(url,$scope.categoria).success(function(categoria) {
				$scope.categoria.push(categoria);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
		else{
			$hhtp.put(url,$scope.categoria).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	}
	
	$scope.excluir = function(){
		if($scope.categoria.codigo === ""){
			alert("Selecione alguma categoria");
		}
		else{
			urlAux = url + "/" + $scope.categoria.codigo;
			$http.delete(urlAux).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(mensagemErro) {
				alert(mensagemErro);
			});
		}
	}
	
	$scope.pesquisar();
});